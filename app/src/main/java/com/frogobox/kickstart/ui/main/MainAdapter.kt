package com.frogobox.kickstart.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import com.frogobox.kickstart.common.base.BaseAdapter
import com.frogobox.kickstart.common.base.BaseViewHolder
import com.frogobox.kickstart.common.callback.OnItemClickCallback
import com.frogobox.kickstart.databinding.ContentArticleVerticalBinding
import com.frogobox.kickstart.domain.model.MealModel
import com.frogobox.sdk.ext.setImageExt

/**
 * Created by faisalamircs on 10/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


class MainAdapter : BaseAdapter<MealModel, MainAdapter.MainHolder>() {

    override fun bindVH(
        holder: MainHolder,
        position: Int,
    ) {
        holder.bindData(asyncListDiffer.currentList[position], position)
    }

    override fun adapterAreItemsTheSame(
        oldItem: MealModel,
        newItem: MealModel,
    ): Boolean {
        return oldItem.idMeal == newItem.idMeal
    }

    override fun adapterAreContentsTheSame(
        oldItem: MealModel,
        newItem: MealModel,
    ): Boolean {
        return oldItem == newItem
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MainHolder {
        return MainHolder(
            binding = ContentArticleVerticalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onItemClickCallback = onItemClickCallback
        )
    }

    inner class MainHolder(
        private val binding: ContentArticleVerticalBinding,
        private val onItemClickCallback: OnItemClickCallback? = null,
    ) : BaseViewHolder<MealModel>(binding.root) {

        override fun bindData(model: MealModel, position: Int?) {
            binding.apply {
                ivUrl.setImageExt(model.strMealThumb)
                tvTitle.text = model.strMeal
                tvDescription.text = model.strCategory
                tvPublished.text = model.strArea

                root.setOnClickListener { v ->
                    onItemClickCallback?.onItemClick(v, model, position)
                }
            }
        }
    }
}