package com.frogobox.kickstart

import android.content.Context
import com.frogobox.kickstart.common.ext.appIsDebug
import com.frogobox.sdk.FrogoApplication
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Faisal Amir on 23/10/2020
 * KickStartProject Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2020 Frogobox Inc.      
 * All rights reserved
 *
 */

@HiltAndroidApp
class ProjectApplication : FrogoApplication() {

    companion object {
        val TAG: String = ProjectApplication::class.java.simpleName

        lateinit var instance: ProjectApplication
        fun getContext(): Context = instance.applicationContext
    }

    override fun isDebugMode(): Boolean {
        return appIsDebug
    }

    override fun onCreateExt() {
        super.onCreateExt()
        instance = this
    }

}