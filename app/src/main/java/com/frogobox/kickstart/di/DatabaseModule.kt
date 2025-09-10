package com.frogobox.kickstart.di

import android.content.Context
import com.frogobox.kickstart.domain.db.ProjectDatabase
import com.frogobox.kickstart.domain.db.dao.MealDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): ProjectDatabase =
        ProjectDatabase.getInstance(context)

    @Provides
    fun provideMealDao(database: ProjectDatabase): MealDao = database.mealDao()

}