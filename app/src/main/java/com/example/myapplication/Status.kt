package com.example.myapplication

data class Resource<out T>(val status: Status, val data: T? = null, val message: String? = null) {
    companion object {
        fun <T> loading() = Resource<T>(Status.Loading)
        fun <T> success(data: T) = Resource<T>(Status.Success, data)
        fun <T> error(message: String?) = Resource<T>(Status.Error, null, message)
    }
}

enum class Status {
    Loading,
    Success,
    Error
}
