package com.frogobox.kickstart.di

import com.frogobox.kickstart.mvvm.consumable.ConsumableViewModel
import com.frogobox.kickstart.mvvm.detail.DetailViewModel
import com.frogobox.kickstart.mvvm.favorite.FavoriteViewModel
import com.frogobox.kickstart.mvvm.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Faisal Amir on 23/10/2020
 * KickStartProject Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2020 FrogoBox Inc.      
 * All rights reserved
 *
 */

val viewModelModule = module {

    viewModel {
        MainViewModel(get())
    }

    viewModel {
        FavoriteViewModel(get())
    }

    viewModel {
        ConsumableViewModel(get())
    }

    viewModel {
        DetailViewModel(get())
    }

}