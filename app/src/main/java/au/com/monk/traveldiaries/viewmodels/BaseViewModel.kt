package au.com.monk.traveldiaries.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import au.com.monk.traveldiaries.data.generic.ErrorResponse

open class BaseViewModel : ViewModel() {
    private val _loading = MutableLiveData<Boolean>(false)
    val loading : LiveData<Boolean> = _loading

    private val _error = MutableLiveData<ErrorResponse>()
    val error : LiveData<ErrorResponse> = _error

    fun setError(error: ErrorResponse){
        _error.value = error
        setLoading((false))
    }

    fun setLoading(boolean: Boolean){
        _loading.value = false
    }
}
