package com.android.practise.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.practise.base.BaseRvAdapter
import com.android.practise.databinding.ItemListBinding
import com.android.practise.ui.main.model.Item

class ItemListRvAdapter : BaseRvAdapter<Item, ItemListBinding>() {
    override fun onBindViewHolder(holder: BaseViewHolder<ItemListBinding>, position: Int) {

        holder.binding.apply {
            tvShowName.text = list[position].name
            tvShowPrice.text = list[position].price
            tvShowQuantity.text = list[position].quantity
            tvShowTotalPrice.visibility = View.GONE
            llAddRem.visibility = View.GONE
        }
    }

    override fun setViewHolder(parent: ViewGroup) =
        ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
}