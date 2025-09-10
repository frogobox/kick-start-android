package com.frogobox.kickstart.domain.source.meal

import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.domain.db.dao.MealDao
import com.frogobox.kickstart.domain.model.MealModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by faisalamircs on 10/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


@Singleton
class MealDaoSource @Inject constructor(
    private val dao: MealDao,
) {

    fun insertToFavorite(data: MealModel): Flow<Resource<MealModel>> = flow {
        try {
            emit(Resource.Loading())
            dao.insertData(data)
            emit(Resource.Success(data))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)


    fun getAllFavorite(): Flow<Resource<List<MealModel>>> = flow {
        try {
            emit(Resource.Loading())
            val response = dao.getAllData()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    fun searchById(idMeal : String): Flow<Resource<List<MealModel>>> = flow {
        try {
            emit(Resource.Loading())
            val response = dao.searchById(idMeal)
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    fun deleteFromTableId(tableId: Int): Flow<Resource<String>> = flow {
        try {
            emit(Resource.Loading())
            dao.deleteDataFromTableId(tableId)
            emit(Resource.Success("Berhasil Menghapus Data"))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    fun deleteFromMealId(mealId: String): Flow<Resource<String>> = flow {
        try {
            emit(Resource.Loading())
            dao.deleteDataFromMealId(mealId)
            emit(Resource.Success("Berhasil Menghapus Data"))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    fun nukeData(): Flow<Resource<String>> = flow {
        try {
            emit(Resource.Loading())
            dao.nukeData()
            emit(Resource.Success("Berhasil Menghapus Semua Data"))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

}