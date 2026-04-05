package oop_00000075344_FaturachmanAlkahfi.week07

enum class AppState {
    IDLE,
    LOADING,
    SUCCESS,
    ERROR
}

sealed class ApiResponse {
    data class Success(val data: String) : ApiResponse()
    data class Error(val message: String) : ApiResponse()
    object Loading : ApiResponse()
}
