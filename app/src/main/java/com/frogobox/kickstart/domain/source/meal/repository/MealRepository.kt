package com.frogobox.kickstart.domain.source.meal.repository

import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.domain.model.Area
import com.frogobox.kickstart.domain.model.Category
import com.frogobox.kickstart.domain.model.Ingredient
import com.frogobox.kickstart.domain.model.Meal
import com.frogobox.kickstart.domain.model.MealFilter
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

    // Search meal by name
    fun searchMeal(apiKey: String, nameMeal: String): Flow<Resource<List<Meal>>>

    // List all meals by first letter
    fun listAllMeal(
        apiKey: String,
        firstLetter: String,
    ): Flow<Resource<List<Meal>>>

    // Lookup full meal details by id
    fun lookupFullMeal(
        apiKey: String,
        idMeal: String,
    ): Flow<Resource<List<Meal>>>

    // Lookup a single random meal
    fun lookupRandomMeal(
        apiKey: String,
    ): Flow<Resource<List<Meal>>>

    // List all meal categories
    fun listMealCategories(
        apiKey: String,
    ): Flow<Resource<List<Category>>>

    // List all Categories
    fun listAllCategories(
        apiKey: String,
        query: String,
    ): Flow<Resource<List<Category>>>

    // List all Area
    fun listAllArea(
        apiKey: String,
        query: String,
    ): Flow<Resource<List<Area>>>

    // List all Ingredients
    fun listAllIngredients(
        apiKey: String,
        query: String,
    ): Flow<Resource<List<Ingredient>>>

    // Filter by main ingredient
    fun filterByIngredient(
        apiKey: String,
        ingredient: String,
    ): Flow<Resource<List<MealFilter>>>

    // Filter by Category
    fun filterByCategory(
        apiKey: String,
        category: String,
    ): Flow<Resource<List<MealFilter>>>

    // Filter by Area
    fun filterByArea(
        apiKey: String,
        area: String,
    ): Flow<Resource<List<MealFilter>>>
    
}