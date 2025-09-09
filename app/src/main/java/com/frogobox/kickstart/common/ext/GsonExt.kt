package com.frogobox.kickstart.common.ext

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by faisalamircs on 09/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


inline fun <reified T> fromJson(json: String?): T {
    return Gson().fromJson(json, object : TypeToken<T>() {}.type)
}