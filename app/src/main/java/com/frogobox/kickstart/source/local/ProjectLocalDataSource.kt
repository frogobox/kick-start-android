package com.frogobox.kickstart.source.local

import android.content.SharedPreferences
import com.frogobox.coreapi.news.response.ArticleResponse
import com.frogobox.coreapi.news.response.SourceResponse
import com.frogobox.coresdk.FrogoLocalObserver
import com.frogobox.kickstart.source.ProjectDataSource
import com.frogobox.kickstart.source.local.dao.FavoriteDao
import com.frogobox.kickstart.source.model.Favorite
import com.frogobox.sdk.util.AppExecutors
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

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
    private val sharedPreferences: SharedPreferences,
    private val favoriteDao: FavoriteDao
) : ProjectDataSource {

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

    }

    override fun getSources(
        apiKey: String,
        language: String,
        country: String,
        category: String,
        callback: ProjectDataSource.GetRemoteCallback<SourceResponse>
    ) {

    }

    override fun saveRoomFavorite(data: Favorite): Boolean {
        appExecutors.diskIO.execute {
            favoriteDao.insertData(data)
        }
        return true
    }

    override fun getRoomFavorite(callback: ProjectDataSource.GetLocalCallback<List<Favorite>>) {
        appExecutors.diskIO.execute {
            favoriteDao.getAllData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : FrogoLocalObserver<List<Favorite>>() {
                    override fun onCallbackSucces(data: List<Favorite>) {
                        callback.onShowProgress()
                        callback.onSuccess(data)
                        if (data.isEmpty()) {
                            callback.onEmptyData(true)
                        } else {
                            callback.onEmptyData(false)
                        }
                        callback.onHideProgress()
                    }

                    override fun onCallbackError(code: Int, errorMessage: String) {
                        callback.onFailed(code, errorMessage)
                    }

                    override fun onAddSubscribe(disposable: Disposable) {
                        addSubscribe(disposable = disposable)
                    }

                    override fun onCompleted() {
                        callback.onHideProgress()
                    }
                })
        }
    }

    override fun updateRoomFavorite(
        tableId: Int,
        title: String,
        description: String,
        dateTime: String
    ): Boolean {
        return true
    }


    override fun deleteRoomFavorite(tableId: Int): Boolean {
        appExecutors.diskIO.execute {
            favoriteDao.deleteDataFromTableId(tableId)
        }
        return true
    }

    override fun nukeRoomFavorite(): Boolean {
        appExecutors.diskIO.execute {
            favoriteDao.nukeData()
        }
        return true
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

    }

    private
    var compositeDisposable: CompositeDisposable? = null

    fun addSubscribe(disposable: Disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()

            compositeDisposable?.add(disposable)
        }
    }

    private fun clearSubscribe() {
        if (compositeDisposable != null) {
            compositeDisposable?.clear()
        }
    }

}
