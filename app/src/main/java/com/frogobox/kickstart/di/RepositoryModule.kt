package com.frogobox.kickstart.di

import com.frogobox.coreapi.news.NewsUrl
import com.frogobox.coresdk.source.FrogoApiClient
import com.frogobox.kickstart.source.ProjectDataRepository
import com.frogobox.kickstart.source.local.ProjectAppDatabase
import com.frogobox.kickstart.source.local.ProjectLocalDataSource
import com.frogobox.kickstart.source.remote.ProjectRemoteDataSource
import com.frogobox.kickstart.source.remote.network.NewsApiService
import com.frogobox.kickstart.util.appIsDebug
import com.frogobox.kickstart.util.appPrefName
import com.frogobox.sdk.ext.usingChuck
import com.frogobox.sdk.preference.FrogoPreference
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
        FrogoPreference(androidContext(), appPrefName)
    }

    single {
        FrogoApiClient.create<NewsApiService>(
            NewsUrl.BASE_URL,
            appIsDebug,
            androidContext().usingChuck()
        )
    }

    single {
        ProjectAppDatabase.getInstance(androidContext()).favoriteScriptDao()
    }

    single {
        ProjectLocalDataSource(AppExecutors(), get(), get())
    }

    single {
        ProjectRemoteDataSource(get(), get(), get(), get(), get(), get())
    }

    single {
        ProjectDataRepository(get(), get())
    }

}