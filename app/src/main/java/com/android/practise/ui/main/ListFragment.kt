package com.android.practise.ui.main

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.practise.ui.main.adapter.ItemListRvAdapter
import com.android.practise.base.BaseFragment
import com.android.practise.databinding.FragmentListBinding
import com.android.practise.ui.main.model.Item
import kotlin.math.log

class ListFragment : BaseFragment<FragmentListBinding>() {

    private val adapter by lazy { ItemListRvAdapter() }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val items = mutableListOf(
            Item("Laptop", "5000", "6"),
            Item("Mobile", "5000", "5"),
            Item("Desktop", "5000", "6")
        )
        /*
        *val item = ListFragmentArgs.fromBundle(requireArguments()).item
        */
        val item = arguments?.getParcelable<Item>("item")
        if (item != null) {
            items.add(item)
        }

        val adapter = ItemListRvAdapter()
        adapter.addItems(items)
        binding.rvItem.apply {
            this.adapter = adapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun setFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentListBinding.inflate(inflater, container, false)

}