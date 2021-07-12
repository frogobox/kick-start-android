package com.frogobox.kickstart.mvvm.detail

import android.app.Application
import com.frogobox.kickstart.core.BaseViewModel
import com.frogobox.kickstart.source.FrogoDataRepository
import com.frogobox.kickstart.source.model.Favorite

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
    private val repository: FrogoDataRepository
) : BaseViewModel(context) {


    fun saveToRoom(data: Favorite) {
        repository.saveRoomFavorite(data)
    }

}