package au.com.monk.traveldiaries.data

//Firebase User account
data class User(
    val firstName: String,
    val lastName: String,
    val userHandle: String,
    val dob: Long,      //timestamp
    val email: String
)
