package com.frogobox.kickstart.mvvm.favorite

import android.app.Application
import com.frogobox.kickstart.core.BaseViewModel
import com.frogobox.kickstart.source.ProjectDataRepository

class FavoriteViewModel(
    private val context: Application,
    private val repository: ProjectDataRepository
) : BaseViewModel(context, repository) {
    // TODO: Implement the ViewModel
}