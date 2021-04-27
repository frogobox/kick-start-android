package com.frogobox.kickstart.mvvm.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.frogobox.kickstart.R
import com.frogobox.kickstart.source.model.Article

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val extra = intent.extras?.getString("EXTRA_DATA_ARTICLE")


    }
}