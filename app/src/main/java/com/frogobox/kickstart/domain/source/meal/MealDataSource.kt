package com.frogobox.kickstart.domain.source.meal

import com.frogobox.kickstart.domain.model.Meal
import com.frogobox.kickstart.domain.model.MealResponse
import com.frogobox.kickstart.common.callback.Resource
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


}