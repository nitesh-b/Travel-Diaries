package au.com.monk.traveldiaries.ui.screens.tabs

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import au.com.monk.traveldiaries.data.ExploreItem
import au.com.monk.traveldiaries.ui.components.ExploreItem
import com.google.android.play.integrity.internal.i
import io.github.serpro69.kfaker.faker

@Composable
fun ExploreTab(onScrollUp: (value: Boolean) -> Unit) {
    val faker = faker {}
    val datas = (1..30).map { index ->
        ExploreItem(
            userImageThumbnail = String.format("https://picsum.photos/%d/%d", 100, 100),
            userName = faker.name.firstName() + " " + faker.name.lastName(),
            userHandle = faker.funnyName.name(),
            datePostedTS = 1234234234,
            contentImage = String.format("https://picsum.photos/%d/%d", 800 + index, 800 - index),
            location = faker.address.unique.city() + " " + faker.address.country(),
            title = faker.quote.famousLastWords()

        )
    }
    Surface(modifier = Modifier.fillMaxSize()) {
        val scrollState = rememberLazyListState()
        LazyColumn(state = scrollState) {
            items(datas) { item ->
                ExploreItem(exploreItem = item)
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


    }
}