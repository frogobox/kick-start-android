package com.frogobox.kickstart

import android.content.Context
import com.frogobox.kickstart.di.consumeApiModule
import com.frogobox.kickstart.di.repositoryModule
import com.frogobox.kickstart.di.viewModelModule
import com.frogobox.sdk.FrogoApplication
import org.koin.core.KoinApplication

/*
 * Created by Faisal Amir on 23/10/2020
 * KickStartProject Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2020 FrogoBox Inc.      
 * All rights reserved
 *
 */

class ProjectApplication : FrogoApplication() {

    companion object {
        val TAG: String = ProjectApplication::class.java.simpleName

        lateinit var instance: ProjectApplication
        fun getContext(): Context = instance.applicationContext
    }

    override fun setupKoinModule(koinApplication: KoinApplication) {
        koinApplication.modules(listOf(repositoryModule, viewModelModule, consumeApiModule))
    }

    override fun onCreateExt() {
        super.onCreateExt()
        instance = this
    }

}