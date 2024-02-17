package au.com.monk.traveldiaries.repositories

import au.com.monk.traveldiaries.data.generic.ResponseBody
import au.com.monk.traveldiaries.data.UserAccount
import com.google.firebase.auth.FirebaseUser

interface LoginRepository {
    suspend fun createFirebaseUser(userAccount: UserAccount, password: String): ResponseBody<FirebaseUser>
    suspend fun loginUser(email: String, password: String): ResponseBody<FirebaseUser>


}