package au.com.monk.traveldiaries.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.monk.traveldiaries.R
import au.com.monk.traveldiaries.ui.theme.black80
import au.com.monk.traveldiaries.ui.theme.primary_L


enum class ButtonType {
    Primary,
    Secondary,
    Plain,
    Custom
}


@Composable
fun RegularButton(
    type: ButtonType,
    modifier: Modifier = Modifier,
    title: String,
    foreground: Color = black80,
    background: Color = primary_L,
    image: Int? = null,
    onClick: () -> Unit,
) {

    val primaryButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
    )

    val secondaryButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = MaterialTheme.colorScheme.secondary,
        contentColor = MaterialTheme.colorScheme.onSecondary,
    )

    val plainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = MaterialTheme.colorScheme.secondary,
        contentColor = MaterialTheme.colorScheme.onSecondary,
    )


    val custom = ButtonDefaults.buttonColors(
        backgroundColor = background,
        contentColor = foreground,
    )
    Button(
        modifier = modifier,
        onClick = {
            onClick()
        },
        colors =
            if (type == ButtonType.Primary) {
                primaryButtonColor
            } else if (type == ButtonType.Secondary) {
                secondaryButtonColor
            } else if (type == ButtonType.Custom) {
                custom
            } else {
            plainButtonColor
            }

        ,
        shape = RoundedCornerShape(8.dp)
    ) {
        if (image != null) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
        Text(text = title)
    }
}


@Preview
@Composable
fun PreviewButton() {
    RegularButton(
        type = ButtonType.Primary,
        title = "Primary",
        image = R.drawable.background
    ) {
    }
}