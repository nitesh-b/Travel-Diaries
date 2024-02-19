package au.com.monk.traveldiaries.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import au.com.monk.traveldiaries.ui.theme.secondary_D
import au.com.monk.traveldiaries.ui.theme.secondary_L

@Composable
fun Rating(rating: Float, modifier: Modifier = Modifier, size: Dp = 24.dp) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        (1..5).forEach { index ->
            val starIcon = Icons.Filled.Star
            Image(
                imageVector = starIcon,
                contentDescription = null,
                modifier = Modifier.size(size),
                colorFilter = ColorFilter.tint( color = if (index <= rating) secondary_D else secondary_L)
            )
        }
    }
}

@Preview
@Composable
fun PreviewRatingView() {
    Rating(rating = 3f, modifier = Modifier.padding(16.dp))
}
