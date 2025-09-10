package com.frogobox.kickstart.common.callback

import android.view.View

interface OnItemClickCallback {
    fun onItemClick(view: View, objects: Any, position: Int?)
    fun onItemLongClick(view: View, objects: Any, position: Int?) {
        throw kotlin.RuntimeException("Stub!");
    }
}