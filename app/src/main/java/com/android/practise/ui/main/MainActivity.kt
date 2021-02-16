package com.android.practise.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.practise.databinding.ActivityMainBinding
import com.android.practise.ui.main.adapter.VPAdapter
import com.android.practise.ui.main.fragment.AddFragment
import com.android.practise.ui.main.fragment.CartFragment
import com.android.practise.ui.main.fragment.ListFragment
import com.android.practise.ui.main.model.Item

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpVP()

    }

    fun switchViewPager(item: Int) {
        binding.viewpager.setCurrentItem(item, true)
    }

    private fun setUpVP() {
        val adapter = VPAdapter(supportFragmentManager)
        adapter.addFragment(AddFragment(), "Add")
        adapter.addFragment(ListFragment(), "List")
        adapter.addFragment(CartFragment(), "Cart")

        binding.viewpager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewpager)
    }

}