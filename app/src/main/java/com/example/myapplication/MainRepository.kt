package com.example.myapplication

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object MainRepository {
    suspend fun getData(): String {
        return withContext(Dispatchers.IO) {
            "ABC"
        }
    }
}