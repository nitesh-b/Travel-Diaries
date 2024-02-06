package au.com.monk.traveldiaries.repositories

import au.com.monk.traveldiaries.data.ResponseBody
import au.com.monk.traveldiaries.data.User
import com.google.firebase.auth.FirebaseUser

interface LoginRepository {
    suspend fun createFirebaseUser(user: User, password: String): ResponseBody<FirebaseUser>
    suspend fun loginUser(email: String, password: String): ResponseBody<FirebaseUser>


}