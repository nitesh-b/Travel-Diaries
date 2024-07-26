@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class)

package au.com.monk.traveldiaries.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import au.com.monk.traveldiaries.types.CarouselContentType
import coil.compose.AsyncImage
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Carousel(modifier: Modifier = Modifier, carouselContents: List<CarouselContentType>) {
    val pagerState = rememberPagerState(pageCount = { carouselContents.size }, initialPage = 1)
    Box(modifier = modifier
        .fillMaxWidth()
        .wrapContentHeight()) {
        HorizontalPager(
            state = pagerState,
            verticalAlignment = Alignment.CenterVertically,
            key = { index -> index },
        ) { page ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 0.dp)
                    .graphicsLayer {
                        val pageOffset = (
                                (pagerState.currentPage - page) + pagerState
                                    .currentPageOffsetFraction
                                ).absoluteValue

                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
            ) {
                AsyncImage(
                    model = carouselContents[page].uri,
                    contentDescription = "Image of mountain",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
Column(modifier = Modifier.padding(12.dp)) {
    TextLabel(title = carouselContents[page].title, style = TextStyle.Small)
    TextLabel(title = carouselContents[page].subTitle, style = TextStyle.Regular)
    Rating(rating = carouselContents[page].rating, size = 16.dp)
}

            }
        }

        Row(
            Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp)
                .clip(RoundedCornerShape(6.dp)),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) {
                val color =
                    if (pagerState.currentPage == it) Color.White else MaterialTheme.colorScheme.tertiary
                Box(
                    modifier = Modifier
                        .background(color)
                        .size(6.dp)
                )
            }
        }
    }
}



@Preview
@Composable
fun PreviewCarousel() {
    val carouselContents = listOf<CarouselContentType>(
        CarouselContentType("A", "https://picsum.photos/200", "A", "B", 0.3F),
        CarouselContentType("B", "https://picsum.photos/200", "A", "B", 2F),
        CarouselContentType("C", "https://picsum.photos/200", "A", "B", 2F),
        CarouselContentType("D", "https://picsum.photos/200", "A", "B", 2F)
    )
    Carousel(carouselContents = carouselContents)

}