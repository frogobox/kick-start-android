package com.frogobox.kickstart.mvvm.main

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.frogobox.frogonewsapi.data.response.ArticleResponse
import com.frogobox.kickstart.core.BaseViewModel
import com.frogobox.kickstart.source.FrogoDataRepository
import com.frogobox.kickstart.source.FrogoDataSource
import com.frogobox.kickstart.util.SingleLiveEvent
import com.frogobox.kickstart.util.Constant
import kotlinx.coroutines.launch

/*
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
class MainViewModel(private val context: Application, private val repository: FrogoDataRepository) :
    BaseViewModel(context) {

    var topHeadlineLive = SingleLiveEvent<ArticleResponse>()

    fun getTopHeadline() {
        viewModelScope.launch {
            repository.getTopHeadline(
                Constant.ApiUrl.NEWS_API_KEY,
                null,
                null,
                null,
                Constant.NewsConstant.COUNTRY_ID,
                null,
                null,
                object : FrogoDataSource.GetRemoteCallback<ArticleResponse> {
                    override fun onShowProgressDialog() {
                        eventShowProgress.postValue(true)
                    }

                    override fun onHideProgressDialog() {
                        eventShowProgress.postValue(false)
                    }

                    override fun onSuccess(data: ArticleResponse) {
                        topHeadlineLive.postValue(data)
                    }

                    override fun onFailed(statusCode: Int, errorMessage: String?) {
                        eventFailed.postValue(errorMessage)
                    }

                    override fun onEmptyData(check: Boolean) {
                        eventEmptyData.postValue(check)
                    }
                }
            )
        }
    }
}