package com.frogobox.kickstart.source.remote

import com.frogobox.api.meal.ConsumeTheMealDbApi
import com.frogobox.api.movie.ConsumeMovieApi
import com.frogobox.api.news.ConsumeNewsApi
import com.frogobox.api.pixabay.ConsumePixabayApi
import com.frogobox.api.sport.ConsumeTheSportDbApi
import com.frogobox.coreapi.news.response.ArticleResponse
import com.frogobox.coresdk.response.FrogoDataResponse
import com.frogobox.kickstart.model.Favorite
import com.frogobox.kickstart.source.ProjectDataSource
import com.frogobox.kickstart.source.callback.ProjectDataCallback
import com.frogobox.kickstart.source.callback.ProjectStateCallback
import com.frogobox.kickstart.source.remote.network.NewsApiService
import com.frogobox.sdk.ext.doApiRequest
import com.frogobox.sdk.source.FrogoRemoteDataSource

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
class ProjectRemoteDataSource(
    val consumeNewsApi: ConsumeNewsApi,
    val consumeMovieApi: ConsumeMovieApi,
    val consumeTheMealDbApi: ConsumeTheMealDbApi,
    val consumeTheSportDbApi: ConsumeTheSportDbApi,
    val consumePixabayApi: ConsumePixabayApi,
    private val newsApiService: NewsApiService
) : FrogoRemoteDataSource(), ProjectDataSource {

    override fun getTopHeadline(
        apiKey: String,
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: ProjectDataCallback<ArticleResponse>
    ) {
        newsApiService.getTopHeadline(
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

            override fun onFinish() {
                callback.onFinish()
            }

            override fun onHideProgress() {
                callback.onHideProgress()
            }

            override fun onShowProgress() {
                callback.onShowProgress()
            }

            override fun onSuccess(data: ArticleResponse) {
                if (data.articles?.isEmpty()!!) {
                    callback.onEmptyData()
                } else {
                    callback.onSuccess(data)
                }
            }
        }) {
            addSubscribe(it)
        }
    }

    override fun saveFavorite(data: Favorite, callback: ProjectStateCallback) {}

    override fun getFavorite(callback: ProjectDataCallback<List<Favorite>>) {}

    override fun updateFavorite(
        tableId: Int,
        title: String,
        description: String,
        dateTime: String
    ) {
    }

    override fun deleteFavorite(tableId: Int, callback: ProjectStateCallback) {}

    override fun nukeFavorite(callback: ProjectStateCallback) {}
}