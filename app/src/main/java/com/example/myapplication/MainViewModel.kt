package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _dataLd = MutableLiveData<String>()
    val dataLd: LiveData<String> = _dataLd
    private val repository by lazy { MainRepository }

    fun getData() {
        viewModelScope.launch {
            val data = repository.getData()
            _dataLd.value = data
        }
    }
}