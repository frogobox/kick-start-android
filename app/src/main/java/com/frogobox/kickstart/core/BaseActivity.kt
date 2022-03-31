package com.frogobox.kickstart.core

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.frogobox.admob.ui.FrogoAdmobActivity
import com.frogobox.admob.ui.FrogoSdkAdmobActivity
import com.frogobox.kickstart.R
import com.google.gson.Gson

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
abstract class BaseActivity<VB: ViewBinding> : FrogoSdkAdmobActivity<VB>(), IBaseActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showInterstitial() {
        showAdInterstitial(getString(R.string.admob_interstitial))
    }

}