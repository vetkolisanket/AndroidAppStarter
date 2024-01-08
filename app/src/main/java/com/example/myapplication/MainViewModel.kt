package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    private val _dataLd = MutableLiveData<Resource<String>>()
    val dataLd: LiveData<Resource<String>> = _dataLd

    fun getData() {
        _dataLd.value = Resource.loading()
        viewModelScope.launch {
            val data = repository.getData()
            _dataLd.value = Resource.success(data)
        }
    }
}