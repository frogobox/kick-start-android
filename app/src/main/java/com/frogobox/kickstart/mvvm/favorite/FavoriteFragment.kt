package com.frogobox.kickstart.mvvm.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.frogobox.kickstart.core.BaseFragment
import com.frogobox.kickstart.databinding.FragmentFavoriteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {

    private val favoriteViewModel : FavoriteViewModel by viewModel()

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoriteBinding {
        return FragmentFavoriteBinding.inflate(inflater, container, false)
    }

    override fun setupViewModel() {
        favoriteViewModel.apply {

        }
    }

    override fun setupOnViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}