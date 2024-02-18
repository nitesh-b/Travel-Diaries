package au.com.monk.traveldiaries.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import au.com.monk.traveldiaries.data.UserAccount
import au.com.monk.traveldiaries.data.UserContent
import au.com.monk.traveldiaries.data.generic.ErrorResponse
import au.com.monk.traveldiaries.data.generic.ViewState
import au.com.monk.traveldiaries.repositories.UserAccountRepositoryImpl
import kotlinx.coroutines.launch

class UserAccountViewModel: BaseViewModel() {

    private val repository = UserAccountRepositoryImpl()

    private val _userDetail = MutableLiveData<ViewState<UserAccount>>()
    val userDetail: LiveData<ViewState<UserAccount>> get() = _userDetail

    private val _userContent  = MutableLiveData<ViewState<List<UserContent>>>()
    val userContent : LiveData<ViewState<List<UserContent>>> get() = _userContent

    fun getUserContent(){
        _userContent.value = ViewState.Loading
        try {
            viewModelScope.launch {
                val response = repository.getContent("", "")
                    response.result?.let {
                    _userContent.value = ViewState.Success(it)
                    }
            }

        }catch (error: ErrorResponse){
            _userContent.value = ViewState.Failure(error)
        }
    }


}