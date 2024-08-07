package au.com.monk.traveldiaries.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import au.com.monk.traveldiaries.R
import au.com.monk.traveldiaries.data.exploreitem.ExploreItem
import au.com.monk.traveldiaries.data.exploreitem.Image
import au.com.monk.traveldiaries.enums.ItemTypeEnum
import au.com.monk.traveldiaries.ui.theme.primary_L_40
import au.com.monk.traveldiaries.utils.date.DateFormatter
import coil.compose.AsyncImage
import java.util.UUID

@Composable
fun ExploreItemView(
    exploreItem: ExploreItem,
    onSuitcaseClicked: (value: Boolean) -> Unit,
    onFistBumpClicked: (value: Boolean) -> Unit,

    ) {
    var sizeImage by remember { mutableStateOf(IntSize.Zero) }
    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, Color.Transparent, Color.Black),
        startY = sizeImage.height.toFloat() / 3,  // 1/3
        endY = sizeImage.height.toFloat()
    )
    Column(
        modifier = Modifier
    ) {
        Row(
            modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            AsyncImage(
                model = exploreItem.userImageThumbnail,
                contentDescription = "Profile image",
                modifier = Modifier
                    .size(40.dp)
                    .border(1.dp, Color.Red, RoundedCornerShape(100))
                    .clip(RoundedCornerShape(100))

            )

            Column(
                modifier = Modifier.padding(8.dp)

            ) {
                TextLabel(title = exploreItem.userName, style = TextStyle.RegularBold)
                TextLabel(title = exploreItem.userHandle, style = TextStyle.Small)

            }
            Spacer(Modifier.weight(1F))
            CircularProgressBarWithImage(0.5F)
            Spacer(Modifier.width(4.dp))
            TextLabel(
                title = DateFormatter.timeAgo(exploreItem.dateUploadedTS), style = TextStyle.Small
            )

        }

        Box(modifier = Modifier) {

            AsyncImage(
                model = exploreItem.content[0].thumbnail,
                contentDescription = null,
                modifier = Modifier
                    .onGloballyPositioned {
                        sizeImage = it.size
                    }
                    .height(400.dp)
                    .fillMaxWidth()
                    .padding(12.dp)
                    .clip(RoundedCornerShape(8.dp)) // Apply RoundedCornerShape here
                    .clipToBounds(),
                contentScale = ContentScale.Crop,
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .padding(12.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .clipToBounds()
                    .background(gradient)
            )



            Image(painter = painterResource(id = if (exploreItem.packSuitcase) R.drawable.icon_suitcase else R.drawable.icon_suitcase_unfilled),
                contentDescription = null,
                modifier = Modifier
                    .width(72.dp)
                    .height(72.dp)
                    .padding(16.dp)
                    .align(Alignment.TopEnd)
                    .clickable(enabled = true, onClick = {
                        onSuitcaseClicked(exploreItem.packSuitcase)
                    })
                    .background(primary_L_40, RoundedCornerShape(100))
                    .padding(8.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 16.dp)
                    .align(Alignment.BottomCenter)
            ) {
                exploreItem.title?.let {
                    TextLabel(
                        title = it, style = TextStyle.H6, color = Color.White
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp),
                    )

                    TextLabel(
                        title = exploreItem.location, style = TextStyle.Small, color = Color.White
                    )
                    Spacer(modifier = Modifier.weight(1F))
                    Image(painter = painterResource(id = R.drawable.wow),
                        contentDescription = null,
                        modifier = Modifier
                            .width(32.dp)
                            .height(32.dp)
                            .alpha(if (exploreItem.hasFistBump)  1F else 0.4F)
                            .clickable(enabled = true, onClick = {
                                onFistBumpClicked(exploreItem.hasFistBump)
                            }))

                }
            }
        }
        Divider(
            Modifier
                .fillMaxWidth()
                .padding(2.dp, 4.dp, 2.dp, 4.dp), thickness = 0.5.dp
        )
    }

}

@Preview
@Composable
fun PreviewExploreItem() {
    ExploreItemView(ExploreItem(
        id = UUID.randomUUID().toString(),
        "https://picsum.photos/200",
        userName = "Rahat Ali",
        userHandle = "@Rahat554",
        dateUploadedTS = 4564958,
        content = listOf<Image>(
            Image(
                "https://picsum.photos/600",
                ItemTypeEnum.Image,
                UUID.randomUUID().toString(),
                false
            )
        ),
        location = "Tokyo Japan",
        title = "Walking around",
        hasFistBump = false,
        packSuitcase = false
    ), { }, { })
}