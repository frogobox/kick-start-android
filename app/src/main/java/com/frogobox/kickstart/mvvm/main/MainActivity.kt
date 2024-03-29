package com.frogobox.kickstart.mvvm.main

import android.content.res.ColorStateList
import android.os.Bundle
import com.frogobox.kickstart.R
import com.frogobox.kickstart.core.BaseActivity
import com.frogobox.kickstart.databinding.ActivityMainBinding
import com.frogobox.kickstart.mvvm.consumable.ConsumableFragment
import com.frogobox.kickstart.mvvm.favorite.FavoriteFragment
import com.frogobox.sdk.ext.getColorExt

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun setupViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {}

    override fun onCreateExt(savedInstanceState: Bundle?) {
        super.onCreateExt(savedInstanceState)
        setupToolbar()
        setupBottomNav(binding.framelayoutMainContainer.id)
        setupFragment(savedInstanceState)
    }

    private fun setupToolbar() {
        supportActionBar?.elevation = 0f
    }

    private fun setupFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            binding.bottomNavMainMenu.selectedItemId = R.id.bottom_menu_consumable
        }
    }

    private fun setupBottomNav(frameLayout: Int) {
        binding.bottomNavMainMenu.apply {
            clearAnimation()

            val iconColorStates = ColorStateList(
                arrayOf(
                    intArrayOf(-android.R.attr.state_checked),
                    intArrayOf(android.R.attr.state_checked)
                ), intArrayOf(
                    getColorExt(R.color.colorTextTitle),
                    getColorExt(R.color.colorPrimary),
                )
            )

            itemIconTintList = iconColorStates
            itemTextColor = iconColorStates

            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.bottom_menu_consumable -> {
                        supportActionBar?.title = getString(R.string.title_consumable)
                        setupChildFragment(
                            frameLayout,
                            ConsumableFragment()
                        )
                        return@setOnItemSelectedListener true
                    }

                    R.id.bottom_menu_favorite -> {
                        supportActionBar?.title = getString(R.string.title_fav)
                        setupChildFragment(
                            frameLayout,
                            FavoriteFragment()
                        )
                        return@setOnItemSelectedListener true
                    }

                    R.id.bottom_menu_main -> {
                        supportActionBar?.title = getString(R.string.title_main)
                        setupChildFragment(
                            frameLayout,
                            MainFragment()
                        )
                        return@setOnItemSelectedListener true
                    }
                }

                false
            }
        }

    }

}
