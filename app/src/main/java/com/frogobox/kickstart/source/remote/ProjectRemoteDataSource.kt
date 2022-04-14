package com.frogobox.kickstart.source.remote

import android.util.Log
import com.frogobox.api.news.ConsumeNewsApi
import com.frogobox.coreapi.ConsumeApiResponse
import com.frogobox.coreapi.news.response.ArticleResponse
import com.frogobox.coreapi.news.response.SourceResponse
import com.frogobox.coresdk.response.FrogoDataResponse
import com.frogobox.kickstart.source.ProjectDataSource
import com.frogobox.kickstart.source.model.Favorite
import com.frogobox.kickstart.source.remote.network.ProjectApiClient
import com.frogobox.kickstart.util.SingleFunc.noAction
import com.frogobox.sdk.ext.doApiRequest

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
 * com.frogobox.publicspeakingbooster.source.remote
 *
 */
object ProjectRemoteDataSource : ProjectDataSource {

    override fun getTopHeadline(
        apiKey: String,
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: ProjectDataSource.GetRemoteCallback<ArticleResponse>
    ) {
        ProjectApiClient.create().getTopHeadline(
            apiKey,
            q,
            sources,
            category,
            country,
            pageSize,
            page
        ).doApiRequest(object : FrogoDataResponse<ArticleResponse> {
            override fun onFailed(statusCode: Int, errorMessage: String) {
                callback.onFailed(statusCode, errorMessage)
            }

            override fun onFinish() {}

            override fun onHideProgress() {
                callback.onHideProgress()
            }

            override fun onShowProgress() {
                callback.onShowProgress()
            }

            override fun onSuccess(data: ArticleResponse) {
                callback.onSuccess(data)
            }
        }) {
        }
    }

    override fun getEverythings(
        apiKey: String,
        q: String?,
        from: String?,
        to: String?,
        qInTitle: String?,
        sources: String?,
        domains: String?,
        excludeDomains: String?,
        language: String?,
        sortBy: String?,
        pageSize: Int?,
        page: Int?,
        callback: ProjectDataSource.GetRemoteCallback<ArticleResponse>
    ) {
        ProjectApiClient.create().getEverythings(
            apiKey,
            q,
            from,
            to,
            qInTitle,
            sources,
            domains,
            excludeDomains,
            language,
            sortBy,
            pageSize,
            page
        ).doApiRequest(object : FrogoDataResponse<ArticleResponse> {
            override fun onFailed(statusCode: Int, errorMessage: String) {
                callback.onFailed(statusCode, errorMessage)
            }

            override fun onFinish() {}

            override fun onHideProgress() {
                callback.onHideProgress()
            }

            override fun onShowProgress() {
                callback.onShowProgress()
            }

            override fun onSuccess(data: ArticleResponse) {
                callback.onSuccess(data)
            }
        }) {
        }
    }

    override fun getSources(
        apiKey: String,
        language: String,
        country: String,
        category: String,
        callback: ProjectDataSource.GetRemoteCallback<SourceResponse>
    ) {
        ProjectApiClient.create().getSources(apiKey, language, country, category)
            .doApiRequest(object : FrogoDataResponse<SourceResponse> {
                override fun onFailed(statusCode: Int, errorMessage: String) {
                    callback.onFailed(statusCode, errorMessage)
                }

                override fun onFinish() {}

                override fun onHideProgress() {
                    callback.onHideProgress()
                }

                override fun onShowProgress() {
                    callback.onShowProgress()
                }

                override fun onSuccess(data: SourceResponse) {
                    callback.onSuccess(data)
                }
            }) {
            }

    }


    override fun saveRoomFavorite(data: Favorite): Boolean {
        return noAction()
    }


    override fun getRoomFavorite(callback: ProjectDataSource.GetLocalCallback<List<Favorite>>) {
        noAction()
    }

    override fun updateRoomFavorite(
        tableId: Int,
        title: String,
        description: String,
        dateTime: String
    ): Boolean {
        return noAction()
    }

    override fun deleteRoomFavorite(tableId: Int): Boolean {
        return noAction()
    }

    override fun nukeRoomFavorite(): Boolean {
        return noAction()
    }

    override fun consumeTopHeadline(
        apiKey: String,
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: ProjectDataSource.GetRemoteCallback<ArticleResponse>
    ) {
        val consumeNewsApi = ConsumeNewsApi(apiKey)
        consumeNewsApi.getTopHeadline( // Adding Base Parameter on main function
            q,
            sources,
            category,
            country,
            pageSize,
            page,
            object : ConsumeApiResponse<ArticleResponse> {
                override fun onShowProgress() {
                    // Your Progress Show
                    Log.d("RxJavaShow", "Show Progress")
                    callback.onShowProgress()
                }

                override fun onHideProgress() {
                    // Your Progress Hide
                    Log.d("RxJavaHide", "Hide Progress")
                    callback.onHideProgress()
                }

                override fun onFailed(statusCode: Int, errorMessage: String) {
                    // Your failed to do
                    callback.onFailed(statusCode, errorMessage)
                }

                override fun onFinish() {
                    // Your finish to do
                }

                override fun onSuccess(data: ArticleResponse) {
                    // Your Ui or data
                    callback.onSuccess(data)
                }
            })
    }


}