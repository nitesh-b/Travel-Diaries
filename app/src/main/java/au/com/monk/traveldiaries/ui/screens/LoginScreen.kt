package au.com.monk.traveldiaries.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.com.monk.traveldiaries.R
import au.com.monk.traveldiaries.ui.components.InputTextField
import au.com.monk.traveldiaries.ui.components.RegularButton
import au.com.monk.traveldiaries.ui.theme.TravelDiariesTheme

@Composable
fun LoginScreenView(modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Harbour Bridge",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillHeight
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                InputTextField(
                    inputValue = username,
                    onValueChanged = {
                        username = it
                    },
                    label = "Username"
                )
                InputTextField(
                    inputValue = password,
                    onValueChanged = {
                        password = it
                    },
                    label = "Password"
                )

                RegularButton(
                    title = "Sign In",
                    onClick = {

                    }
                )

            }

        }

    }


}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    TravelDiariesTheme {
        LoginScreenView()
    }
}