package au.com.monk.traveldiaries.data

//Firebase User account
data class UserAccount(
    val id: String,
    val firstName: String?,
    val lastName: String?,
    val name: String?,
    val userHandle: String,
    val dateOfBirthTS: Long?,
    val email: String?
)
