package com.android.practise.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.practise.base.BaseRvAdapter
import com.android.practise.databinding.ItemListBinding
import com.android.practise.ui.main.model.Item

class CartRvAdapter : BaseRvAdapter<Item, ItemListBinding>() {
    override fun onBindViewHolder(holder: BaseViewHolder<ItemListBinding>, position: Int) {
        val item = list[position]
        holder.binding.apply {
            tvShowName.text = item.name
            tvShowPrice.text = item.price
            tvShowQuantity.text = item.quantity
            val totalPrice = item.quantity.toInt() * item.price.toInt()
            tvShowTotalPrice.text = totalPrice.toString()

            btnAddToCart.visibility = View.GONE
        }
    }

    override fun setViewHolder(parent: ViewGroup) =
        ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
}
