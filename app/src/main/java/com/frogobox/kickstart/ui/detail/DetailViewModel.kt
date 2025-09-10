package com.frogobox.kickstart.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.frogobox.kickstart.common.base.BaseViewModel
import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.domain.model.MealModel
import com.frogobox.kickstart.domain.source.meal.usecase.MealUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by faisalamir on 12/07/21
 * KickStartProject
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 Frogobox Inc.
 * All rights reserved
 *
 */

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCase: MealUseCase,
) : BaseViewModel() {

    var mealModel: MealModel? = null

    private var _mealsState = MutableLiveData<Resource<List<MealModel>>>()
    var mealsState: LiveData<Resource<List<MealModel>>> = _mealsState

    private var _insertState = MutableLiveData<Resource<MealModel>>()
    var insertState: LiveData<Resource<MealModel>> = _insertState

    private var _deleteState = MutableLiveData<Resource<String>>()
    var deleteState: LiveData<Resource<String>> = _deleteState

    fun getData() {
        viewModelScope.launch {
            mealModel?.idMeal?.let {
                useCase.searchById(it).onEach {
                    _mealsState.postValue(it)
                }.launchIn(viewModelScope)
            }
        }
    }

    fun insertToDB() {
        viewModelScope.launch {
            mealModel?.let {
                useCase.insertToFavorite(it).onEach {
                    _insertState.postValue(it)
                }.launchIn(viewModelScope)
            }
        }
    }

    fun removeFromDb() {
        viewModelScope.launch {
            mealModel?.idMeal?.let {
                useCase.deleteFromMealId(it).onEach {
                    _deleteState.postValue(it)
                }.launchIn(viewModelScope)
            }
        }
    }

}