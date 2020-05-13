package com.frogobox.kickstart.mvvm.ui.activity

import android.os.Bundle
import com.frogobox.kickstart.R
import com.frogobox.kickstart.base.view.ui.BaseActivity

class AboutUsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        setupDetailActivity("")
    }
}
