package au.com.monk.traveldiaries.viewmodels

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import au.com.monk.traveldiaries.data.ErrorResponse
import au.com.monk.traveldiaries.data.ViewState
import au.com.monk.traveldiaries.data.exploreitem.ExploreItem
import au.com.monk.traveldiaries.repositories.ExploreRepository
import au.com.monk.traveldiaries.repositories.ExploreRepositoryImpl
import com.google.android.gms.common.api.Response
import faker.com.fasterxml.jackson.databind.json.JsonMapper
import kotlinx.coroutines.launch

class ExploreViewModel : BaseViewModel() {
    private val repository: ExploreRepository

    private val _items = MutableLiveData<ViewState<List<ExploreItem>>>()
    val items :LiveData<ViewState<List<ExploreItem>>> get() = _items

    init {
        repository = ExploreRepositoryImpl()
    }

    fun getAllItems(pageNo: Int, pageSize:Int = 20){
        _items.value = ViewState.Loading
        viewModelScope.launch {
            try {
                val response = repository.getExploreItems(pageNo, pageSize)
                response.result?.let {
                    Log.d(TAG, "getAllItems: " + it.toString())
                    _items.value = ViewState.Success(it)
                }

            }catch (error: ErrorResponse){
                _items.value = ViewState.Failure(error)
            }


        }
    }
}