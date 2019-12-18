package com.frogobox.kickstart.ui.activity

import android.os.Bundle
import com.frogobox.kickstart.R
import com.frogobox.kickstart.base.admob.BaseAdmobActivity

class AboutUsActivity : BaseAdmobActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        setupDetailActivity("")
    }
}
