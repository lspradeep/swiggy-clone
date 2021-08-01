package com.android.compose.swiggyclone.features

data class Resource<out T>(val resourceStatus: ResourceStatus, val data: T?, val message: String?) {

    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(ResourceStatus.SUCCESS, data, null)
        }

        fun <T> error(msg: String): Resource<T> {
            return Resource(ResourceStatus.ERROR, null, msg)
        }

        fun <T> offlineError(msg: String): Resource<T> {
            return Resource(ResourceStatus.ERROR, null, msg)
        }

        fun <T> loading(): Resource<T> {
            return Resource(ResourceStatus.LOADING, null, null)
        }

        fun <T> empty(msg: String): Resource<T> {
            return Resource(ResourceStatus.ERROR, null, msg)
        }

    }

}