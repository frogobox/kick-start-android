package com.frogobox.kickstart.source.remote

import android.content.Context
import com.frogobox.kickstart.mvvm.model.ArticleResponse
import com.frogobox.kickstart.mvvm.model.Fashion
import com.frogobox.kickstart.mvvm.model.Favorite
import com.frogobox.kickstart.mvvm.model.SourceResponse
import com.frogobox.kickstart.source.FrogoDataSource
import com.frogobox.kickstart.source.remote.network.FrogoApiCallback
import com.frogobox.kickstart.source.remote.network.FrogoApiService
import com.frogobox.kickstart.util.helper.FunHelper.Func.noAction
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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
object FrogoRemoteDataSource : FrogoDataSource {

    private val frogoApiService = FrogoApiService

    override fun usingChuckInterceptor(context: Context) {
        frogoApiService.usingChuckInterceptor(context)
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
        frogoApiService.getApiService
            .getTopHeadline(apiKey, q, sources, category, country, pageSize, page)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgressDialog() }
            .doOnTerminate { callback.onHideProgressDialog() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : FrogoApiCallback<ArticleResponse>() {
                override fun onSuccess(model: ArticleResponse) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {}

            })
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
        frogoApiService.getApiService.getEverythings(
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
        )
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgressDialog() }
            .doOnTerminate { callback.onHideProgressDialog() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : FrogoApiCallback<ArticleResponse>() {
                override fun onSuccess(model: ArticleResponse) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {

                }
            })
    }

    override fun getSources(
        apiKey: String,
        language: String,
        country: String,
        category: String,
        callback: FrogoDataSource.GetRemoteCallback<SourceResponse>
    ) {
        frogoApiService.getApiService.getSources(apiKey, language, country, category)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgressDialog() }
            .doOnTerminate { callback.onHideProgressDialog() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : FrogoApiCallback<SourceResponse>() {
                override fun onSuccess(model: SourceResponse) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                    callback.onFinish()
                }
            })
    }


    override fun saveRoomFavorite(data: Favorite): Boolean {
        return noAction()
    }

    override fun getRoomData(callback: FrogoDataSource.GetRoomDataCallBack<List<Fashion>>) {
        noAction()
    }

    override fun getRoomFavorite(callback: FrogoDataSource.GetRoomDataCallBack<List<Favorite>>) {
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

    override fun searchRoomFavorite(
        scriptId: String,
        callback: FrogoDataSource.GetRoomDataCallBack<List<Favorite>>
    ) {
        noAction()
    }

    override fun deleteRoomFavorite(tableId: Int): Boolean {
        return noAction()
    }

    override fun nukeRoomFavorite(): Boolean {
        return noAction()
    }


}