package com.frogobox.kickstart.mvvm.viewmodel

import android.app.Application
import com.frogobox.kickstart.base.util.BaseViewModel
import com.frogobox.kickstart.mvvm.model.ArticleResponse
import com.frogobox.kickstart.source.FrogoDataRepository
import com.frogobox.kickstart.source.FrogoDataSource
import com.frogobox.kickstart.util.SingleLiveEvent
import com.frogobox.kickstart.util.helper.ConstHelper

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
        repository.getTopHeadline(
            ConstHelper.ApiUrl.NEWS_API_KEY,
            null,
            null,
            null,
            ConstHelper.NewsConstant.COUNTRY_ID,
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

                override fun onEmpty() {
                    
                }

                override fun onFinish() {
                    
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    
                }
            }
        )

    }


}