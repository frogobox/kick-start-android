package com.frogobox.kickstart.mvvm.detail

import android.os.Bundle
import com.bumptech.glide.Glide
import com.frogobox.coreutil.news.model.Article
import com.frogobox.kickstart.R
import com.frogobox.kickstart.core.BaseActivity
import com.frogobox.kickstart.databinding.ActivityDetailBinding
import com.frogobox.sdk.ext.getExtraDataExt
import com.frogobox.sdk.ext.glideLoad

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    companion object {
        const val EXTRA_DATA = "EXTRA_DATA"
        const val EXTRA_DATA_FAV = "EXTRA_DATA_FAV"
    }

    override fun setupViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {

    }

    override fun onCreateExt(savedInstanceState: Bundle?) {
        super.onCreateExt(savedInstanceState)
        setupDetailActivity("Detail Berita")

        val extraArticle = getExtraDataExt<Article>(EXTRA_DATA)

        binding.apply {
            tvTitle.text = extraArticle.title
            tvSource.text = extraArticle.source?.name ?: ""
            tvContent.text = extraArticle.description
            Glide.with(this@DetailActivity)
                .load(extraArticle.urlToImage)
                .placeholder(R.drawable.ic_frogobox)
                .into(ivUrl)
        }

    }



}