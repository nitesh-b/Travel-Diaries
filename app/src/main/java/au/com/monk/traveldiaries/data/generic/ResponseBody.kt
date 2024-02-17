package au.com.monk.traveldiaries.data.generic

data class ResponseBody<T>(
    val result: T? = null,
    val errorResponse: ErrorResponse? = null,
    val reesponseCode: Int? = 0,
)
