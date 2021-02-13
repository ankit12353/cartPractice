package com.android.practise.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.android.practise.R
import com.android.practise.base.BaseFragment
import com.android.practise.databinding.FragmentAddBinding
import com.android.practise.ui.main.model.Item

class AddFragment : BaseFragment<FragmentAddBinding>(){

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.btnSubmit.setOnClickListener { submit() }
    }

    private fun submit() {
        val name = binding.etName.text.toString().trim()
        val price = binding.etPrice.text.toString().trim()
        val quantity = binding.etQuantity.text.toString().trim()

        val item  = Item(name,price,quantity)
        val bundle = bundleOf("item" to item)
        requireView().findNavController().navigate(R.id.action_addFragment_to_listFragment,bundle)

        /*
        *val action = AddFragmentDirections.actionAddFragmentToListFragment(item)
        */

    }

    override fun setFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentAddBinding.inflate(inflater,container,false)
}