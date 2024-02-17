package au.com.monk.traveldiaries.data.generic

sealed class ViewState<out T>{
    object Loading : ViewState<Nothing>()
    data class Success<T>(val data: T) : ViewState<T>()
    data class Failure(val errorResponse: ErrorResponse): ViewState<Nothing>()

}
