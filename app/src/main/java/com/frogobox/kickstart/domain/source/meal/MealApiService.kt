package com.frogobox.kickstart.domain.source.meal

import com.frogobox.kickstart.domain.model.AreaModel
import com.frogobox.kickstart.domain.model.CategoryModel
import com.frogobox.kickstart.domain.response.CategoryResponse
import com.frogobox.kickstart.domain.model.IngredientModel
import com.frogobox.kickstart.domain.model.MealModel
import com.frogobox.kickstart.domain.model.MealFilterModel
import com.frogobox.kickstart.domain.response.MealResponse
import com.frogobox.kickstart.domain.source.meal.MealConstant.PATH_API_KEY
import com.frogobox.kickstart.domain.source.meal.MealConstant.QUERY_AREA
import com.frogobox.kickstart.domain.source.meal.MealConstant.QUERY_CATEGORY
import com.frogobox.kickstart.domain.source.meal.MealConstant.QUERY_FIRST_LETTER
import com.frogobox.kickstart.domain.source.meal.MealConstant.QUERY_ID
import com.frogobox.kickstart.domain.source.meal.MealConstant.QUERY_INGREDIENT
import com.frogobox.kickstart.domain.source.meal.MealConstant.QUERY_NAME
import com.frogobox.kickstart.domain.source.meal.MealUrl.URL_CATEGORIES
import com.frogobox.kickstart.domain.source.meal.MealUrl.URL_FILTER
import com.frogobox.kickstart.domain.source.meal.MealUrl.URL_LIST
import com.frogobox.kickstart.domain.source.meal.MealUrl.URL_LOOKUP_MEAL
import com.frogobox.kickstart.domain.source.meal.MealUrl.URL_RANDOM_MEAL
import com.frogobox.kickstart.domain.source.meal.MealUrl.URL_SEARCH_MEAL
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Faisal Amir
 * Frogobox Inc License
 * -----------------------------------------
 * Copyright (C) 15/03/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * Frogobox Software Industries
 *
 */

interface MealApiService {

    // Search meal by name
    @GET(URL_SEARCH_MEAL)
    suspend fun searchMeal(
        @Path(PATH_API_KEY) apiKey: String,
        @Query(QUERY_NAME) nameMeal: String,
    ): Response<MealResponse<MealModel>>

    // List all meals by first letter
    @GET(URL_SEARCH_MEAL)
    suspend fun listAllMeal(
        @Path(PATH_API_KEY) apiKey: String,
        @Query(QUERY_FIRST_LETTER) firstLetter: String,
    ): Response<MealResponse<MealModel>>

    // Lookup full meal details by id
    @GET(URL_LOOKUP_MEAL)
    suspend fun lookupFullMeal(
        @Path(PATH_API_KEY) apiKey: String,
        @Query(QUERY_ID) idMeal: String,
    ): Response<MealResponse<MealModel>>

    // Lookup a single random meal
    @GET(URL_RANDOM_MEAL)
    suspend fun lookupRandomMeal(
        @Path(PATH_API_KEY) apiKey: String,
    ): Response<MealResponse<MealModel>>

    // List all meal categories
    @GET(URL_CATEGORIES)
    suspend fun listMealCategories(
        @Path(PATH_API_KEY) apiKey: String,
    ): Response<CategoryResponse>

    // List all Categories
    @GET(URL_LIST)
    suspend fun listAllCategories(
        @Path(PATH_API_KEY) apiKey: String,
        @Query(QUERY_CATEGORY) query: String,
    ): Response<MealResponse<CategoryModel>>

    // List all Area
    @GET(URL_LIST)
    suspend fun listAllArea(
        @Path(PATH_API_KEY) apiKey: String,
        @Query(QUERY_AREA) query: String,
    ): Response<MealResponse<AreaModel>>

    // List all Ingredients
    @GET(URL_LIST)
    suspend fun listAllIngredients(
        @Path(PATH_API_KEY) apiKey: String,
        @Query(QUERY_INGREDIENT) query: String,
    ): Response<MealResponse<IngredientModel>>

    // Filter by main ingredient
    @GET(URL_FILTER)
    suspend fun filterByIngredient(
        @Path(PATH_API_KEY) apiKey: String,
        @Query(QUERY_INGREDIENT) ingredient: String,
    ): Response<MealResponse<MealFilterModel>>

    // Filter by Category
    suspend fun filterByCategory(
        @Path(PATH_API_KEY) apiKey: String,
        @Query(QUERY_CATEGORY) category: String,
    ): Response<MealResponse<MealFilterModel>>

    // Filter by Area
    suspend fun filterByArea(
        @Path(PATH_API_KEY) apiKey: String,
        @Query(QUERY_AREA) area: String,
    ): Response<MealResponse<MealFilterModel>>

}