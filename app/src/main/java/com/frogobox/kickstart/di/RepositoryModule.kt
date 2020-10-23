package com.frogobox.kickstart.di

import android.content.Context
import androidx.preference.PreferenceManager
import com.frogobox.kickstart.source.FrogoDataRepository
import com.frogobox.kickstart.source.local.FrogoAppDatabase
import com.frogobox.kickstart.source.local.FrogoLocalDataSource
import com.frogobox.kickstart.source.local.dao.FashionDao
import com.frogobox.kickstart.source.local.dao.FavoriteDao
import com.frogobox.kickstart.source.remote.FrogoRemoteDataSource
import com.frogobox.kickstart.util.AppExecutors
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
        FrogoDataRepository(FrogoRemoteDataSource, get())
    }

    single {
        FrogoLocalDataSource(AppExecutors(), get(), get(), get())
    }

    single {
        PreferenceManager.getDefaultSharedPreferences(androidContext())
    }

    single {
        FrogoAppDatabase.getInstance(androidContext()).fashionDao()
    }

    single {
        FrogoAppDatabase.getInstance(androidContext()).favoriteScriptDao()
    }


}