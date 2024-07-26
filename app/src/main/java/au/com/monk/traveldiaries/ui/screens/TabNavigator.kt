import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
import au.com.monk.traveldiaries.ui.theme.black20
import au.com.monk.traveldiaries.ui.theme.black40
import au.com.monk.traveldiaries.ui.theme.onPrimary_D
import au.com.monk.traveldiaries.ui.theme.primary_D
import au.com.monk.traveldiaries.ui.theme.primary_L
import au.com.monk.traveldiaries.ui.theme.transparent
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

            AnimatedVisibility(visible = isCarouselVisible) {
                Box(modifier = Modifier.fillMaxWidth()){
                Column {
                   Carousel(
                        modifier = Modifier.fillMaxWidth(),
                        carouselContents = carouselContents
                    )
                }
            }
            Row(Modifier.background(Brush.verticalGradient(listOf(primary_D,black40, transparent ))).padding(top = 60.dp)) {
                TextLabel(
                    title = "Travel Diaries",
                    style = TextStyle.H1,
                    modifier = Modifier.padding(16.dp),
                    color = onPrimary_D
                )
                Spacer(modifier = Modifier.weight(1F))
                Image(painter = painterResource(id = R.drawable.add_item),
                    contentDescription = "add item",
                    modifier = Modifier
                        .padding(16.dp)
                        .size(24.dp)
                        .clickable(enabled = true) {
                            addContent()

                        })

            }
        }




        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.padding(top= 40.dp),
            containerColor = MaterialTheme.colorScheme.background
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
                    TextLabel(title = tabs[index], style = TextStyle.RegularBold)
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

fun addContent() {
    val TAG = "TabNavigator"
    Log.d(TAG, "addContent: Show camera")
}



@Preview
@Composable
fun previewTabNavigator() {
    TabNavigator()
}