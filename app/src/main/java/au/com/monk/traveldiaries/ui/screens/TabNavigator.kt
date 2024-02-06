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

import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.monk.traveldiaries.R
import au.com.monk.traveldiaries.ui.screens.tabs.ExploreTab

@Composable
fun TabNavigator() {

    val tabs = listOf<String>("Explore", "Experience", "My Journey")
    var selectedTabIndex: Int by remember { mutableIntStateOf(0) }

    Column {
        Box(modifier = Modifier.fillMaxWidth()
            .background(Color.Red)) {
        Image(
            painter = painterResource(id = R.drawable.background_email_verify),
            contentDescription = "Image of mountain",
            modifier = Modifier.fillMaxWidth().height(200.dp),
            contentScale = ContentScale.FillWidth

        )

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
                    ExploreTab()
                }
                1 -> {
                    // Content for Tab 2
                    Text(text = "Tab 2 Content")
                }
                2 -> {
                    // Content for Tab 3
                    Text(text = "Tab 3 Content")
                }
            }

        }
    }




}

@Preview
@Composable
fun previewTabNavigator(){
    TabNavigator()
}