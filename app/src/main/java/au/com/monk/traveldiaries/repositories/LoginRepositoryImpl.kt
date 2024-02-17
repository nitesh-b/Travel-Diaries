package au.com.monk.traveldiaries.repositories

import au.com.monk.traveldiaries.data.generic.ErrorResponse
import au.com.monk.traveldiaries.data.generic.ResponseBody
import au.com.monk.traveldiaries.data.UserAccount
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class LoginRepositoryImpl : LoginRepository {
    private var auth: FirebaseAuth = Firebase.auth
    override suspend fun createFirebaseUser(userAccount: UserAccount, password: String): ResponseBody<FirebaseUser> {
        return  try {
            val result = auth.createUserWithEmailAndPassword(userAccount.email!!, password).await()
            ResponseBody<FirebaseUser>(result.user)
        }catch (error: Exception){
            throw ErrorResponse(detail = "Unable to create user. Please try again later.", errorCode = error.hashCode())
        }

    }

    override suspend fun loginUser(email: String, password: String): ResponseBody<FirebaseUser> {
        return  try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            ResponseBody<FirebaseUser>(result.user)
        }catch (error: Exception){
            throw ErrorResponse(detail = "Unable to create user. Please try again later.", errorCode = error.hashCode())
        }
    }
}