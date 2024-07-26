package au.com.monk.traveldiaries.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import au.com.monk.traveldiaries.data.generic.ErrorResponse
import au.com.monk.traveldiaries.data.generic.ViewState
import au.com.monk.traveldiaries.data.exploreitem.ExploreItem
import au.com.monk.traveldiaries.data.generic.ResponseBody
import au.com.monk.traveldiaries.repositories.ExploreRepository
import au.com.monk.traveldiaries.repositories.ExploreRepositoryImpl
import kotlinx.coroutines.launch

class ExploreViewModel : BaseViewModel() {
    private val repository: ExploreRepository

    private val _items = MutableLiveData<ViewState<List<ExploreItem>>>()
    val items: LiveData<ViewState<List<ExploreItem>>> get() = _items


        init {
            repository = ExploreRepositoryImpl()
        }

    fun getAllItems(pageNo: Int, pageSize: Int = 20) {
        _items.value = ViewState.Loading
        viewModelScope.launch {
            try {
                val response = repository.getExploreItems(pageNo, pageSize)
                response.result?.let {
                    _items.value = ViewState.Success(it)
                }

            } catch (error: ErrorResponse) {
                _items.value = ViewState.Failure(error)
            }
        }
    }

    fun updatePackSuitCase(itemID: String, value: Boolean) {

        viewModelScope.launch {
            try {
                val response: ResponseBody<Boolean> = repository.addToBucketList(itemID, value)
                response.result?.let { res ->
                    val updatedList =
                        (_items.value as? ViewState.Success<List<ExploreItem>>)?.data?.map {
                            if (itemID == it.id) {
                                it.copy(packSuitcase = res)
                            } else {
                                it
                            }
                        }
                    _items.value = ViewState.Success(updatedList!!)
                }
            } catch (error: ErrorResponse) {
                _items.value = ViewState.Failure(error)
            }
        }
    }

    fun updateWow(itemID: String, value: Boolean) {

        viewModelScope.launch {
            try {
                val response: ResponseBody<Boolean> = repository.updateWow(itemID, value)
                response.result?.let { res ->
                    val updatedList =
                        (_items.value as? ViewState.Success<List<ExploreItem>>)?.data?.map {
                            if (itemID == it.id) {
                                it.copy(hasFistBump = res)
                            } else {
                                it
                            }
                        }
                    _items.value = ViewState.Success(updatedList!!)
                }
            } catch (error: ErrorResponse) {
                _items.value = ViewState.Failure(error)
            }
        }
    }
}