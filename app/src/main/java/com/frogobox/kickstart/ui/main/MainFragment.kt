package com.frogobox.kickstart.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.frogobox.kickstart.common.base.BaseFragment
import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.databinding.FragmentMainBinding
import com.frogobox.sdk.ext.gone
import com.frogobox.sdk.ext.showLogD
import com.frogobox.sdk.ext.showToast
import com.frogobox.sdk.ext.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater, container, false)
    }

    override fun setupViewModel() {
        viewModel.mealsState.observe(this) {
            when (it) {
                is Resource.Error -> {
                    binding.progressView.gone()
                    requireContext().showToast(it.message.toString())
                }

                is Resource.Loading -> {
                    binding.progressView.visible()
                }

                is Resource.Success -> {
                    binding.progressView.gone()
                    Log.d("MainFragment", "Success : ${it.data}")
                }
            }
        }
    }


    override fun onViewCreatedExt(view: View, savedInstanceState: Bundle?) {
        super.onViewCreatedExt(view, savedInstanceState)
        viewModel.searchMeal("Cream")
    }


    override fun onDestroy() {
        super.onDestroy()
        viewModel.onClearDisposable()
    }

}
