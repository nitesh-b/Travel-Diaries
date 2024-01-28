package au.com.monk.traveldiaries.ui.components

import android.graphics.drawable.Drawable
import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults

import androidx.compose.material.Text
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.monk.traveldiaries.R


enum class ButtonType {
    Primary,
    Secondary,
    Plain
}


@Composable
fun RegularButton(
    type: ButtonType,
    modifier: Modifier = Modifier,
    title: String,
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