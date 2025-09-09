/**
 * Created by faisalamir on 19/09/21
 * FrogoRecyclerView
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 Frogobox Inc.
 * All rights reserved
 *
 */

object ProjectSetting {

    // Project settings
    const val NAME_APP = "Frogo Kick Start Project"

    const val APP_DOMAIN = "com"
    const val APP_PLAY_CONSOLE = "frogobox"

    // ---------------------------------------------------------------------------------------------

    // Version App
    const val VERSION_MAJOR = 1
    const val VERSION_MINOR = 0
    const val VERSION_PATCH = 0

    // ---------------------------------------------------------------------------------------------

    const val ADMOB_APP_ID = ""

    // ---------------------------------------------------------------------------------------------
    // Default Setting - Do Not Change
    // ---------------------------------------------------------------------------------------------

    const val PROJECT_MIN_SDK = 23
    const val PROJECT_COMPILE_SDK = 36
    const val PROJECT_TARGET_SDK = PROJECT_COMPILE_SDK

    // ---------------------------------------------------------------------------------------------

    const val BASE_PACKAGE_NAME = "$APP_DOMAIN.$APP_PLAY_CONSOLE"

    val APP_NAME = NAME_APP.lowercase().replace(" ", "").replace(" ", "-")
    val PROJECT_APP_ID = "$BASE_PACKAGE_NAME.$APP_NAME"

    const val PROJECT_VERSION_CODE = (VERSION_MAJOR * 100) + (VERSION_MINOR * 10) + (VERSION_PATCH * 1)
    const val PROJECT_VERSION_NAME = "$VERSION_MAJOR.$VERSION_MINOR.$VERSION_PATCH"

    // ---------------------------------------------------------------------------------------------

    // Declaration apps name debug mode
    const val DEBUG_ATTRIBUTE = "DEV"
    const val NAME_APP_DEBUG = "$NAME_APP $DEBUG_ATTRIBUTE"

    val NAME_APK = NAME_APP.lowercase().replace(" ", "-")
    val NAME_DB = NAME_APP.lowercase().replace(" ", "_")
    val DB = "\"$NAME_DB.db\""
    val PREF = "\"pref_$NAME_DB\""

    // ---------------------------------------------------------------------------------------------

    const val PLAYSTORE_STORE_FILE = "frogoboxmedia.jks"
    const val PLAYSTORE_STORE_PASSWORD = "amirisback"
    const val PLAYSTORE_KEY_ALIAS = "frogoisback"
    const val PLAYSTORE_KEY_PASSWORD = "amirisback"

}