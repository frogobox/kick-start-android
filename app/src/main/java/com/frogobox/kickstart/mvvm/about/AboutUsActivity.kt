package com.frogobox.kickstart.mvvm.about

import android.os.Bundle
import com.frogobox.kickstart.core.BaseActivity
import com.frogobox.kickstart.databinding.ActivityAboutUsBinding

class AboutUsActivity : BaseActivity<ActivityAboutUsBinding>() {

    override fun setupViewBinding(): ActivityAboutUsBinding {
        return ActivityAboutUsBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {}

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity("")
    }
}
