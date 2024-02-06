package au.com.monk.traveldiaries.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import au.com.monk.traveldiaries.R
import au.com.monk.traveldiaries.data.ErrorResponse
import au.com.monk.traveldiaries.data.User
import au.com.monk.traveldiaries.data.ViewState
import au.com.monk.traveldiaries.repositories.LoginRepository
import au.com.monk.traveldiaries.repositories.LoginRepositoryImpl
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginViewModel() : BaseViewModel() {
    private val repository: LoginRepository
    private val _userAccount = MutableLiveData<ViewState<FirebaseUser>>()
    val userAccount: LiveData<ViewState<FirebaseUser>> get() = _userAccount

    private var auth: FirebaseAuth = Firebase.auth

    init {
        repository = LoginRepositoryImpl()
    }

    fun createUser(user: User, password: String) {
        viewModelScope.launch {
            _userAccount.value = ViewState.Loading
            try {
                val response = repository.createFirebaseUser(user, password)
                response.result?.let {
                    _userAccount.value = ViewState.Success(it)
                }
                response.errorResponse?.let {
                    _userAccount.value = ViewState.Failure(it)
                }
            } catch (error: ErrorResponse) {
                _userAccount.value = ViewState.Failure(error)
            }
        }
    }

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            _userAccount.value = ViewState.Loading
            try {
                val response = repository.loginUser(email, password)
                response.result?.let {
                    _userAccount.value = ViewState.Success(it)
                }
                response.errorResponse?.let {
                    _userAccount.value = ViewState.Failure(it)
                }
            } catch (error: ErrorResponse) {
                _userAccount.value = ViewState.Failure(error)
            }
        }
    }

    fun authenticateActiveUser() {
        if (auth.currentUser == null) {
            _userAccount.value =
                ViewState.Failure(ErrorResponse("Session expired. Login again!", 401))
        } else {
            _userAccount.value = ViewState.Success(auth.currentUser!!)
        }
    }

    fun signInWithGoogle(context: Context) {
        val signInRequest = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    // Your server's client ID, not your Android client ID.
                    .setServerClientId(context.getString(R.string.your_web_client_id))
                    // Only show accounts previously used to sign in.
                    .setFilterByAuthorizedAccounts(true)
                    .build()
            )
            .build()

    }


}