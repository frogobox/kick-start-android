package com.frogobox.kickstart.common.base

import androidx.viewbinding.ViewBinding
import com.frogobox.sdk.view.FrogoBindFragment

/**
 * Created by Faisal Amir
 * Frogobox Inc License
 * -----------------------------------------
 * ImplementationAdmob
 * Copyright (C) 25/11/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * Frogobox Software Industries
 * com.frogobox.basemusicplayer.activity
 *
 */

abstract class BaseFragment<VB : ViewBinding> : FrogoBindFragment<VB>(), IBaseFragment {


    protected val mActivity: BaseActivity<*> by lazy {
        (activity as BaseActivity<*>)
    }

}