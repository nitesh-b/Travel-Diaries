package au.com.monk.traveldiaries.ui.screens.tabs

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.lifecycle.viewmodel.compose.viewModel
import au.com.monk.traveldiaries.data.generic.ViewState
import au.com.monk.traveldiaries.data.exploreitem.ExploreItem
import au.com.monk.traveldiaries.ui.components.ExploreItemView
import au.com.monk.traveldiaries.ui.components.LoadingView
import au.com.monk.traveldiaries.viewmodels.ExploreViewModel

@Composable
fun ExploreTab(onScrollUp: (value: Boolean) -> Unit) {
    val exploreViewModel = viewModel<ExploreViewModel>()
    var itemList by remember {
        mutableStateOf<List<ExploreItem>>(listOf())
    }
    var isLoading by remember {
        mutableStateOf(false)
    }

    val itemState= exploreViewModel.items.observeAsState().value

    LaunchedEffect(Unit) {
        exploreViewModel.getAllItems(1,20)
    }

    LaunchedEffect(key1 = itemState){
        itemState?.let {
            when (it){
                is ViewState.Failure -> {
                    isLoading = false
                }
                ViewState.Loading -> {
                    isLoading = true
                }
                is ViewState.Success -> {
                    isLoading = false
                    itemList += it.data
                    Log.d("ExploreTab", "ExploreTab: " + itemList[5].content[0].thumbnail)

                }
                null -> {

                }
            }
        }

    }

    Surface(modifier = Modifier.fillMaxSize()) {
        val scrollState = rememberLazyListState()
        LazyColumn(state = scrollState) {
            items(itemList) { item ->
                ExploreItemView(exploreItem = item)
            }
        }
        val density = LocalDensity.current.density
        val scrollThreshold = (90 * density).toInt() // Adjust the threshold as needed
        val scrollPosition =
            remember { derivedStateOf { scrollState.firstVisibleItemScrollOffset } }
        println(scrollThreshold)
        if (scrollPosition.value > scrollThreshold) {
            // Call the provided callback when scrolling up
            onScrollUp (false)
        }else if(scrollPosition.value == 0){
            onScrollUp(true)
        }
        if(isLoading) LoadingView()


    }
}