package com.frogobox.kickstart.mvvm.detail

import android.os.Bundle
import com.frogobox.kickstart.core.BaseActivity
import com.frogobox.kickstart.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    companion object {
        const val EXTRA_DATA = "extre"
    }

    override fun setupViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {}

    override fun setupUI(savedInstanceState: Bundle?) {}

}