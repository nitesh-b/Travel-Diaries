package au.com.monk.traveldiaries.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.monk.traveldiaries.R
import au.com.monk.traveldiaries.ui.components.ButtonType
import au.com.monk.traveldiaries.ui.components.InputTextField
import au.com.monk.traveldiaries.ui.components.RegularButton
import au.com.monk.traveldiaries.ui.theme.TravelDiariesTheme
import au.com.monk.traveldiaries.ui.theme.black60

@Composable
fun CustomSingUpScreen() {
    TravelDiariesTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier.fillMaxHeight(),
                painter = painterResource(id = R.drawable.background_signup_screen),
                contentDescription = "Sign up Screen",
                contentScale = ContentScale.FillHeight,
                colorFilter = ColorFilter.tint(black60, BlendMode.SrcOver)

            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.4F)
            ) {
                Text(
                    text = "Capture your JOURNEY,\nShare your STORY!",
                    style = MaterialTheme.typography.displayLarge,
                    color = Color.White

                )

            }
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize(0.6F)
            ) {

                InputTextField(inputValue = "", onValueChanged = {}, label = "Full name")
                InputTextField(inputValue = "", onValueChanged = {}, label = "@Username")
                InputTextField(inputValue = "", onValueChanged = {}, label = "Your Email")
                InputTextField(inputValue = "", onValueChanged = {}, label = "Password")
                Spacer(modifier = Modifier.height(12.dp))
                RegularButton(
                    type = ButtonType.Primary,
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally) ,
                    title = "Create Profile",
                    onClick = { /*TODO*/ })
            }
        }


    }


}

@Preview
@Composable
fun PreviewCustomSingUpScreen() {
    CustomSingUpScreen()
}