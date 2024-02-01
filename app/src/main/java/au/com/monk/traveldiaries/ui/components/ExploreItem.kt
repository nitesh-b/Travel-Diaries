package au.com.monk.traveldiaries.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ExploreItem() {
    Column {
        Row {
            AsyncImage(
                model = "https://picsum.photos/200",
                contentDescription = "Profile image",
                modifier = Modifier
                    .size(50.dp)
                    .border(1.dp, Color.Red, RoundedCornerShape(100))
            )
            Column(modifier = Modifier.padding(8.dp)) {
                TextLabel(title = "First name", style = TextStyle.Regular)
                TextLabel(title = "@Handke", style = TextStyle.Small)
            }
            }
        }

    }

@Preview
@Composable
fun PreviewExploreItem() {
    ExploreItem()
}