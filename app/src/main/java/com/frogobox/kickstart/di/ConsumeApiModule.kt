package com.frogobox.kickstart.di

import com.frogobox.api.meal.ConsumeTheMealDbApi
import com.frogobox.api.movie.ConsumeMovieApi
import com.frogobox.api.news.ConsumeNewsApi
import com.frogobox.api.pixabay.ConsumePixabayApi
import com.frogobox.api.sport.ConsumeTheSportDbApi
import com.frogobox.coreutil.meal.MealUrl
import com.frogobox.coreutil.movie.MovieUrl
import com.frogobox.coreutil.news.NewsUrl
import com.frogobox.coreutil.pixabay.PixabayUrl
import com.frogobox.coreutil.sport.SportUrl
import org.koin.dsl.module


/*
 * Created by faisalamir on 21/04/22
 * FrogoKickStartProject
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2022 Frogobox Media Inc.      
 * All rights reserved
 *
 */
 
val consumeApiModule = module {

    single {
        ConsumeNewsApi(NewsUrl.API_KEY)
    }

    single {
        ConsumeTheSportDbApi(SportUrl.API_KEY)
    }

    single {
        ConsumeTheMealDbApi(MealUrl.API_KEY)
    }

    single {
        ConsumePixabayApi(PixabayUrl.API_KEY)
    }

    single {
        ConsumeMovieApi(MovieUrl.API_KEY)
    }

}
