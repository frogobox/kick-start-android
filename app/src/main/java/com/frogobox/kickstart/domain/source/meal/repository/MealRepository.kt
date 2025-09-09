package com.frogobox.kickstart.domain.source.meal.repository

import com.frogobox.kickstart.domain.model.Meal
import com.frogobox.kickstart.common.callback.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by faisalamircs on 09/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


interface MealRepository {

    fun searchMeal(apiKey: String, nameMeal: String): Flow<Resource<List<Meal>>>

}