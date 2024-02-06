package au.com.monk.traveldiaries.data

data class ResponseBody<T>(
    val result: T? = null,
    val errorResponse: ErrorResponse? = null,
    val reesponseCode: Int? = 0,
)
