package au.com.monk.traveldiaries.ui.components

import android.content.Context
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.OptIn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView

@OptIn(UnstableApi::class)
@Composable
fun VideoPlayer(uri: String,  autoPlay: Boolean) {

    val context: Context = LocalContext.current
    val exoPlayer = remember {
        ExoPlayer.Builder(context)
            .build()
            .apply {
                val defaultDataSourceFactory = DefaultDataSource.Factory(context)
                val dataSourceFactory: DataSource.Factory =
                    DefaultDataSource.Factory(context, defaultDataSourceFactory)
                val source = ProgressiveMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(MediaItem.fromUri(uri))
                setMediaSource(source)
                prepare()
            }
    }

    exoPlayer.playWhenReady = autoPlay
    exoPlayer.videoScalingMode = C.VIDEO_SCALING_MODE_DEFAULT
    exoPlayer.repeatMode = Player.REPEAT_MODE_ONE

    DisposableEffect(
        AndroidView(
            factory = {
                PlayerView(context).apply {
                    showController()
                    useController = false
                    resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIXED_WIDTH
                    player = exoPlayer
                    layoutParams = FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    ) {
        onDispose { exoPlayer.release() }
    }

}