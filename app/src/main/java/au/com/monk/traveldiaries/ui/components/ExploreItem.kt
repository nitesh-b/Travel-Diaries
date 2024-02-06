package au.com.monk.traveldiaries.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.monk.traveldiaries.R
import au.com.monk.traveldiaries.data.ExploreItem
import coil.compose.AsyncImage

@Composable
fun ExploreItem(exploreItem: ExploreItem) {
    Column(
        modifier = Modifier
            .border(
                1.dp,
                MaterialTheme.colorScheme.primary,
                RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp)
            )
            .padding(8.dp)) {
        Row {
            AsyncImage(
                model = exploreItem.userImageThumbnail,
                contentDescription = "Profile image",
                modifier = Modifier
                    .size(50.dp)
                    .border(1.dp, Color.Red, RoundedCornerShape(100))
            )
            Column(
                modifier = Modifier
                    .padding(8.dp)

            ) {
                TextLabel(title = exploreItem.userName, style = TextStyle.Regular)
                TextLabel(title = exploreItem.userHandle, style = TextStyle.Small)

            }
            Spacer(Modifier.weight(1F))
            CircularProgressBarWithImage(0.5F)
            Spacer(Modifier.width(4.dp))
            TextLabel(title = exploreItem.datePostedTS.toString(), style = TextStyle.Small)

        }
        AsyncImage(model = exploreItem.contentImage,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.FillWidth

            )
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Icon(imageVector = Icons.Default.LocationOn, contentDescription = null)
            TextLabel(title = exploreItem.location, style = TextStyle.Medium)
            Spacer(modifier = Modifier.weight(1F))
            Icon(painter = painterResource(id = R.drawable.icon_fist_bump_open),
                contentDescription = null,
                modifier = Modifier.width(24.dp).height(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(painter = painterResource(id = R.drawable.icon_bucket),
                contentDescription = null,
                modifier = Modifier.width(24.dp).height(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(imageVector = Icons.Default.Email,
                contentDescription = null,
                modifier = Modifier.width(24.dp).height(24.dp)
            )

        }
    }

}

@Preview
@Composable
fun PreviewExploreItem() {
    ExploreItem(au.com.monk.traveldiaries.data.ExploreItem("https://picsum.photos/200",

        userName = "Rahat Ali",
        userHandle = "@Rahat554",
        datePostedTS = 4564958,
        contentImage = "https://picsum.photos/600",
        location = "Tokyo Japan"
        ))
}