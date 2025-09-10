package com.frogobox.kickstart.common.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/** RV ViewHolder Base **/
abstract class BaseViewHolder<in BaseModel>(rootView: View) : RecyclerView.ViewHolder(rootView) {
    abstract fun bindData(model: BaseModel, position: Int? = -1)
}

abstract class CheckedViewHolder<in BaseModel>(rootView: View) :
    BaseViewHolder<BaseModel>(rootView) {
    abstract fun bindData(model: BaseModel, position: Int?, checked: Boolean?)
}

abstract class EditorViewHolder<in BaseModel>(rootView: View) :
    BaseViewHolder<BaseModel>(rootView) {
    abstract fun bindData(model: BaseModel, position: Int?, onChange: (String) -> Unit)
}