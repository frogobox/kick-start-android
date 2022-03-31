package com.frogobox.kickstart.source.remote.network

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.frogobox.coreapi.news.NewsConstant
import com.frogobox.coreapi.news.NewsUrl
import com.frogobox.coresdk.FrogoApiClient
import com.frogobox.kickstart.BuildConfig
import com.frogobox.kickstart.ProjectApplication
import com.frogobox.kickstart.util.Constant

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * PublicSpeakingBooster
 * Copyright (C) 16/08/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.publicspeakingbooster.source.remote.network
 *
 */
object ProjectApiClient {

    fun create(): ProjectApiService {
        return FrogoApiClient.create(
            NewsUrl.BASE_URL,
            BuildConfig.DEBUG,
            ChuckerInterceptor(ProjectApplication.getContext())
        )
    }

}