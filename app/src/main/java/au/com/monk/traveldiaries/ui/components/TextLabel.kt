package au.com.monk.traveldiaries.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import au.com.monk.traveldiaries.ui.components.TextStyle.*
import au.com.monk.traveldiaries.ui.theme.Typography


enum class TextStyle{
     H1, H2, H3, H4, H5, H6, Regular, Small, Large
}
@Composable
fun TextLabel(modifier: Modifier = Modifier,
              title: String,
              style: TextStyle,
              color: Color? = Color.Black,
              maxLines: Int = 1
              ){
    val textStyle: androidx.compose.ui.text.TextStyle
    when(style){
        H1 -> {
           textStyle =  Typography.titleLarge
        }
        H2 -> {
            textStyle = Typography.titleMedium
        }
        H3 -> {
            textStyle = Typography.titleSmall
        }
        H4 -> {
            textStyle = Typography.headlineLarge
        }
        H5 -> {
            textStyle = Typography.headlineMedium
        }
        H6 -> {
            textStyle = Typography.headlineSmall
        }
        Regular -> {
            textStyle = Typography.bodyMedium
        }
        Small -> {
            textStyle = Typography.bodySmall
        }
        Large -> {
            textStyle = Typography.bodyLarge
        }
    }
        Text(text = title, style = textStyle, color = color!!, modifier = modifier, maxLines = maxLines)

}