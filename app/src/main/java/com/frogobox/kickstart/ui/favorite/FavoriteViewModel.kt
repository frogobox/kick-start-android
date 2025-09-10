package com.frogobox.kickstart.ui.favorite

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

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val useCase: MealUseCase,
) : BaseViewModel() {

    private var _mealsState = MutableLiveData<Resource<List<MealModel>>>()
    var mealsState: LiveData<Resource<List<MealModel>>> = _mealsState

    fun getData() {
        viewModelScope.launch {
            useCase.getAllFavorite().onEach {
                _mealsState.postValue(it)
            }.launchIn(viewModelScope)
        }
    }

}