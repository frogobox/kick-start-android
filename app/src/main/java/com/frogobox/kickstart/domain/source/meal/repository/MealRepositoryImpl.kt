package com.frogobox.kickstart.domain.source.meal.repository

import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.domain.model.Area
import com.frogobox.kickstart.domain.model.Category
import com.frogobox.kickstart.domain.model.Ingredient
import com.frogobox.kickstart.domain.model.Meal
import com.frogobox.kickstart.domain.model.MealFilter
import com.frogobox.kickstart.domain.source.meal.MealDataSource
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

    override fun listAllMeal(
        apiKey: String,
        firstLetter: String,
    ): Flow<Resource<List<Meal>>> {
        return dataSource.listAllMeal(apiKey, firstLetter).map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data?.meals ?: listOf())
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override fun lookupFullMeal(
        apiKey: String,
        idMeal: String,
    ): Flow<Resource<List<Meal>>> {
        return dataSource.lookupFullMeal(apiKey, idMeal).map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data?.meals ?: listOf())
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override fun lookupRandomMeal(apiKey: String): Flow<Resource<List<Meal>>> {
        return dataSource.lookupRandomMeal(apiKey).map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data?.meals ?: listOf())
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override fun listMealCategories(apiKey: String): Flow<Resource<List<Category>>> {
        return dataSource.listMealCategories(apiKey).map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data?.categories ?: listOf())
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override fun listAllCategories(
        apiKey: String,
        query: String,
    ): Flow<Resource<List<Category>>> {
        return dataSource.listAllCategories(apiKey, query).map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data?.meals ?: listOf())
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override fun listAllArea(
        apiKey: String,
        query: String,
    ): Flow<Resource<List<Area>>> {
        return dataSource.listAllArea(apiKey, query).map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data?.meals ?: listOf())
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override fun listAllIngredients(
        apiKey: String,
        query: String,
    ): Flow<Resource<List<Ingredient>>> {
        return dataSource.listAllIngredients(apiKey, query).map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data?.meals ?: listOf())
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override fun filterByIngredient(
        apiKey: String,
        ingredient: String,
    ): Flow<Resource<List<MealFilter>>> {
        return dataSource.filterByIngredient(apiKey, ingredient).map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data?.meals ?: listOf())
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override fun filterByCategory(
        apiKey: String,
        category: String,
    ): Flow<Resource<List<MealFilter>>> {
        return dataSource.filterByCategory(apiKey, category).map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data?.meals ?: listOf())
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override fun filterByArea(
        apiKey: String,
        area: String,
    ): Flow<Resource<List<MealFilter>>> {
        return dataSource.filterByArea(apiKey, area).map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data?.meals ?: listOf())
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }
    
}