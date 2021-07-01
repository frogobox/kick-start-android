package com.frogobox.kickstart.mvvm.about

import android.os.Bundle
import android.view.LayoutInflater
import com.frogobox.kickstart.R
import com.frogobox.kickstart.core.BaseActivity
import com.frogobox.kickstart.databinding.ActivityAboutUsBinding

class AboutUsActivity : BaseActivity<ActivityAboutUsBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutUsBinding.inflate(LayoutInflater.from(this))
        setContentView(R.layout.activity_about_us)
        setupDetailActivity("")
    }
}
