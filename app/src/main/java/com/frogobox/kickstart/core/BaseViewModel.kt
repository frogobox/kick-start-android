package com.frogobox.kickstart.core

import android.app.Application
import com.frogobox.kickstart.source.ProjectDataRepository
import com.frogobox.sdk.view.FrogoViewModel
import com.frogobox.sdk.view.FrogoViewModel2

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * Kick-Start-Template
 * Copyright (C) 18/08/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.basemusicplayer.base
 *
 */
open class BaseViewModel(
    private val repository: ProjectDataRepository
) : FrogoViewModel2() {

    override fun onClearDisposable() {
        super.onClearDisposable()
        repository.onClearDisposables()
    }

}