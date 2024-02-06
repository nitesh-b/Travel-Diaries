package au.com.monk.traveldiaries.ui.screens.tabs

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import au.com.monk.traveldiaries.data.ExploreItem
import au.com.monk.traveldiaries.ui.components.ExploreItem

@Composable
fun ExploreTab() {

    val datas = (1..30).map { index ->
        ExploreItem(userImageThumbnail = "https://picsum.photos/200",
            userName = "faker.name().fullName()",
            userHandle = "faker.internet().username()",
            datePostedTS = 1234234234,
            contentImage = "https://picsum.photos/600/800",
            location = "faker.country().capital()" + " " + "faker.country().name()"

            )
    }
    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn{
            items(datas) { item ->
                ExploreItem(exploreItem = item)

            }
    }


    }
}