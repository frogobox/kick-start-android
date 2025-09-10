package com.frogobox.kickstart.domain.source.meal

import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.domain.db.dao.MealDao
import com.frogobox.kickstart.domain.model.AreaModel
import com.frogobox.kickstart.domain.model.CategoryModel
import com.frogobox.kickstart.domain.response.CategoryResponse
import com.frogobox.kickstart.domain.model.IngredientModel
import com.frogobox.kickstart.domain.model.MealModel
import com.frogobox.kickstart.domain.model.MealFilterModel
import com.frogobox.kickstart.domain.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by faisalamircs on 09/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


@Singleton
class MealDataSource @Inject constructor(
    private val apiService: MealApiService,
) {

    // Search meal by name
    fun searchMeal(apiKey: String, nameMeal: String): Flow<Resource<MealResponse<MealModel>?>> =
        flow {
            try {
                emit(Resource.Loading())
                val request = apiService.searchMeal(apiKey, nameMeal)
                val response = request.body()
                if (!request.isSuccessful) {
                    emit(Resource.Error(request.message()))
                } else {
                    emit(Resource.Success(response))
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)

    // List all meals by first letter
    fun listAllMeal(
        apiKey: String,
        firstLetter: String,
    ): Flow<Resource<MealResponse<MealModel>?>> = flow {
        try {
            emit(Resource.Loading())
            val request = apiService.listAllMeal(apiKey, firstLetter)
            val response = request.body()
            if (!request.isSuccessful) {
                emit(Resource.Error(request.message()))
            } else {
                emit(Resource.Success(response))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    // Lookup full meal details by id
    fun lookupFullMeal(
        apiKey: String,
        idMeal: String,
    ): Flow<Resource<MealResponse<MealModel>?>> = flow {
        try {
            emit(Resource.Loading())
            val request = apiService.lookupFullMeal(apiKey, idMeal)
            val response = request.body()
            if (!request.isSuccessful) {
                emit(Resource.Error(request.message()))
            } else {
                emit(Resource.Success(response))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    // Lookup a single random meal
    fun lookupRandomMeal(
        apiKey: String,
    ): Flow<Resource<MealResponse<MealModel>?>> = flow {
        try {
            emit(Resource.Loading())
            val request = apiService.lookupRandomMeal(apiKey)
            val response = request.body()
            if (!request.isSuccessful) {
                emit(Resource.Error(request.message()))
            } else {
                emit(Resource.Success(response))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    // List all meal categories
    fun listMealCategories(
        apiKey: String,
    ): Flow<Resource<CategoryResponse?>> = flow {
        try {
            emit(Resource.Loading())
            val request = apiService.listMealCategories(apiKey)
            val response = request.body()
            if (!request.isSuccessful) {
                emit(Resource.Error(request.message()))
            } else {
                emit(Resource.Success(response))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    // List all Categories
    fun listAllCategories(
        apiKey: String,
        query: String,
    ): Flow<Resource<MealResponse<CategoryModel>?>> = flow {
        try {
            emit(Resource.Loading())
            val request = apiService.listAllCategories(apiKey, query)
            val response = request.body()
            if (!request.isSuccessful) {
                emit(Resource.Error(request.message()))
            } else {
                emit(Resource.Success(response))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    // List all Area
    fun listAllArea(
        apiKey: String,
        query: String,
    ): Flow<Resource<MealResponse<AreaModel>?>> = flow {
        try {
            emit(Resource.Loading())
            val request = apiService.listAllArea(apiKey, query)
            val response = request.body()
            if (!request.isSuccessful) {
                emit(Resource.Error(request.message()))
            } else {
                emit(Resource.Success(response))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    // List all Ingredients
    fun listAllIngredients(
        apiKey: String,
        query: String,
    ): Flow<Resource<MealResponse<IngredientModel>?>> = flow {
        try {
            emit(Resource.Loading())
            val request = apiService.listAllIngredients(apiKey, query)
            val response = request.body()
            if (!request.isSuccessful) {
                emit(Resource.Error(request.message()))
            } else {
                emit(Resource.Success(response))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    // Filter by main ingredient
    fun filterByIngredient(
        apiKey: String,
        ingredient: String,
    ): Flow<Resource<MealResponse<MealFilterModel>?>> = flow {
        try {
            emit(Resource.Loading())
            val request = apiService.filterByIngredient(apiKey, ingredient)
            val response = request.body()
            if (!request.isSuccessful) {
                emit(Resource.Error(request.message()))
            } else {
                emit(Resource.Success(response))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    // Filter by Category
    fun filterByCategory(
        apiKey: String,
        category: String,
    ): Flow<Resource<MealResponse<MealFilterModel>?>> = flow {
        try {
            emit(Resource.Loading())
            val request = apiService.filterByCategory(apiKey, category)
            val response = request.body()
            if (!request.isSuccessful) {
                emit(Resource.Error(request.message()))
            } else {
                emit(Resource.Success(response))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    // Filter by Area
    fun filterByArea(
        apiKey: String,
        area: String,
    ): Flow<Resource<MealResponse<MealFilterModel>?>> = flow {
        try {
            emit(Resource.Loading())
            val request = apiService.filterByArea(apiKey, area)
            val response = request.body()
            if (!request.isSuccessful) {
                emit(Resource.Error(request.message()))
            } else {
                emit(Resource.Success(response))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

}