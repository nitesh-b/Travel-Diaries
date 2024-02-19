package au.com.monk.traveldiaries.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import au.com.monk.traveldiaries.ui.components.TextStyle.H1
import au.com.monk.traveldiaries.ui.components.TextStyle.H2
import au.com.monk.traveldiaries.ui.components.TextStyle.H3
import au.com.monk.traveldiaries.ui.components.TextStyle.H4
import au.com.monk.traveldiaries.ui.components.TextStyle.H5
import au.com.monk.traveldiaries.ui.components.TextStyle.H6
import au.com.monk.traveldiaries.ui.components.TextStyle.Large
import au.com.monk.traveldiaries.ui.components.TextStyle.Regular
import au.com.monk.traveldiaries.ui.components.TextStyle.Small
import au.com.monk.traveldiaries.ui.theme.Typography


enum class TextStyle{
     H1, H2, H3, H4, H5, H6, Regular, Small, Large
}
@Composable
fun TextLabel(modifier: Modifier = Modifier,
              title: String,
              style: TextStyle = Regular,
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