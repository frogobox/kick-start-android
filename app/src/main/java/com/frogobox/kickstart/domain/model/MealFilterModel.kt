package com.frogobox.kickstart.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Faisal Amir
 * Frogobox Inc License
 * -----------------------------------------
 * TheMealsAPI
 * Copyright (C) 15/03/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * Frogobox Software Industries
 * com.frogobox.frogoconsumeapi.meal.data.model
 *
 */
data class MealFilterModel(

    @SerializedName("strMeal")
    var strMeal: String? = null,

    @SerializedName("strMealThumb")
    var strMealThumb: String? = null,

    @SerializedName("idMeal")
    var idMeal: String? = null

)