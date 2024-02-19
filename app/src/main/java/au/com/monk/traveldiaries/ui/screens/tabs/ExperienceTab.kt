package au.com.monk.traveldiaries.ui.screens.tabs

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import au.com.monk.traveldiaries.data.experienceitem.Video
import au.com.monk.traveldiaries.data.generic.ViewState
import au.com.monk.traveldiaries.ui.components.ExperienceItemView
import au.com.monk.traveldiaries.ui.components.LoadingView
import au.com.monk.traveldiaries.viewmodels.ExperienceViewModel

@OptIn(ExperimentalFoundationApi::class)

@Composable
fun ExperienceTab() {
    val viewModel = viewModel<ExperienceViewModel>()
    var items by remember {
        mutableStateOf<List<Video>>(listOf())
    }
    var isLoading by remember {
        mutableStateOf<Boolean>(false)
    }
    val viewState = viewModel.item.observeAsState().value

    LaunchedEffect(key1 = Unit, block = {
        viewModel.getVideos()
    })

    LaunchedEffect(key1 = viewState, block = {
        when (viewState) {
            is ViewState.Failure -> {
                isLoading = false
            }

            ViewState.Loading -> {
                isLoading = true
            }

            is ViewState.Success -> {
                isLoading = false
                items = items + viewState.data.video
            }

            null -> {
                // Handle null state if needed
            }
        }
    })

    Surface(modifier = Modifier.fillMaxSize()) {
        val lazyListState = rememberLazyListState()

        Box(
            modifier = Modifier.fillMaxSize(0.9F)
        ) {
            LazyColumn(
                state = lazyListState,
                modifier = Modifier.fillMaxSize(),
                content = {
                    itemsIndexed(items) { index, item ->
                        val autoPlay = index == lazyListState.firstVisibleItemIndex
                        Box(
                            modifier = Modifier.fillParentMaxSize()
                        ) {
                            ExperienceItemView(item, autoPlay = autoPlay)
                        }
                    }
                }
            )
        }

        if (isLoading) LoadingView()
    }
}



@Preview
@Composable
fun PreviewExperienceTab() {
    ExperienceTab()

}