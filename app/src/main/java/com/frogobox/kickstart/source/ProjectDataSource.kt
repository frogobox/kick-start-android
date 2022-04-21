package com.frogobox.kickstart.source

import com.frogobox.coreapi.news.response.ArticleResponse
import com.frogobox.coresdk.source.ICoreDataSource
import com.frogobox.kickstart.model.Favorite
import com.frogobox.kickstart.source.callback.ProjectDataCallback
import com.frogobox.kickstart.source.callback.ProjectStateCallback

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
interface ProjectDataSource : ICoreDataSource {

    // API Server ----------------------------------------------------------------------------------

    // Get Top Headline
    fun getTopHeadline(
        apiKey: String,
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: ProjectDataCallback<ArticleResponse>
    )

    // Room Database -------------------------------------------------------------------------------

    fun saveFavorite(data: Favorite, callback: ProjectStateCallback)

    // Get
    fun getFavorite(callback: ProjectDataCallback<List<Favorite>>)

    // Update
    fun updateFavorite(
        tableId: Int,
        title: String,
        description: String,
        dateTime: String
    )

    // Delete
    fun deleteFavorite(tableId: Int, callback: ProjectStateCallback)

    // Nuke
    fun nukeFavorite(callback: ProjectStateCallback)
    // ---------------------------------------------------------------------------------------------

}