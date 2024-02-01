package au.com.monk.traveldiaries.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import au.com.monk.traveldiaries.ui.components.TextStyle.*
import au.com.monk.traveldiaries.ui.theme.Typography


enum class TextStyle{
    H1, H2, H3, H4, Regular, Small, Medium, Large
}
@Composable
fun TextLabel(modifier: Modifier = Modifier,
              title: String,
              style: TextStyle
              ){
    val textStyle: androidx.compose.ui.text.TextStyle
    when(style){
        H1 -> {
           textStyle =  MaterialTheme.typography.h1
        }
        H2 -> {
            textStyle = MaterialTheme.typography.h2
        }
        H3 -> {
            textStyle = MaterialTheme.typography.h3
        }
        H4 -> {
            textStyle = MaterialTheme.typography.h4
        }
        Regular -> {
            textStyle = Typography.bodyMedium
        }
        Small -> {
            textStyle = Typography.bodySmall
        }
        Medium -> {
            textStyle = Typography.bodyMedium
        }
        Large -> {
            textStyle = Typography.bodyLarge
        }
    }

    Text(text = title, style = textStyle)
}