import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.monk.traveldiaries.R
import au.com.monk.traveldiaries.types.CarouselContentType
import au.com.monk.traveldiaries.ui.components.Carousel
import au.com.monk.traveldiaries.ui.components.TextLabel
import au.com.monk.traveldiaries.ui.components.TextStyle
import au.com.monk.traveldiaries.ui.screens.tabs.ExperienceTab
import au.com.monk.traveldiaries.ui.screens.tabs.ExploreTab
import au.com.monk.traveldiaries.ui.screens.tabs.MyJourneyTab
import io.github.serpro69.kfaker.faker
import kotlin.random.Random

@Composable
fun TabNavigator() {
    val faker = faker { }
    val tabs = listOf<String>("Explore", "Experience", "My Journey")
    var selectedTabIndex: Int by remember { mutableIntStateOf(0) }
    val carouselContents = listOf<CarouselContentType>(
        CarouselContentType(
            "A",
            "https://picsum.photos/600",
            title = faker.mountain.name(),
            subTitle = faker.address.fullAddress(),
            rating = Random.nextFloat() * 10
        ),
        CarouselContentType(
            "B",
            "https://picsum.photos/700",
            title = faker.aquaTeenHungerForce.character(),
            subTitle = faker.address.fullAddress(),
            rating = Random.nextFloat() * 10
        ),
        CarouselContentType(
            "C",
            "https://picsum.photos/800",
            title = faker.siliconValley.characters(),
            subTitle = faker.address.fullAddress(),
            rating = Random.nextFloat() * 10
        ),
        CarouselContentType(
            "D",
            "https://picsum.photos/900",
            title = faker.halfLife.character(),
            subTitle = faker.address.fullAddress(),
            rating = Random.nextFloat() * 10
        )
    )


    var isCarouselVisible by remember {
        mutableStateOf(true)
    }

    Column {
        TextLabel(
            title = "Travel Diaries",
            style = TextStyle.H1,
            modifier = Modifier.padding(16.dp)
        )

        AnimatedVisibility(visible = isCarouselVisible) {
            Column {
                TextLabel(title = "Sponsored", style = TextStyle.Regular, modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp))
                Carousel(
                    modifier = Modifier.fillMaxWidth(),
                    carouselContents = carouselContents
                )
            }
        }


        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier,
            backgroundColor = MaterialTheme.colorScheme.background
        ) {
            tabs.forEachIndexed { index, s ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = {
                        selectedTabIndex = index
                        isCarouselVisible = true
                    },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = tabs[index])
                }
            }

        }
        Column(modifier = Modifier.weight(1F)) {
            when (selectedTabIndex) {
                0 -> {
                    // Content for Tab 1
                    ExploreTab {
                        isCarouselVisible = it
                    }
                }

                1 -> {
                    // Content for Tab 2
                    isCarouselVisible = false
                    ExperienceTab()
                }

                2 -> {
                    isCarouselVisible = false
                    MyJourneyTab()
                }
            }

        }
    }


}

@Preview
@Composable
fun previewTabNavigator() {
    TabNavigator()
}