package com.frogobox.kickstart.domain.source.meal.usecase

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


interface MealUseCase {

    // Search meal by name
    fun searchMeal(nameMeal: String): Flow<Resource<List<Meal>>>

    // List all meals by first letter
    fun listAllMeal(firstLetter: String): Flow<Resource<List<Meal>>>

    // Lookup full meal details by id
    fun lookupFullMeal(idMeal: String): Flow<Resource<List<Meal>>>

    // Lookup a single random meal
    fun lookupRandomMeal(): Flow<Resource<List<Meal>>>

    // List all meal categories
    fun listMealCategories(): Flow<Resource<List<Category>>>

    // List all Categories
    fun listAllCategories(query: String): Flow<Resource<List<Category>>>

    // List all Area
    fun listAllArea(query: String): Flow<Resource<List<Area>>>

    // List all Ingredients
    fun listAllIngredients(query: String): Flow<Resource<List<Ingredient>>>

    // Filter by main ingredient
    fun filterByIngredient(ingredient: String): Flow<Resource<List<MealFilter>>>

    // Filter by Category
    fun filterByCategory(category: String): Flow<Resource<List<MealFilter>>>

    // Filter by Area
    fun filterByArea(area: String): Flow<Resource<List<MealFilter>>>

}