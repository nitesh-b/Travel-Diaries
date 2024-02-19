package au.com.monk.traveldiaries.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.monk.traveldiaries.ui.components.ButtonType
import au.com.monk.traveldiaries.ui.components.InputTextField
import au.com.monk.traveldiaries.ui.components.RegularButton
import au.com.monk.traveldiaries.ui.components.TextLabel
import au.com.monk.traveldiaries.ui.components.TextStyle
import au.com.monk.traveldiaries.ui.theme.TravelDiariesTheme
import au.com.monk.traveldiaries.ui.theme.onPrimary_D
import au.com.monk.traveldiaries.ui.theme.primary_D
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun EmailVerificationScreen() {
    TravelDiariesTheme {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(primary_D)

        )
        {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxHeight(0.5F)
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                TextLabel(
                    title = "Verify your email",
                    style = TextStyle.Regular,
                    color = onPrimary_D
                )
                InputTextField(
                    modifier = Modifier.width(200.dp).wrapContentHeight(),
                    inputValue = "",
                    onValueChanged = {},
                    label = "Code",
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                RegularButton(type = ButtonType.Secondary, title = "Verify email") {

                }


            }

        }
    }

}

@Preview
@Composable
fun PreviewEmailVerificationScreen() {
    EmailVerificationScreen()
}