package com.android.practise.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.android.practise.ui.main.model.Item

abstract class BaseRvAdapter<T : Any, VB : ViewBinding> :
    RecyclerView.Adapter<BaseRvAdapter.BaseViewHolder<VB>>() {

    var list = mutableListOf<T>()

    fun addItems(list: MutableList<T>) {
        this.list.clear()
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)  = BaseViewHolder<VB> (
        setViewHolder(parent)
    )

    class BaseViewHolder<VB : ViewBinding>(val binding: VB) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun getItemCount() = list.size

    abstract fun setViewHolder(parent: ViewGroup): VB
}