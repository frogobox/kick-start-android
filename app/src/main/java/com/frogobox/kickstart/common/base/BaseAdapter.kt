package com.frogobox.kickstart.common.base

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.frogobox.kickstart.common.callback.OnItemClickCallback

/** Standard BaseAdapter Handling BaseModel List and  BaseViewHolder**/

abstract class BaseAdapter<BM, T : BaseViewHolder<BM>> : RecyclerView.Adapter<T>() {

    var onItemClickCallback: OnItemClickCallback? = null

    var selectedItem = mutableListOf<BM>()

    fun setSelectedItems(items: MutableList<BM>) {
        selectedItem = items
        notifyDataSetChanged()
    }

    protected val asyncListDiffer = AsyncListDiffer(this, object : DiffUtil.ItemCallback<BM>() {
        override fun areItemsTheSame(oldItem: BM & Any, newItem: BM & Any): Boolean {
            return adapterAreItemsTheSame(oldItem, newItem)
        }

        override fun areContentsTheSame(oldItem: BM & Any, newItem: BM & Any): Boolean {
            return adapterAreContentsTheSame(oldItem, newItem)
        }
    })

    abstract fun bindVH(holder: T, position: Int)

    abstract fun adapterAreItemsTheSame(oldItem: BM & Any, newItem: BM & Any): Boolean

    abstract fun adapterAreContentsTheSame(oldItem: BM & Any, newItem: BM & Any): Boolean

    override fun getItemCount(): Int {
        return asyncListDiffer.currentList.size
    }

    fun getLastItemPosition(): Int {
        return if (itemCount == 0) {
            0
        } else {
            itemCount - 1
        }
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        bindVH(holder, position)
    }

    open fun setOnItemCallBack(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    open fun getItem(): MutableList<BM> = asyncListDiffer.currentList.toMutableList()

    open fun setItem(item: List<BM>) {
        if (item.isEmpty()) {
            asyncListDiffer.submitList(listOf())
        } else {
            asyncListDiffer.submitList(item.map { it })
        }
    }

    open fun clearItems() {
        asyncListDiffer.submitList(null)
    }

    open fun insert(item: BM, position: Int) {
        val listItems = asyncListDiffer.currentList.toMutableList()
        listItems.add(position + 1, item)
        val changedCount = itemCount - position + 1
        asyncListDiffer.submitList(listItems) {
            // Trigger onBindViewHolder for the rest of the items that moved to the end of the list
            notifyItemRangeChanged(position, changedCount)
        }

    }

    open fun delete(item: BM) {
        val listItems = asyncListDiffer.currentList.toMutableList()
        val position = listItems.indexOf(item)
        listItems.remove(item)
        val changedCount = itemCount - position
        asyncListDiffer.submitList(listItems) {
            // Triggered once deletion is done and notifyItemRangeRemoved has been called
            notifyItemRangeChanged(position, changedCount)
        }
    }

    open fun delete(position: Int) {
        val listItems = asyncListDiffer.currentList.toMutableList()
        listItems.removeAt(position)
        val changedCount = itemCount - position
        asyncListDiffer.submitList(listItems) {
            // Triggered once deletion is done and notifyItemRangeRemoved has been called
            notifyItemRangeChanged(position, changedCount)
        }
    }

    open fun moveItem(from: Int, to: Int) {
        val listItems = asyncListDiffer.currentList.toMutableList()
        val fromLocation = listItems[from]
        listItems.removeAt(from)
        if (to < from) {
            listItems.add(to + 1, fromLocation)
        } else {
            listItems.add(to - 1, fromLocation)
        }
        asyncListDiffer.submitList(listItems) {
            notifyItemMoved(from, to)
        }
    }

}