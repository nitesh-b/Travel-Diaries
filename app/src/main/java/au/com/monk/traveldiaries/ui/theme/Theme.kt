package au.com.monk.traveldiaries.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = primary_D,
    secondary = secondary_D,
    tertiary = tertiary_D,
    background = background_D,
    surface = surface_D,
    onPrimary = onPrimary_D,
    onSecondary = onSecondary_D,
    onTertiary = onTertiary_D,
    onBackground = onBackground_D,
    onSurface = onSurface_D,
)

private val LightColorScheme = lightColorScheme(
    primary = primary_L,
    secondary = secondary_L,
    tertiary = tertiary_L,
    background = background_L,
    surface = surface_L,
    onPrimary = onPrimary_L,
    onSecondary = onSecondary_L,
    onTertiary = onTertiary_L,
    onBackground = onBackground_L,
    onSurface = onSurface_L

)

@Composable
fun TravelDiariesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}