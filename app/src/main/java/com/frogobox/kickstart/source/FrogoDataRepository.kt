package com.frogobox.kickstart.source


import android.content.Context
import com.frogobox.kickstart.mvvm.model.ArticleResponse
import com.frogobox.kickstart.mvvm.model.Fashion
import com.frogobox.kickstart.mvvm.model.Favorite
import com.frogobox.kickstart.mvvm.model.SourceResponse
import com.frogobox.kickstart.source.local.FrogoLocalDataSource
import com.frogobox.kickstart.source.remote.FrogoRemoteDataSource

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
open class FrogoDataRepository(
    private val remoteDataSource: FrogoRemoteDataSource,
    private val localDataSource: FrogoLocalDataSource
) : FrogoDataSource {
    override fun usingChuckInterceptor(context: Context) {
        remoteDataSource.usingChuckInterceptor(context)
    }

    override fun getTopHeadline(
        apiKey: String,
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: FrogoDataSource.GetRemoteCallback<ArticleResponse>
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
        callback: FrogoDataSource.GetRemoteCallback<ArticleResponse>
    ) {
        remoteDataSource.getEverythings(
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
            page,
            callback
        )
    }

    override fun getSources(
        apiKey: String,
        language: String,
        country: String,
        category: String,
        callback: FrogoDataSource.GetRemoteCallback<SourceResponse>
    ) {
        remoteDataSource.getSources(apiKey, language, country, category, callback)
    }


    override fun saveRoomFavorite(data: Favorite): Boolean {
        return localDataSource.saveRoomFavorite(data)
    }

    override fun getRoomData(callback: FrogoDataSource.GetRoomDataCallBack<List<Fashion>>) {
        localDataSource.getRoomData(callback)
    }

    override fun getRoomFavorite(callback: FrogoDataSource.GetRoomDataCallBack<List<Favorite>>) {
        localDataSource.getRoomFavorite(callback)
    }

    override fun updateRoomFavorite(
        tableId: Int,
        title: String,
        description: String,
        dateTime: String
    ): Boolean {
        return localDataSource.updateRoomFavorite(tableId, title, description, dateTime)
    }

    override fun searchRoomFavorite(
        scriptId: String,
        callback: FrogoDataSource.GetRoomDataCallBack<List<Favorite>>
    ) {
        localDataSource.searchRoomFavorite(scriptId, callback)
    }

    override fun deleteRoomFavorite(tableId: Int): Boolean {
        return localDataSource.deleteRoomFavorite(tableId)
    }

    override fun nukeRoomFavorite(): Boolean {
        return localDataSource.nukeRoomFavorite()
    }

    companion object {

        private var INSTANCE: FrogoDataRepository? = null

        /**
         * Returns the single instance of this class, creating it if necessary.

         * @param FrogoRemoteDataSource backend data source
         * *
         * @return the [FrogoRepository] instance
         */
        @JvmStatic
        fun getInstance(
            FrogoRemoteDataSource: FrogoRemoteDataSource,
            gitsLocalDataSource: FrogoLocalDataSource
        ) =
            INSTANCE ?: synchronized(FrogoDataRepository::class.java) {
                INSTANCE ?: FrogoDataRepository(FrogoRemoteDataSource, gitsLocalDataSource)
                    .also { INSTANCE = it }
            }

        /**
         * Used to force [getInstance] to create a new instance
         * next time it's called.
         */
        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }

}