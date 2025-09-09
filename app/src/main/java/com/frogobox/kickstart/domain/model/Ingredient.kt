package com.frogobox.kickstart.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * Copyright (C) 15/03/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 *
 */

data class Ingredient(

    @SerializedName("idIngredient")
    var idIngredient: String? = null,

    @SerializedName("strIngredient")
    var strIngredient: String? = null,

    @SerializedName("strDescription")
    var strDescription: String? = null,

    @SerializedName("strType")
    var strType: String? = null

)