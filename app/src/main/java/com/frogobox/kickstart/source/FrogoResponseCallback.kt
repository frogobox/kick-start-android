package com.frogobox.kickstart.source

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * PublicSpeakingBooster
 * Copyright (C) 16/08/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.publicspeakingbooster.base
 *
 */
interface FrogoResponseCallback<T> {

    fun onSuccess(data: T)

    fun onFailed(statusCode: Int, errorMessage: String? = "")

    fun onEmptyData(check : Boolean)

    fun onShowProgressDialog()

    fun onHideProgressDialog()

}