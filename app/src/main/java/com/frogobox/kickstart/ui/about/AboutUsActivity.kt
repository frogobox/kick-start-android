package com.frogobox.kickstart.ui.about

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.frogobox.kickstart.common.base.BaseActivity
import com.frogobox.kickstart.databinding.ActivityAboutUsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutUsActivity : BaseActivity<ActivityAboutUsBinding>() {

    companion object {

        fun createIntent(context: Context): Intent {
            return Intent(context, AboutUsActivity::class.java).apply {

            }
        }

        fun launch(context: Context) {
            context.startActivity(createIntent(context))
        }

    }

    override fun setupViewBinding(): ActivityAboutUsBinding {
        return ActivityAboutUsBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {}

    override fun onCreateExt(savedInstanceState: Bundle?) {
        super.onCreateExt(savedInstanceState)
        setupDetailActivity("")
    }

}
