package com.frogobox.kickstart.util

import android.content.Context
import androidx.preference.PreferenceManager
import com.frogobox.kickstart.source.FrogoDataRepository
import com.frogobox.kickstart.source.local.dao.FavoriteDao
import com.frogobox.kickstart.source.local.dao.FashionDao
import com.frogobox.kickstart.source.local.FrogoAppDatabase
import com.frogobox.kickstart.source.local.FrogoLocalDataSource
import com.frogobox.kickstart.source.remote.FrogoRemoteDataSource

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * BaseMusicPlayer
 * Copyright (C) 26/08/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.basemusicplayer.util
 *
 */
object Injection {

    fun provideFrogoRepository(context: Context): FrogoDataRepository {
        val fashionDao: FashionDao by lazy {
            FrogoAppDatabase.getInstance(context).fashionDao()
        }

        val favoriteDao: FavoriteDao by lazy {
            FrogoAppDatabase.getInstance(context).favoriteScriptDao()
        }

        val appExecutors = AppExecutors()

        return FrogoDataRepository.getInstance(FrogoRemoteDataSource,
            FrogoLocalDataSource.getInstance(
                appExecutors,
                PreferenceManager.getDefaultSharedPreferences(context),
                fashionDao,
                favoriteDao))
    }

}