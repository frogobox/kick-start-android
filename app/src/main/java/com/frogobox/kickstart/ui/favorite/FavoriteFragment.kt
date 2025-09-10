package com.frogobox.kickstart.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.frogobox.kickstart.common.base.BaseFragment
import com.frogobox.kickstart.common.callback.OnItemClickCallback
import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.databinding.FragmentFavoriteBinding
import com.frogobox.kickstart.domain.model.MealModel
import com.frogobox.kickstart.ui.detail.DetailActivity
import com.frogobox.kickstart.ui.main.MainAdapter
import com.frogobox.sdk.ext.gone
import com.frogobox.sdk.ext.showLogD
import com.frogobox.sdk.ext.showToast
import com.frogobox.sdk.ext.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {

    private val viewModel : FavoriteViewModel by activityViewModels()

    private val mainAdapter: MainAdapter by lazy {
        MainAdapter()
    }

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoriteBinding {
        return FragmentFavoriteBinding.inflate(inflater, container, false)
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
                    it.data?.let { items ->
                        if (items.isEmpty()) {
                            binding.tvEmpty.visible()
                        } else {
                            binding.tvEmpty.gone()
                        }
                        mainAdapter.setItem(items)
                    }
                }
            }
        }
    }

    override fun onViewCreatedExt(view: View, savedInstanceState: Bundle?) {
        super.onViewCreatedExt(view, savedInstanceState)
        viewModel.getData()
        binding.apply {
            rv.adapter = mainAdapter
            rv.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)


            mainAdapter.setOnItemCallBack(object : OnItemClickCallback {
                override fun onItemClick(
                    view: View,
                    objects: Any,
                    position: Int?,
                ) {
                    (objects as MealModel).let {
                        mActivity.startActivityResultExt(DetailActivity.createIntent(requireContext(), it))
                    }
                }
            })

        }
    }


    override fun onDestroy() {
        super.onDestroy()
        viewModel.onClearDisposable()
    }

}