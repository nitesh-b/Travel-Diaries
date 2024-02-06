package au.com.monk.traveldiaries.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.monk.traveldiaries.R
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun LoadingView(modifier: Modifier = Modifier) {
    val lottieAnimationComposable by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.sand_clock))

    val loadingProgress by animateLottieCompositionAsState(
        composition = lottieAnimationComposable,
        iterations = LottieConstants.IterateForever,
        isPlaying = true
    )
    Box(modifier = Modifier.fillMaxSize(),
        ) {
        LottieAnimation(
            composition = lottieAnimationComposable,
            progress = loadingProgress,
            modifier = modifier
                .width(100.dp)
                .height(100.dp)
                .align(Alignment.Center)

        )
    }
}

@Preview
@Composable
fun PreviewLoadingView() {
    LoadingView()
}