package com.frogobox.kickstart.di

import androidx.preference.PreferenceManager
import com.frogobox.kickstart.source.ProjectDataRepository
import com.frogobox.kickstart.source.local.ProjectAppDatabase
import com.frogobox.kickstart.source.local.ProjectLocalDataSource
import com.frogobox.kickstart.source.remote.ProjectRemoteDataSource
import com.frogobox.sdk.util.AppExecutors
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/*
 * Created by Faisal Amir on 23/10/2020
 * KickStartProject Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2020 FrogoBox Inc.      
 * All rights reserved
 *
 */

val repositoryModule = module {

    single {
        PreferenceManager.getDefaultSharedPreferences(androidContext())
    }

    single {
        ProjectAppDatabase.getInstance(androidContext()).favoriteScriptDao()
    }

    single {
        ProjectLocalDataSource(AppExecutors(), get(), get())
    }

    single {
        ProjectDataRepository(ProjectRemoteDataSource, get())
    }

}