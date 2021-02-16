package com.android.practise.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.practise.ui.main.viewModel.MainVM

@Suppress("UNCHECKED_CAST")
class ViewModelFactory() : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainVM::class.java) -> MainVM() as T
            else -> throw IllegalArgumentException("VM Not found")
        }
    }
}