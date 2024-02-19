package au.com.monk.traveldiaries.ui.screens.tabs

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import au.com.monk.traveldiaries.data.UserContent
import au.com.monk.traveldiaries.data.generic.ViewState
import au.com.monk.traveldiaries.ui.components.ButtonType
import au.com.monk.traveldiaries.ui.components.LoadingView
import au.com.monk.traveldiaries.ui.components.RegularButton
import au.com.monk.traveldiaries.ui.components.TextLabel
import au.com.monk.traveldiaries.ui.components.TextStyle
import au.com.monk.traveldiaries.ui.theme.background_L
import au.com.monk.traveldiaries.viewmodels.UserAccountViewModel
import coil.compose.AsyncImage
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import io.github.serpro69.kfaker.faker

@Composable
fun MyJourneyTab() {
    val faker = faker { }
    val sydney = LatLng(-33.865143, 151.209900)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(sydney, 0.1f)
    }

    var isMapVisible by remember {
        mutableStateOf(true)
    }

    val scrollState = rememberLazyStaggeredGridState()
    var isLoading by remember {
        mutableStateOf<Boolean>(false)
    }

    val viewModel = viewModel<UserAccountViewModel>()
    var usrContents by remember {
        mutableStateOf<List<UserContent>>(listOf())
    }
    val userContentState = viewModel.userContent.observeAsState().value

    LaunchedEffect(key1 = Unit) {
        viewModel.getUserContent()


    }
    LaunchedEffect(key1 = userContentState) {
        when (userContentState) {
            is ViewState.Failure -> {
                isLoading = false
            }

            ViewState.Loading -> {
                isLoading = true
            }

            is ViewState.Success -> {
                isLoading = false
                usrContents = userContentState.data
            }

            null -> {

            }
        }

    }
    fun onEditProfileClicked() {
        Log.d("MyJourneyTab", "onEditProfileClicked: ")
    }
    Surface(modifier = Modifier.fillMaxHeight()) {
        Column {
           AnimatedVisibility(visible = isMapVisible) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                        .background(MaterialTheme.colorScheme.primary)
                ) {
                    GoogleMap(modifier = Modifier.fillMaxSize(),
                        cameraPositionState = cameraPositionState) {
                        Marker(
                            state = MarkerState(position = sydney),
                            title = "Sydney",
                            snippet = "Opera House Visit"
                        )

                    }
                }
            }


            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(150.dp),
                state = scrollState
            ) {
                item(span = StaggeredGridItemSpan.FullLine) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                AsyncImage(
                                    model = "https://static.wikia.nocookie.net/naruto/images/d/d6/Naruto_Part_I.png",
                                    contentDescription = "naruto",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .width(148.dp)
                                        .height(148.dp)
                                        .clip(RoundedCornerShape(100))
                                        .background(Color.Red)
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                TextLabel(title = "Naruto Uzumaki", style = TextStyle.H3)
                                TextLabel(title = "@nar_uzi006", style = TextStyle.Regular)

                            }

                            Row(
                                modifier = Modifier.weight(1F),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(
                                    space = 8.dp,
                                    alignment = Alignment.CenterHorizontally
                                )
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier
                                        .wrapContentSize()
                                        .border(
                                            1.dp,
                                            MaterialTheme.colorScheme.primary,
                                            RoundedCornerShape(8.dp)
                                        )
                                        .padding(4.dp)
                                ) {
                                    TextLabel(title = "401K", style = TextStyle.H6)
                                    TextLabel(title = "followers", style = TextStyle.Regular)
                                }
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier
                                        .wrapContentSize()
                                        .border(
                                            1.dp,
                                            MaterialTheme.colorScheme.primary,
                                            RoundedCornerShape(8.dp)
                                        )
                                        .padding(4.dp)
                                ) {
                                    TextLabel(title = "31K", style = TextStyle.H6)
                                    TextLabel(title = "following", style = TextStyle.Regular)
                                }
                            }


                        }

                        RegularButton(
                            modifier = Modifier.fillMaxWidth(0.8F),
                            type = ButtonType.Custom,
                            background = background_L,
                            title = "Edit profile"
                        ) {
                            onEditProfileClicked()
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            TextLabel(title = "Photos and videos", style = TextStyle.H5)

                        }
                    }
                }

                items(usrContents) {
                    AsyncImage(
                        model = it.source,
                        contentScale = ContentScale.FillWidth,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()

                            .padding(4.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )
                }
            }
        }

        val density = LocalDensity.current.density
        val scrollThreshold = (1 * density).toInt() // Adjust the threshold as needed
        val scrollPosition =
            remember { derivedStateOf { scrollState.firstVisibleItemScrollOffset } }
        println(scrollThreshold)
        if (scrollPosition.value > scrollThreshold) {
            // Call the provided callback when scrolling up
            isMapVisible = false
        }else if(scrollPosition.value == 0){
            isMapVisible = true
        }
        if (isLoading) LoadingView()
    }

}

