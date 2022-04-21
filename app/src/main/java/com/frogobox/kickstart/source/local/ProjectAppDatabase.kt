package com.frogobox.kickstart.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.frogobox.kickstart.model.Favorite
import com.frogobox.kickstart.source.local.dao.FavoriteDao
import com.frogobox.kickstart.util.appDatabaseName
import com.frogobox.kickstart.util.appIsDebug

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * BaseMusicPlayer
 * Copyright (C) 26/08/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.basemusicplayer.source.local
 *
 */
@Database(
    entities = [
        (Favorite::class)
    ], version = 1
)

abstract class ProjectAppDatabase : RoomDatabase() {

    abstract fun favoriteScriptDao(): FavoriteDao

    companion object {

        @Volatile
        private var INSTANCE: ProjectAppDatabase? = null

        fun getInstance(context: Context): ProjectAppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also {
                    INSTANCE = it
                }
            }

        private fun buildDatabase(context: Context): ProjectAppDatabase {
            return if (appIsDebug) {
                Room.databaseBuilder(
                    context.applicationContext,
                    ProjectAppDatabase::class.java,
                    appDatabaseName
                )
                    .addMigrations(MIGRATION_2_3)
                    .fallbackToDestructiveMigration() // FOR DEVELOPMENT ONLY !!!!
                    .build()
            } else {
                Room.databaseBuilder(
                    context.applicationContext,
                    ProjectAppDatabase::class.java,
                    appDatabaseName
                )
                    .addMigrations(MIGRATION_2_3)
                    .build()
            }
        }

        private val MIGRATION_2_3: Migration = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {

            }
        }
    }
}