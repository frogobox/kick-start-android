package com.frogobox.kickstart.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.frogobox.kickstart.common.base.BaseActivity
import com.frogobox.kickstart.databinding.ActivityDetailBinding
import com.frogobox.kickstart.domain.model.Meal
import com.frogobox.sdk.ext.getExtraExt
import com.frogobox.sdk.ext.setImageExt
import com.frogobox.sdk.ext.toJson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    companion object {
        const val EXTRA_DATA = "EXTRA_DATA"
        const val EXTRA_DATA_FAV = "EXTRA_DATA_FAV"

        fun createIntent(context: Context, data: Meal): Intent {
            return Intent(context, DetailActivity::class.java).apply {
                putExtra(EXTRA_DATA, data.toJson())
            }
        }

        fun launch(context: Context, data: Meal) {
            context.startActivity(createIntent(context, data))
        }

    }

    private val viewModel: DetailViewModel by viewModels()

    override fun setupViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {

    }

    override fun onCreateExt(savedInstanceState: Bundle?) {
        super.onCreateExt(savedInstanceState)
        setupDetailActivity("Detail Meals")

        val extra = getExtraExt<Meal>(EXTRA_DATA)

        binding.apply {
            ivUrl.setImageExt(extra.strMealThumb)
            tvSource.text = extra.strArea
            tvTitle.text = extra.strMeal
            tvContent.text = extra.strCategory
        }

    }

}