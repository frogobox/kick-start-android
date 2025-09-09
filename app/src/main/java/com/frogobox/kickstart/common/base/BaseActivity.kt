package com.frogobox.kickstart.common.base

import androidx.viewbinding.ViewBinding
import com.frogobox.ads.ui.FrogoAdBindActivity

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * Copyright (C) 27/11/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 *
 */

abstract class BaseActivity<VB : ViewBinding> : FrogoAdBindActivity<VB>(), IBaseActivity {

}