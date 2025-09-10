package com.frogobox.kickstart.domain.source.meal.repository

import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.domain.model.AreaModel
import com.frogobox.kickstart.domain.model.CategoryModel
import com.frogobox.kickstart.domain.model.IngredientModel
import com.frogobox.kickstart.domain.model.MealFilterModel
import com.frogobox.kickstart.domain.model.MealModel
import com.frogobox.kickstart.domain.source.meal.MealDaoSource
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
    private val daoSource: MealDaoSource,
) : MealRepository {

    override fun searchMeal(
        apiKey: String,
        nameMeal: String,
    ): Flow<Resource<List<MealModel>>> {
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
    ): Flow<Resource<List<MealModel>>> {
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
    ): Flow<Resource<List<MealModel>>> {
        return dataSource.lookupFullMeal(apiKey, idMeal).map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data?.meals ?: listOf())
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override fun lookupRandomMeal(apiKey: String): Flow<Resource<List<MealModel>>> {
        return dataSource.lookupRandomMeal(apiKey).map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data?.meals ?: listOf())
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override fun listMealCategories(apiKey: String): Flow<Resource<List<CategoryModel>>> {
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
    ): Flow<Resource<List<CategoryModel>>> {
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
    ): Flow<Resource<List<AreaModel>>> {
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
    ): Flow<Resource<List<IngredientModel>>> {
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
    ): Flow<Resource<List<MealFilterModel>>> {
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
    ): Flow<Resource<List<MealFilterModel>>> {
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
    ): Flow<Resource<List<MealFilterModel>>> {
        return dataSource.filterByArea(apiKey, area).map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data?.meals ?: listOf())
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override fun insertToFavorite(data: MealModel): Flow<Resource<MealModel>> {
        return daoSource.insertToFavorite(data).map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data ?: MealModel())
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override fun getAllFavorite(): Flow<Resource<List<MealModel>>> {
        return daoSource.getAllFavorite().map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data ?: listOf())
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override fun searchById(idMeal: String): Flow<Resource<List<MealModel>>> {
        return daoSource.searchById(idMeal).map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data ?: listOf())
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override fun deleteFromTableId(tableId: Int): Flow<Resource<String>> {
        return daoSource.deleteFromTableId(tableId).map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data ?: "")
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override fun deleteFromMealId(mealId: String): Flow<Resource<String>> {
        return daoSource.deleteFromMealId(mealId).map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data ?: "")
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override fun nukeData(): Flow<Resource<String>> {
        return daoSource.nukeData().map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data ?: "")
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

}