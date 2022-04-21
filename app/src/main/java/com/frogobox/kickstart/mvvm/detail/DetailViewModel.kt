package com.frogobox.kickstart.mvvm.detail

import android.app.Application
import com.frogobox.kickstart.core.BaseViewModel
import com.frogobox.kickstart.source.ProjectDataRepository
import com.frogobox.kickstart.model.Favorite
import com.frogobox.kickstart.source.callback.ProjectStateCallback

/*
 * Created by faisalamir on 12/07/21
 * KickStartProject
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
class DetailViewModel(
    private val context: Application,
    private val repository: ProjectDataRepository
) : BaseViewModel(context, repository) {

    fun saveToRoom(data: Favorite) {
        repository.saveFavorite(data, object : ProjectStateCallback {
            override fun onFailed(statusCode: Int, errorMessage: String) {
                
            }

            override fun onFinish() {
                
            }

            override fun onHideProgress() {
                
            }

            override fun onShowProgress() {
                
            }

            override fun onSuccess() {
                
            }

        })
    }

}