package com.frogobox.kickstart.domain.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.frogobox.kickstart.domain.db.DBConfig.TABLE_MEALS
import com.frogobox.kickstart.domain.model.MealModel
import kotlin.collections.List

/**
 * Created by faisalamircs on 10/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


@Dao
interface MealDao {

    @Query("SELECT * FROM $TABLE_MEALS")
    fun getAllData(): List<MealModel>

    @Query("SELECT * FROM $TABLE_MEALS WHERE idMeal = :idMeal")
    fun searchById(idMeal: String): List<MealModel>

    @Insert
    fun insertData(data: MealModel)

    @Query("DELETE FROM $TABLE_MEALS WHERE table_id = :tableId")
    fun deleteDataFromTableId(tableId: Int)

    @Query("DELETE FROM $TABLE_MEALS WHERE idMeal = :idMeal")
    fun deleteDataFromMealId(idMeal: String)

    @Query("DELETE FROM $TABLE_MEALS")
    fun nukeData()

}