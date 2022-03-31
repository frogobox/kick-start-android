package com.frogobox.kickstart.source

import com.frogobox.coreapi.news.response.ArticleResponse
import com.frogobox.coreapi.news.response.SourceResponse
import com.frogobox.kickstart.source.model.Favorite

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
interface ProjectDataSource {

    // API Server ----------------------------------------------------------------------------------

    // Get Top Headline
    suspend fun getTopHeadline(
        apiKey: String,
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: GetRemoteCallback<ArticleResponse>
    )

    // Get Everythings
    suspend fun getEverythings(
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
        callback: GetRemoteCallback<ArticleResponse>
    )

    // Get Sources
    suspend fun getSources(
        apiKey: String,
        language: String,
        country: String,
        category: String,
        callback: GetRemoteCallback<SourceResponse>
    )

    // Room Database -------------------------------------------------------------------------------

    fun saveRoomFavorite(data: Favorite) : Boolean

    // Get
    fun getRoomFavorite(callback: GetLocalCallback<List<Favorite>>)

    // Update
    fun updateRoomFavorite(tableId: Int, title: String, description: String, dateTime: String) : Boolean

    // Delete
    fun deleteRoomFavorite(tableId: Int) : Boolean

    // Nuke
    fun nukeRoomFavorite() : Boolean
    // ---------------------------------------------------------------------------------------------

    // Consumable Source ---------------------------------------------------------------------------

    fun consumeTopHeadline(
        apiKey: String,
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: GetRemoteCallback<ArticleResponse>
    )

    // Interface Helper ----------------------------------------------------------------------------

    // Response Callback
    interface GetRemoteCallback<T> : FrogoResponseCallback<T>

    // Save
    interface SaveRoomDataCallBack<T>: FrogoResponseCallback<T>
    interface SavePrefCallBack<T>: FrogoResponseCallback<T>

    // Get
    interface GetLocalCallback<T> : FrogoResponseCallback<T>

    // Update
    interface UpdateRoomDataCallBack<T> : FrogoResponseCallback<T>

    // Delete
    interface DeleteRoomDataCallBack<T> : FrogoResponseCallback<T>
    // ---------------------------------------------------------------------------------------------

}