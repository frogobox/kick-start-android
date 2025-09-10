package com.frogobox.kickstart.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.frogobox.kickstart.common.base.BaseActivity
import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.databinding.ActivityDetailBinding
import com.frogobox.kickstart.domain.model.MealModel
import com.frogobox.sdk.ext.getExtraExt
import com.frogobox.sdk.ext.gone
import com.frogobox.sdk.ext.setImageExt
import com.frogobox.sdk.ext.showLogD
import com.frogobox.sdk.ext.showToast
import com.frogobox.sdk.ext.toJson
import com.frogobox.sdk.ext.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    companion object {
        const val EXTRA_DATA = "EXTRA_DATA"

        fun createIntent(context: Context, data: MealModel): Intent {
            return Intent(context, DetailActivity::class.java).apply {
                putExtra(EXTRA_DATA, data.toJson())
            }
        }

        fun launch(context: Context, data: MealModel) {
            context.startActivity(createIntent(context, data))
        }

    }

    private val viewModel: DetailViewModel by viewModels()

    override fun setupViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
        viewModel.mealsState.observe(this) {
            when (it) {
                is Resource.Error -> {
                    binding.progressView.gone()
                    showToast(it.message.toString())
                }

                is Resource.Loading -> {
                    binding.progressView.visible()
                }

                is Resource.Success -> {
                    binding.progressView.gone()
                    it.data?.let { items ->
                        if (!items.isEmpty()) {
                            binding.btnInsert.gone()
                            binding.btnDelete.visible()
                        }
                    }
                }
            }
        }

        viewModel.insertState.observe(this) {
            when (it) {
                is Resource.Error -> {
                    binding.progressView.gone()
                    showToast(it.message.toString())
                }

                is Resource.Loading -> {
                    binding.progressView.visible()
                }

                is Resource.Success -> {
                    binding.progressView.gone()
                    binding.btnInsert.gone()
                    binding.btnDelete.visible()
                    showToast("Berhasil Menambahkan Ke Favorite ${it.data?.strMeal}")
                }
            }
        }

        viewModel.deleteState.observe(this) {
            when (it) {
                is Resource.Error -> {
                    binding.progressView.gone()
                    showToast(it.message.toString())
                }

                is Resource.Loading -> {
                    binding.progressView.visible()
                }

                is Resource.Success -> {
                    binding.progressView.gone()
                    finish()
                }
            }
        }
    }

    override fun onCreateExt(savedInstanceState: Bundle?) {
        super.onCreateExt(savedInstanceState)
        setupDetailActivity("Detail Meals")

        val extra = getExtraExt<MealModel>(EXTRA_DATA)
        viewModel.mealModel = extra
        viewModel.getData()

        binding.apply {
            ivUrl.setImageExt(extra.strMealThumb)
            tvSource.text = extra.strArea
            tvTitle.text = extra.strMeal
            tvContent.text = extra.strCategory

            btnInsert.setOnClickListener {
                viewModel.insertToDB()
            }

            btnDelete.setOnClickListener {
                viewModel.removeFromDb()
            }
        }

    }

}