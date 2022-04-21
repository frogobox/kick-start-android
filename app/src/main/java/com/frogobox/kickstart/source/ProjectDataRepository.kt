package com.frogobox.kickstart.source


import com.frogobox.api.meal.ConsumeTheMealDbApi
import com.frogobox.api.movie.ConsumeMovieApi
import com.frogobox.api.news.ConsumeNewsApi
import com.frogobox.api.pixabay.ConsumePixabayApi
import com.frogobox.api.sport.ConsumeTheSportDbApi
import com.frogobox.coreapi.news.response.ArticleResponse
import com.frogobox.coreapi.news.response.SourceResponse
import com.frogobox.kickstart.model.Favorite
import com.frogobox.kickstart.source.callback.ProjectDataCallback
import com.frogobox.kickstart.source.callback.ProjectStateCallback
import com.frogobox.kickstart.source.local.ProjectLocalDataSource
import com.frogobox.kickstart.source.remote.ProjectRemoteDataSource
import com.frogobox.sdk.source.FrogoRepository

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * BaseMusicPlayer
 * Copyright (C) 18/08/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.basemusicplayer.source
 *
 */

class ProjectDataRepository(
    private val remoteDataSource: ProjectRemoteDataSource,
    private val localDataSource: ProjectLocalDataSource
) : FrogoRepository(remoteDataSource, localDataSource), ProjectDataSource {

    val consumeNewsApi: ConsumeNewsApi = remoteDataSource.consumeNewsApi
    val consumeMovieApi: ConsumeMovieApi = remoteDataSource.consumeMovieApi
    val consumeTheMealDbApi: ConsumeTheMealDbApi = remoteDataSource.consumeTheMealDbApi
    val consumeTheSportDbApi: ConsumeTheSportDbApi = remoteDataSource.consumeTheSportDbApi
    val consumePixabayApi: ConsumePixabayApi = remoteDataSource.consumePixabayApi

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
        remoteDataSource.getTopHeadline(
            apiKey,
            q,
            sources,
            category,
            country,
            pageSize,
            page,
            callback
        )
    }

    override fun saveFavorite(data: Favorite, callback: ProjectStateCallback) {
        
    }

    override fun getFavorite(callback: ProjectDataCallback<List<Favorite>>) {
        
    }

    override fun updateFavorite(
        tableId: Int,
        title: String,
        description: String,
        dateTime: String
    ) {
        
    }

    override fun deleteFavorite(tableId: Int, callback: ProjectStateCallback) {
        
    }

    override fun nukeFavorite(callback: ProjectStateCallback) {
        
    }
}