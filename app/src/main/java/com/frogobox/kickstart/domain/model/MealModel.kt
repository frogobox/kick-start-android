package com.frogobox.kickstart.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.frogobox.kickstart.domain.db.DBConfig.TABLE_MEALS
import com.google.gson.annotations.SerializedName

/**
 * Created by Faisal Amir
 * Frogobox Inc License
 * -----------------------------------------
 * consumable-code-the-meal-db-api
 * Copyright (C) 15/03/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * Frogobox Software Industries
 * com.frogobox.frogomealsapi.data.model
 *
 */


@Entity(tableName = TABLE_MEALS)
data class MealModel(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "table_id")
    var table_id: Int = 0,

    @SerializedName("idMeal")
    @ColumnInfo("idMeal")
    var idMeal: String? = null,

    @SerializedName("strMeal")
    @ColumnInfo("strMeal")
    var strMeal: String? = null,

    @SerializedName("strDrinkAlternate")
    @ColumnInfo("strDrinkAlternate")
    var strDrinkAlternate: String? = null,

    @SerializedName("strCategory")
    @ColumnInfo("strCategory")
    var strCategory: String? = null,

    @SerializedName("strArea")
    @ColumnInfo("strArea")
    var strArea: String? = null,

    @SerializedName("strInstructions")
    @ColumnInfo("strInstructions")
    var strInstructions: String? = null,

    @SerializedName("strMealThumb")
    @ColumnInfo("strMealThumb")
    var strMealThumb: String? = null,

    @SerializedName("strTags")
    @ColumnInfo("strTags")
    var strTags: String? = null,

    @SerializedName("strYoutube")
    @ColumnInfo("strYoutube")
    var strYoutube: String? = null,

    @SerializedName("strIngredient1")
    @ColumnInfo("strIngredient1")
    var strIngredient1: String? = null,

    @SerializedName("strIngredient2")
    @ColumnInfo("strIngredient2")
    var strIngredient2: String? = null,

    @SerializedName("strIngredient3")
    @ColumnInfo("strIngredient3")
    var strIngredient3: String? = null,

    @SerializedName("strIngredient4")
    @ColumnInfo("strIngredient4")
    var strIngredient4: String? = null,

    @SerializedName("strIngredient5")
    @ColumnInfo("strIngredient5")
    var strIngredient5: String? = null,

    @SerializedName("strIngredient6")
    @ColumnInfo("strIngredient6")
    var strIngredient6: String? = null,

    @SerializedName("strIngredient7")
    @ColumnInfo("strIngredient7")
    var strIngredient7: String? = null,

    @SerializedName("strIngredient8")
    @ColumnInfo("strIngredient8")
    var strIngredient8: String? = null,

    @SerializedName("strIngredient9")
    @ColumnInfo("strIngredient9")
    var strIngredient9: String? = null,

    @SerializedName("strIngredient10")
    @ColumnInfo("strIngredient10")
    var strIngredient10: String? = null,

    @SerializedName("strIngredient11")
    @ColumnInfo("strIngredient11")
    var strIngredient11: String? = null,

    @SerializedName("strIngredient12")
    @ColumnInfo("strIngredient12")
    var strIngredient12: String? = null,

    @SerializedName("strIngredient13")
    @ColumnInfo("strIngredient13")
    var strIngredient13: String? = null,

    @SerializedName("strIngredient14")
    @ColumnInfo("strIngredient14")
    var strIngredient14: String? = null,

    @SerializedName("strIngredient15")
    @ColumnInfo("strIngredient15")
    var strIngredient15: String? = null,

    @SerializedName("strIngredient16")
    @ColumnInfo("strIngredient16")
    var strIngredient16: String? = null,

    @SerializedName("strIngredient17")
    @ColumnInfo("strIngredient17")
    var strIngredient17: String? = null,

    @SerializedName("strIngredient18")
    @ColumnInfo("strIngredient18")
    var strIngredient18: String? = null,

    @SerializedName("strIngredient19")
    @ColumnInfo("strIngredient19")
    var strIngredient19: String? = null,

    @SerializedName("strIngredient20")
    @ColumnInfo("strIngredient20")
    var strIngredient20: String? = null,

    @SerializedName("strMeasure1")
    @ColumnInfo("strMeasure1")
    var strMeasure1: String? = null,

    @SerializedName("strMeasure2")
    @ColumnInfo("strMeasure2")
    var strMeasure2: String? = null,

    @SerializedName("strMeasure3")
    @ColumnInfo("strMeasure3")
    var strMeasure3: String? = null,

    @SerializedName("strMeasure4")
    @ColumnInfo("strMeasure4")
    var strMeasure4: String? = null,

    @SerializedName("strMeasure5")
    @ColumnInfo("strMeasure5")
    var strMeasure5: String? = null,

    @SerializedName("strMeasure6")
    @ColumnInfo("strMeasure6")
    var strMeasure6: String? = null,

    @SerializedName("strMeasure7")
    @ColumnInfo("strMeasure7")
    var strMeasure7: String? = null,

    @SerializedName("strMeasure8")
    @ColumnInfo("strMeasure8")
    var strMeasure8: String? = null,

    @SerializedName("strMeasure9")
    @ColumnInfo("strMeasure9")
    var strMeasure9: String? = null,

    @SerializedName("strMeasure10")
    @ColumnInfo("strMeasure10")
    var strMeasure10: String? = null,

    @SerializedName("strMeasure11")
    @ColumnInfo("strMeasure11")
    var strMeasure11: String? = null,

    @SerializedName("strMeasure12")
    @ColumnInfo("strMeasure12")
    var strMeasure12: String? = null,

    @SerializedName("strMeasure13")
    @ColumnInfo("strMeasure13")
    var strMeasure13: String? = null,

    @SerializedName("strMeasure14")
    @ColumnInfo("strMeasure14")
    var strMeasure14: String? = null,

    @SerializedName("strMeasure15")
    @ColumnInfo("strMeasure15")
    var strMeasure15: String? = null,

    @SerializedName("strMeasure16")
    @ColumnInfo("strMeasure16")
    var strMeasure16: String? = null,

    @SerializedName("strMeasure17")
    @ColumnInfo("strMeasure17")
    var strMeasure17: String? = null,

    @SerializedName("strMeasure18")
    @ColumnInfo("strMeasure18")
    var strMeasure18: String? = null,

    @SerializedName("strMeasure19")
    @ColumnInfo("strMeasure19")
    var strMeasure19: String? = null,

    @SerializedName("strMeasure20")
    @ColumnInfo("strMeasure20")
    var strMeasure20: String? = null,

    @SerializedName("strSource")
    @ColumnInfo("strSource")
    var strSource: String? = null,

    @SerializedName("dateModified")
    @ColumnInfo("dateModified")
    var dateModified: String? = null,

    )