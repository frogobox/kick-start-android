package com.frogobox.kickstart.source.remote.network

import com.frogobox.coreapi.news.NewsUrl
import com.frogobox.coresdk.source.FrogoApiClient
import com.frogobox.kickstart.ProjectApplication
import com.frogobox.kickstart.util.appIsDebug
import com.frogobox.sdk.ext.usingChuck

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

    fun createNewsApiService(): NewsApiService {
        return FrogoApiClient.create(
            NewsUrl.BASE_URL, appIsDebug,
            ProjectApplication.getContext().usingChuck()
        )
    }

}