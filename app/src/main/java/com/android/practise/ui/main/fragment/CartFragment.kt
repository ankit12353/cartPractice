package com.android.practise.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.practise.base.BaseFragment
import com.android.practise.databinding.FragmentCartBinding
import com.android.practise.ui.main.adapter.CartRvAdapter
import com.android.practise.ui.main.model.Item
import com.android.practise.ui.main.viewModel.MainVM

class CartFragment : BaseFragment<FragmentCartBinding, MainVM>() {

    private val mAdapter by lazy { CartRvAdapter() }
    private lateinit var cartList: MutableList<Item>

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        cartList = mutableListOf()

//        viewModel.cartItem.observe(viewLifecycleOwner, { item ->
//            cartList.add(item)
//            mAdapter.addItems(cartList)
//        })

        binding.rvCart.apply {
            this.adapter = mAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun setFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCartBinding.inflate(inflater, container, false)

    override fun getViewModel() = MainVM::class.java

}