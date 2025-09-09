package com.frogobox.kickstart.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.frogobox.kickstart.common.base.BaseActivity
import com.frogobox.kickstart.databinding.ActivityDetailBinding
import com.frogobox.kickstart.domain.model.Meal
import com.frogobox.sdk.ext.getExtraExt
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    companion object {
        const val EXTRA_DATA = "EXTRA_DATA"
        const val EXTRA_DATA_FAV = "EXTRA_DATA_FAV"

        fun createIntent(context: Context): Intent {
            return Intent(context, DetailActivity::class.java).apply {

            }
        }

        fun launch(context: Context) {
            context.startActivity(createIntent(context))
        }

    }

    private val viewModel : DetailViewModel by viewModels()

    override fun setupViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {

    }

    override fun onCreateExt(savedInstanceState: Bundle?) {
        super.onCreateExt(savedInstanceState)
        setupDetailActivity("Detail Berita")

        val extraArticle = getExtraExt<Meal>(EXTRA_DATA)

        binding.apply {
            tvTitle.text = extraArticle.strMeal
        }

    }

}