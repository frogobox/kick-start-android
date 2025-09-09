package com.frogobox.kickstart.domain.source.meal.repository

import com.frogobox.kickstart.domain.source.meal.MealDataSource
import com.frogobox.kickstart.domain.model.Meal
import com.frogobox.kickstart.common.callback.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by faisalamircs on 09/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


class MealRepositoryImpl @Inject constructor(
    private val dataSource: MealDataSource,
) : MealRepository {

    override fun searchMeal(
        apiKey: String,
        nameMeal: String,
    ): Flow<Resource<List<Meal>>> {
        return dataSource.searchMeal(apiKey, nameMeal).map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data?.meals ?: listOf())
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

}