package com.frogobox.kickstart.util

import android.Manifest
import android.os.Environment

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

    const val OPTION_GET = "OPTION_GET"
    const val OPTION_DELETE = "OPTION_DELETE"

    const val DEFAULT_NULL = "null"
    const val DEFAULT_ERROR_MESSAGE = "Failed"
    const val FRAGMENT_DIALOG = "dialog"

    const val SPLASH_INTERVAL = 1000

    object Arg {
        private val BASE_ARGUMENTS = appApplicationId
    }

    object Extra {
        private val BASE_EXTRA = appApplicationId
    }

    object RoomDatabase {
        const val BASE_TABLE_NAME = "table"
        const val TABLE_NAME_FAVORITE = "favorite"
    }

    object Code {
        const val CODE_NAME = 1
        const val CODE_REQUEST_VIDEO_PERMISSIONS = 1
        val CODE_VIDEO_PERMISSIONS =
            arrayOf(Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO)
    }


    object Pref {
        const val PREF_NAME = "BaseMusicPlayer"
    }

    object Value {
        const val VALUE_SENSOR_ORIENTATION_DEFAULT_DEGREES = 90
        const val VALUE_SENSOR_ORIENTATION_INVERSE_DEGREES = 270
    }

    object Tag {
        const val TAG_ACTIVITY_EDIT = 300
        const val TAG_ACTIVITY_CREATE = 301
        const val TAG_ACTIVITY_DETAIL = 302

        const val TAG_FROM_ACTIVITY = 801
        const val TAG_FROM_FRAGMENT = 800

        const val TAG_CAMERA_VIDEO = "Camera2VideoFragment"

    }

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