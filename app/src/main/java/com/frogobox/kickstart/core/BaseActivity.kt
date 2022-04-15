package com.frogobox.kickstart.core

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.frogobox.admob.ui.FrogoSdkAdmobActivity
import com.frogobox.kickstart.R

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * ImplementationAdmob
 * Copyright (C) 27/11/2019.
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
abstract class BaseActivity<VB : ViewBinding> : FrogoSdkAdmobActivity<VB>(), IBaseActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showInterstitial() {
        showAdInterstitial(getString(R.string.admob_interstitial))
    }

}