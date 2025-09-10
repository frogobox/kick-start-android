package com.frogobox.kickstart.domain.source.meal.usecase

import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.domain.model.AreaModel
import com.frogobox.kickstart.domain.model.CategoryModel
import com.frogobox.kickstart.domain.model.IngredientModel
import com.frogobox.kickstart.domain.model.MealFilterModel
import com.frogobox.kickstart.domain.model.MealModel
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

    override fun searchMeal(nameMeal: String): Flow<Resource<List<MealModel>>> {
        return repository.searchMeal(API_KEY, nameMeal)
    }

    override fun listAllMeal(firstLetter: String): Flow<Resource<List<MealModel>>> {
        return repository.listAllMeal(API_KEY, firstLetter)
    }

    override fun lookupFullMeal(idMeal: String): Flow<Resource<List<MealModel>>> {
        return repository.lookupFullMeal(API_KEY, idMeal)
    }

    override fun lookupRandomMeal(): Flow<Resource<List<MealModel>>> {
        return repository.lookupRandomMeal(API_KEY)
    }

    override fun listMealCategories(): Flow<Resource<List<CategoryModel>>> {
        return repository.listMealCategories(API_KEY)
    }

    override fun listAllCategories(query: String): Flow<Resource<List<CategoryModel>>> {
        return repository.listAllCategories(API_KEY, query)
    }

    override fun listAllArea(query: String): Flow<Resource<List<AreaModel>>> {
        return repository.listAllArea(API_KEY, query)
    }

    override fun listAllIngredients(query: String): Flow<Resource<List<IngredientModel>>> {
        return repository.listAllIngredients(API_KEY, query)
    }

    override fun filterByIngredient(ingredient: String): Flow<Resource<List<MealFilterModel>>> {
        return repository.filterByIngredient(API_KEY, ingredient)
    }

    override fun filterByCategory(category: String): Flow<Resource<List<MealFilterModel>>> {
        return repository.filterByCategory(API_KEY, category)
    }

    override fun filterByArea(area: String): Flow<Resource<List<MealFilterModel>>> {
        return repository.filterByArea(API_KEY, area)
    }

    override fun insertToFavorite(data: MealModel): Flow<Resource<MealModel>> {
        return repository.insertToFavorite(data)
    }

    override fun getAllFavorite(): Flow<Resource<List<MealModel>>> {
        return repository.getAllFavorite()
    }

    override fun deleteFromTableId(tableId: Int): Flow<Resource<String>> {
        return repository.deleteFromTableId(tableId)
    }

    override fun deleteFromMealId(mealId: String): Flow<Resource<String>> {
        return repository.deleteFromMealId(mealId)
    }

    override fun nukeData(): Flow<Resource<String>> {
        return repository.nukeData()
    }

    override fun searchById(idMeal: String): Flow<Resource<List<MealModel>>> {
        return repository.searchById(idMeal)
    }

}