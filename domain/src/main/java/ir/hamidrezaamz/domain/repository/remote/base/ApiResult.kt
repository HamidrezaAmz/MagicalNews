package ir.hamidrezaamz.domain.repository.remote.base

sealed class ApiResult<out T>(val apiStatus: ApiStatus, val data: T?, val message: String?) {

    enum class ApiStatus {
        SUCCESS,
        ERROR,
        LOADING,
        IDLE
    }

    data class Success<out R>(val _data: R?) : ApiResult<R>(
        apiStatus = ApiStatus.SUCCESS,
        data = _data,
        message = null
    )

    data class Error(val exception: String) : ApiResult<Nothing>(
        apiStatus = ApiStatus.ERROR,
        data = null,
        message = exception
    )

    data class Loading<out R>(val _data: R? = null) : ApiResult<R>(
        apiStatus = ApiStatus.LOADING,
        data = _data,
        message = null
    )

}