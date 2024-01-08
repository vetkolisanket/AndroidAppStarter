package com.example.myapplication

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

object MainRepository {
    suspend fun getData(): String {
        return withContext(Dispatchers.IO) {
            delay(1500)
            "ABC"
        }
    }
}