package com.android.practise.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.practise.base.BaseFragment
import com.android.practise.databinding.FragmentCartBinding

class CartFragment : BaseFragment<FragmentCartBinding>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun setFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCartBinding.inflate(inflater, container, false)

}