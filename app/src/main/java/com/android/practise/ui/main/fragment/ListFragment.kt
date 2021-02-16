package com.android.practise.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.practise.base.BaseFragment
import com.android.practise.databinding.FragmentListBinding
import com.android.practise.ui.main.adapter.ItemListRvAdapter
import com.android.practise.ui.main.model.Item
import com.android.practise.ui.main.viewModel.MainVM

class ListFragment : BaseFragment<FragmentListBinding, MainVM>() {

    private val mAdapter by lazy { ItemListRvAdapter() }
    private val items = mutableListOf(
        Item("Laptop", "5000", "6"),
        Item("Mobile", "5000", "5"),
        Item("Desktop", "5000", "6")
    )

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.item.observe(viewLifecycleOwner, Observer {
            items.add(it)
            mAdapter.addItems(items)
        })

        /*
        val item = arguments?.getParcelable<Item>("item")
        if (item != null) {
            items.add(item)
        }
        *val item = ListFragmentArgs.fromBundle(requireArguments()).item
        */

        mAdapter.addItems(items)
        binding.rvItem.apply {
            this.adapter = mAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
        }
        mAdapter.listener = { item, _ ->
            //viewModel.cartItem.value = item
        }
    }

    override fun setFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentListBinding.inflate(inflater, container, false)

    override fun getViewModel() = MainVM::class.java

}