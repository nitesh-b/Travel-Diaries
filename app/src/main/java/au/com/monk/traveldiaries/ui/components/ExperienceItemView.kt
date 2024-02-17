package au.com.monk.traveldiaries.ui.components

import androidx.annotation.OptIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.media3.common.util.UnstableApi
import au.com.monk.traveldiaries.data.TestData
import au.com.monk.traveldiaries.data.experienceitem.Video
import au.com.monk.traveldiaries.ui.theme.Typography
import au.com.monk.traveldiaries.ui.theme.black40
import au.com.monk.traveldiaries.ui.theme.black80
import au.com.monk.traveldiaries.ui.theme.primary_L
import au.com.monk.traveldiaries.ui.theme.primary_L_40

@OptIn(UnstableApi::class)
@Composable
fun ExperienceItemView(item: Video, autoPlay: Boolean) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VideoPlayer(uri = item.source, autoPlay = autoPlay)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Column(modifier = Modifier.weight(1F),
                    verticalArrangement = Arrangement.Bottom) {
                    TextLabel(title = item.title, style = TextStyle.H6, color = Color.White)
                    TextLabel(title = item.description!!, style = TextStyle.Small, color = Color.White)
                    TextLabel(title = item.subTitle!!, style = TextStyle.Regular, color = Color.White)

                }

                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(8.dp)
                        .background(primary_L_40, RoundedCornerShape(16.dp))
                        .padding(8.dp)

                ) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favourite"
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Icon(imageVector = Icons.Default.Send, contentDescription = "Favourite")
                    Spacer(modifier = Modifier.height(20.dp))
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Favourite")

                }
            }

            InputTextField(
                inputValue = "Helo",
                onValueChanged = {},
                textColor = Color.White,
                backgroundColor = black80
            )

        }
    }

}

@Preview
@Composable
fun PreviewExperienceView() {
    val video = TestData().getFakeVideo()
    ExperienceItemView(item = video, true)
}