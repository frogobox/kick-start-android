package com.frogobox.kickstart.mvvm.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import com.frogobox.kickstart.core.BaseFragment
import com.frogobox.kickstart.databinding.FragmentFavoriteBinding

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {


    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup
    ): FragmentFavoriteBinding {
        return FragmentFavoriteBinding.inflate(inflater, container, false)
    }

    override fun setupViewModel() {
        TODO("Not yet implemented")
    }

    override fun setupUI() {
        TODO("Not yet implemented")
    }


}