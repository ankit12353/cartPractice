package com.android.practise.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding,VM : ViewModel> : Fragment() {

    protected lateinit var binding: VB
    protected lateinit var viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = setFragmentBinding(inflater,container)
        viewModel = ViewModelProvider(requireActivity()).get(getViewModel())
        return binding.root
    }

    abstract fun setFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    abstract fun getViewModel() : Class<VM>
}