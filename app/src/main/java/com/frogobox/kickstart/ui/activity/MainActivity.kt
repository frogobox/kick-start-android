package com.frogobox.kickstart.ui.activity

import android.os.Bundle
import com.frogobox.kickstart.R
import com.frogobox.kickstart.base.admob.BaseAdmobActivity
import kotlinx.android.synthetic.main.ads_phone_tab_special_smart_banner.*

class MainActivity : BaseAdmobActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupShowAdsBanner(ads_phone_tab_special_smart_banner)

    }


}
