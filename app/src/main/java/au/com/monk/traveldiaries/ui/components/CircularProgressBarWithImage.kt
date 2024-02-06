package au.com.monk.traveldiaries.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.monk.traveldiaries.R

@Composable
fun CircularProgressBarWithImage(progressValue: Float){
    var progValue by remember{
        mutableStateOf(progressValue)
    }

    Box(modifier = Modifier.wrapContentSize(),
        contentAlignment = Alignment.Center){
        Image(painter = painterResource(id = R.drawable.icon_earth),
            contentDescription = null,
            modifier = Modifier.width(20.dp)
                .height(20.dp)
                .align(Alignment.Center)

            )

        CircularProgressIndicator(
            modifier = Modifier.width(28.dp)
                .height(28.dp),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.tertiary,
            strokeCap = StrokeCap.Round,
            strokeWidth = 4.dp
        )
    }


}

@Preview
@Composable
fun PreviewCircularProgressBarWithImage() {
    CircularProgressBarWithImage(progressValue = 0.5F)
}

