package au.com.monk.traveldiaries.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import au.com.monk.traveldiaries.data.experienceitem.ExperienceItem
import au.com.monk.traveldiaries.data.generic.ErrorResponse
import au.com.monk.traveldiaries.data.generic.ViewState
import au.com.monk.traveldiaries.repositories.ExperienceRepository
import au.com.monk.traveldiaries.repositories.ExperienceRepositoryImpl
import kotlinx.coroutines.launch

class ExperienceViewModel: BaseViewModel() {

    private val repository : ExperienceRepository = ExperienceRepositoryImpl()
    private var _item  = MutableLiveData<ViewState<ExperienceItem>>()
    val item : LiveData<ViewState<ExperienceItem>> get() = _item
    private var nextPage = MutableLiveData<String>()

    suspend fun getVideos(){
        _item.value = ViewState.Loading
        viewModelScope.launch {
            try {
                val response = repository.getItems(nextPage.value, 10)
                response.result?.let {
                    _item.value = ViewState.Success(it)
                }
            }catch (error: ErrorResponse){
                _item.value = ViewState.Failure(error)
            }
        }
    }


}