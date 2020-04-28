package com.frogobox.kickstart.base.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * Kick-Start-Template
 * Copyright (C) 10/09/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.basemusicplayer.base
 *
 */
abstract class BaseViewAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {

    private lateinit var mViewListener: BaseViewListener<T>

    private val mRecyclerViewDataList = mutableListOf<T>()
    private var mRecyclerViewLayout: Int = 0

    fun setupRequirement(viewListener: BaseViewListener<T>, dataList: List<T>, layoutItem: Int) {

        mRecyclerViewLayout = layoutItem
        mViewListener = viewListener

        mRecyclerViewDataList.clear()
        mRecyclerViewDataList.addAll(dataList)
        notifyDataSetChanged()
    }

    protected fun viewLayout(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(mRecyclerViewLayout, parent, false)
    }

    override fun getItemCount(): Int = mRecyclerViewDataList.size

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bindItem(mRecyclerViewDataList[position], mViewListener)
    }

}