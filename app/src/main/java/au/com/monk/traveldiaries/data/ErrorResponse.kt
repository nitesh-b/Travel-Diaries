package au.com.monk.traveldiaries.data

class ErrorResponse(detail: String, val errorCode: Int) : Exception(detail) {

    override fun toString(): String {
        return "ErrorResponse(message='$message', errorCode=$errorCode)"
    }
}
