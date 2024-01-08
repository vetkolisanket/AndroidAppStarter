package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _dataLd = MutableLiveData<Resource<String>>()
    val dataLd: LiveData<Resource<String>> = _dataLd
    private val repository by lazy { MainRepository }

    fun getData() {
        _dataLd.value = Resource.loading()
        viewModelScope.launch {
            val data = repository.getData()
            _dataLd.value = Resource.success(data)
        }
    }
}