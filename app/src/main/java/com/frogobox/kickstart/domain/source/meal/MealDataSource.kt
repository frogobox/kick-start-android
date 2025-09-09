package com.frogobox.kickstart.domain.source.meal

import com.frogobox.kickstart.domain.model.Meal
import com.frogobox.kickstart.domain.model.MealResponse
import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.domain.model.Area
import com.frogobox.kickstart.domain.model.Category
import com.frogobox.kickstart.domain.model.CategoryResponse
import com.frogobox.kickstart.domain.model.Ingredient
import com.frogobox.kickstart.domain.model.MealFilter
import com.frogobox.kickstart.domain.source.meal.MealConstant.PATH_API_KEY
import com.frogobox.kickstart.domain.source.meal.MealConstant.QUERY_AREA
import com.frogobox.kickstart.domain.source.meal.MealConstant.QUERY_CATEGORY
import com.frogobox.kickstart.domain.source.meal.MealConstant.QUERY_FIRST_LETTER
import com.frogobox.kickstart.domain.source.meal.MealConstant.QUERY_ID
import com.frogobox.kickstart.domain.source.meal.MealConstant.QUERY_INGREDIENT
import com.frogobox.kickstart.domain.source.meal.MealUrl.URL_CATEGORIES
import com.frogobox.kickstart.domain.source.meal.MealUrl.URL_FILTER
import com.frogobox.kickstart.domain.source.meal.MealUrl.URL_LIST
import com.frogobox.kickstart.domain.source.meal.MealUrl.URL_LOOKUP_MEAL
import com.frogobox.kickstart.domain.source.meal.MealUrl.URL_RANDOM_MEAL
import com.frogobox.kickstart.domain.source.meal.MealUrl.URL_SEARCH_MEAL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
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
    fun searchMeal(apiKey: String, nameMeal: String): Flow<Resource<MealResponse<Meal>?>> =
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

//    // List all meals by first letter
//    fun listAllMeal(
//        apiKey: String,
//        firstLetter: String,
//    ): Response<MealResponse<Meal>>
//
//    // Lookup full meal details by id
//    fun lookupFullMeal(
//        apiKey: String,
//        idMeal: String,
//    ): Response<MealResponse<Meal>>
//
//    // Lookup a single random meal
//    fun lookupRandomMeal(
//        apiKey: String,
//    ): Response<MealResponse<Meal>>
//
//    // List all meal categories
//    fun listMealCategories(
//        apiKey: String,
//    ): Response<CategoryResponse>
//
//    // List all Categories
//    fun listAllCategories(
//        apiKey: String,
//        query: String,
//    ): Response<MealResponse<Category>>
//
//    // List all Area
//    fun listAllArea(
//        apiKey: String,
//        query: String,
//    ): Response<MealResponse<Area>>
//
//    // List all Ingredients
//    fun listAllIngredients(
//        apiKey: String,
//        query: String,
//    ): Response<MealResponse<Ingredient>>
//
//    // Filter by main ingredient
//    fun filterByIngredient(
//        apiKey: String,
//        ingredient: String,
//    ): Response<MealResponse<MealFilter>>
//
//    // Filter by Category
//    fun filterByCategory(
//        apiKey: String,
//        category: String,
//    ): Response<MealResponse<MealFilter>>
//
//    // Filter by Area
//    fun filterByArea(
//        apiKey: String,
//        area: String,
//    ): Response<MealResponse<MealFilter>>
    

}