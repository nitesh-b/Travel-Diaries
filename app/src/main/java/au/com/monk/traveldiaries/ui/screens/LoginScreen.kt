package au.com.monk.traveldiaries.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import au.com.monk.traveldiaries.viewmodels.LoginViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import au.com.monk.traveldiaries.data.ViewState
import au.com.monk.traveldiaries.routes.Route


@Composable
fun LoginScreenView(navController: NavHostController, loginViewModel : LoginViewModel) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val userAccountState by loginViewModel.userAccount.observeAsState()

    fun loginUser(){
        loginViewModel.loginUser(email = username, password = password)
    }
    TravelDiariesTheme {
        Column(modifier = Modifier
            .fillMaxSize()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5F)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.background),
                    contentDescription = "Harbour Bridge",
                    contentScale = ContentScale.FillBounds,
                    colorFilter = ColorFilter.tint(
                        MaterialTheme.colorScheme.primary,
                        BlendMode.Multiply
                    ),
                    modifier = Modifier.fillMaxSize()
                )

                Image(
                    painterResource(id = R.drawable.travel_diaries__1_),
                    null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Fit,
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(16.dp)
                    .weight(0.5F)


            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1F)
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

                    Spacer(modifier = Modifier.height(12.dp))

                    RegularButton(
                        type = ButtonType.Primary,
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(48.dp),
                        title = "Sign In",
                        onClick = {
                                loginUser()
                        }
                    )

                    when(userAccountState){
                        is ViewState.Failure -> {
                            println("Failed")
                        }
                        is ViewState.Loading -> {
                            println("Loading")
                        }
                        is ViewState.Success -> {
                            navController.navigate(route = Route.navigator.route)
                        }
                        null -> {
                            println("Null")
                        }
                    }

                }

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Don't have an account?")
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.safeContentPadding()

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.facebook),
                            contentDescription = null,
                            modifier = Modifier
                                .background(
                                    Color.White, RoundedCornerShape(20.dp)
                                )
                                .height(40.dp)
                                .width(40.dp)
                                .padding(4.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.gmail),
                            contentDescription = null,
                            modifier = Modifier
                                .background(
                                    Color.White, RoundedCornerShape(20.dp)
                                )
                                .height(40.dp)
                                .width(40.dp)
                                .padding(4.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.apple),
                            contentDescription = null,
                            modifier = Modifier
                                .background(
                                    Color.White, RoundedCornerShape(20.dp)
                                )
                                .height(40.dp)
                                .width(40.dp)
                                .padding(4.dp)
                        )
                    }

                }

            }

        }


    }


}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    TravelDiariesTheme {
        LoginScreenView(rememberNavController(), LoginViewModel())
    }
}