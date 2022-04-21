package com.frogobox.kickstart.source.local

import com.frogobox.coreapi.news.response.ArticleResponse
import com.frogobox.kickstart.model.Favorite
import com.frogobox.kickstart.source.ProjectDataSource
import com.frogobox.kickstart.source.callback.ProjectDataCallback
import com.frogobox.kickstart.source.callback.ProjectStateCallback
import com.frogobox.kickstart.source.local.dao.FavoriteDao
import com.frogobox.sdk.ext.executeRoomDB
import com.frogobox.sdk.ext.fetchRoomDB
import com.frogobox.sdk.preference.FrogoPreference
import com.frogobox.sdk.source.FrogoLocalDataSource
import com.frogobox.sdk.util.AppExecutors

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
 * com.frogobox.publicspeakingbooster.source.local
 *
 */
class ProjectLocalDataSource(
    private val appExecutors: AppExecutors,
    private val frogoPreference: FrogoPreference,
    private val favoriteDao: FavoriteDao
) : FrogoLocalDataSource(appExecutors, frogoPreference), ProjectDataSource {

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
    }


    override fun saveFavorite(data: Favorite, callback: ProjectStateCallback) {
        favoriteDao.insertData(data).executeRoomDB(callback)
    }

    override fun getFavorite(callback: ProjectDataCallback<List<Favorite>>) {
        favoriteDao.getAllData().fetchRoomDB(callback) {
            addSubscribe(it)
        }
    }

    override fun updateFavorite(
        tableId: Int,
        title: String,
        description: String,
        dateTime: String
    ) {

    }

    override fun deleteFavorite(tableId: Int, callback: ProjectStateCallback) {
        favoriteDao.deleteDataFromTableId(tableId).executeRoomDB(callback)
    }

    override fun nukeFavorite(callback: ProjectStateCallback) {
        favoriteDao.nukeData().executeRoomDB(callback)
    }

}
