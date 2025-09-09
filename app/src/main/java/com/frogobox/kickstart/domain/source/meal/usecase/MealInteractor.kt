package com.frogobox.kickstart.domain.source.meal.usecase

import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.domain.source.meal.repository.MealRepository
import com.frogobox.kickstart.domain.model.Meal
import com.frogobox.kickstart.domain.source.meal.MealUrl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by faisalamircs on 09/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


class MealInteractor @Inject constructor(
    private val repository: MealRepository,
) : MealUseCase {

    companion object {
        const val API_KEY = MealUrl.API_KEY
    }

    override fun searchMeal(nameMeal: String): Flow<Resource<List<Meal>>> {
        return repository.searchMeal(API_KEY, nameMeal)
    }

}