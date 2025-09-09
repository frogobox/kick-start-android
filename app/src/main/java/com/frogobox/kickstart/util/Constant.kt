package com.frogobox.kickstart.util

import android.Manifest
import android.os.Environment
import com.frogobox.kickstart.common.ext.appApplicationId

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
 * com.frogobox.publicspeakingbooster.helper
 *
 */
object Constant {

    const val MENTION_REGEX = "@[a-z0-9._-]+"
    const val CACHE_SIZE = 10 * 1024 * 1024

    const val PER_PAGE_LOAD = 10
    const val ALL_PAGE = 100

    object Ext {
        const val MP4 = ".mp4"
        const val PNG = ".png"
        const val CSV = ".csv"
    }

    object Dir {
        private const val BASE_FILE_NAME = "SPEECH_"
        private const val BASE_DIR_NAME = "BaseMusicPlayer"

        val DIR_NAME = "${Environment.DIRECTORY_PICTURES}/$BASE_DIR_NAME"
        val VIDEO_FILE_NAME = "$BASE_FILE_NAME${System.currentTimeMillis()}${Ext.MP4}"
    }

}