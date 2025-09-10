package com.frogobox.kickstart.domain.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.frogobox.kickstart.common.ext.appDatabaseName
import com.frogobox.kickstart.common.ext.appIsDebug
import com.frogobox.kickstart.domain.db.dao.MealDao
import com.frogobox.kickstart.domain.model.MealModel

/**
 * Created by Faisal Amir
 * Frogobox Inc License
 * -----------------------------------------
 * Copyright (C) 26/08/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * Frogobox Software Industries
 *
 *
 */

@Database(
    entities = [
        (MealModel::class)
    ],
    version = 1,
    exportSchema = true,
)
abstract class ProjectDatabase : RoomDatabase() {

    abstract fun mealDao(): MealDao

    companion object {

        @Volatile
        private var INSTANCE: ProjectDatabase? = null

        fun getInstance(context: Context): ProjectDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also {
                    INSTANCE = it
                }
            }

        private fun buildDatabase(context: Context): ProjectDatabase {
            return if (appIsDebug) {
                Room.databaseBuilder(
                    context.applicationContext,
                    ProjectDatabase::class.java,
                    appDatabaseName
                )
                    .fallbackToDestructiveMigration(true) // FOR DEVELOPMENT ONLY !!!!
                    .build()
            } else {
                Room.databaseBuilder(
                    context.applicationContext,
                    ProjectDatabase::class.java,
                    appDatabaseName
                )
                    .build()
            }
        }
    }
}