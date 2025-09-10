package com.frogobox.kickstart.domain.source.meal.usecase

import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.domain.model.Area
import com.frogobox.kickstart.domain.model.Category
import com.frogobox.kickstart.domain.model.Ingredient
import com.frogobox.kickstart.domain.model.Meal
import com.frogobox.kickstart.domain.model.MealFilter
import com.frogobox.kickstart.domain.source.meal.MealUrl
import com.frogobox.kickstart.domain.source.meal.repository.MealRepository
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

    override fun listAllMeal(firstLetter: String): Flow<Resource<List<Meal>>> {
        return repository.listAllMeal(API_KEY, firstLetter)
    }

    override fun lookupFullMeal(idMeal: String): Flow<Resource<List<Meal>>> {
        return repository.lookupFullMeal(API_KEY, idMeal)
    }

    override fun lookupRandomMeal(): Flow<Resource<List<Meal>>> {
        return repository.lookupRandomMeal(API_KEY)
    }

    override fun listMealCategories(): Flow<Resource<List<Category>>> {
        return repository.listMealCategories(API_KEY)
    }

    override fun listAllCategories(query: String): Flow<Resource<List<Category>>> {
        return repository.listAllCategories(API_KEY, query)
    }

    override fun listAllArea(query: String): Flow<Resource<List<Area>>> {
        return repository.listAllArea(API_KEY, query)
    }

    override fun listAllIngredients(query: String): Flow<Resource<List<Ingredient>>> {
        return repository.listAllIngredients(API_KEY, query)
    }

    override fun filterByIngredient(ingredient: String): Flow<Resource<List<MealFilter>>> {
        return repository.filterByIngredient(API_KEY, ingredient)
    }

    override fun filterByCategory(category: String): Flow<Resource<List<MealFilter>>> {
        return repository.filterByCategory(API_KEY, category)
    }

    override fun filterByArea(area: String): Flow<Resource<List<MealFilter>>> {
        return repository.filterByArea(API_KEY, area)
    }


}