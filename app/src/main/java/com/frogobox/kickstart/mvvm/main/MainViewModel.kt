package com.frogobox.kickstart.mvvm.main

import androidx.lifecycle.MutableLiveData
import com.frogobox.coreapi.news.NewsConstant
import com.frogobox.coreapi.news.NewsUrl
import com.frogobox.coreapi.news.response.ArticleResponse
import com.frogobox.kickstart.core.BaseViewModel
import com.frogobox.kickstart.source.ProjectDataRepository
import com.frogobox.kickstart.source.callback.ProjectDataCallback

/**
 * Created by Faisal Amir
 * =========================================
 * android-kick-start-project-template
 * Copyright (C) 28/04/2020.      
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.kickstart.viewmodel
 * 
 */
class MainViewModel(
    private val repository: ProjectDataRepository
) : BaseViewModel(repository) {

    var topHeadlineLive = MutableLiveData<ArticleResponse>()

    fun getTopHeadline() {
        repository.getTopHeadline(
            NewsUrl.API_KEY,
            null,
            null,
            NewsConstant.CATEGORY_TECHNOLOGY,
            NewsConstant.COUNTRY_ID,
            null,
            null,
            object : ProjectDataCallback<ArticleResponse> {
                override fun onShowProgress() {
                    _eventShowProgressState.postValue(true)
                }

                override fun onHideProgress() {
                    _eventShowProgressState.postValue(false)
                }

                override fun onSuccess(data: ArticleResponse) {
                    topHeadlineLive.postValue(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String) {
                    _eventFailed.postValue(errorMessage)
                }

                override fun onFinish() {

                }

                override fun onEmptyData() {
                    _eventEmptyState.postValue(true)
                }


            }
        )
    }

}