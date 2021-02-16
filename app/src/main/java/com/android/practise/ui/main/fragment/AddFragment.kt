package com.android.practise.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.android.practise.base.BaseFragment
import com.android.practise.databinding.FragmentAddBinding
import com.android.practise.ui.main.MainActivity
import com.android.practise.ui.main.model.Item
import com.android.practise.ui.main.viewModel.MainVM

class AddFragment : BaseFragment<FragmentAddBinding, MainVM>() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.btnSubmit.setOnClickListener { submit() }
    }

    private fun submit() {
        val name = binding.etName.text.toString().trim()
        val price = binding.etPrice.text.toString().trim()
        val quantity = binding.etQuantity.text.toString().trim()
        val item  = Item(name, price, quantity)

        viewModel.item.value = item
        clearFields()
        (requireContext() as MainActivity).switchViewPager(1)
        /*
        val bundle = bundleOf("item" to item)
        requireView().findNavController().navigate(R.id.action_addFragment_to_listFragment,bundle)
        *val action = AddFragmentDirections.actionAddFragmentToListFragment(item)
        */

    }

    private fun clearFields(){
        binding.apply {
            etName.text.clear()
            etPrice.text.clear()
            etQuantity.text.clear()
        }
    }

    override fun setFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentAddBinding.inflate(inflater, container, false)

    override fun getViewModel() = MainVM::class.java
}