package com.frogobox.kickstart.mvvm.detail

import android.os.Bundle
import android.view.LayoutInflater
import com.frogobox.kickstart.R
import com.frogobox.kickstart.core.BaseActivity
import com.frogobox.kickstart.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(LayoutInflater.from(this))

        setContentView(R.layout.activity_detail)
        val extra = intent.extras?.getString("EXTRA_DATA_ARTICLE")
    }

}