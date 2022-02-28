package com.frogobox.kickstart.source.remote.network

import com.frogobox.kickstart.BuildConfig
import com.frogobox.kickstart.FrogoApplication
import com.frogobox.kickstart.util.Constant
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

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
object FrogoApiClient {

    fun create(): FrogoApiService {
        val mLoggingInterceptor = HttpLoggingInterceptor()
        mLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val mClient = if (BuildConfig.DEBUG) {
            OkHttpClient.Builder()
                .addInterceptor(mLoggingInterceptor)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()
        } else {
            OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()
        }

        return Retrofit.Builder()
            .baseUrl(Constant.ApiUrl.NEWS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(mClient)
            .build().create(FrogoApiService::class.java)
    }

}