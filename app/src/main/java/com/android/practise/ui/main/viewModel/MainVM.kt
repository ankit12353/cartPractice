package com.android.practise.ui.main.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.practise.ui.main.model.Item

class MainVM: ViewModel() {

    val item: MutableLiveData<Item> = MutableLiveData()

}