package au.com.monk.traveldiaries.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import au.com.monk.traveldiaries.R
import au.com.monk.traveldiaries.data.generic.ViewState
import au.com.monk.traveldiaries.routes.Route
import au.com.monk.traveldiaries.viewmodels.LoginViewModel

@Composable
fun SplashScreen(navigator: NavHostController, loginViewModel: LoginViewModel){
    val TAG = "SplashScreen"
    val observedValue by loginViewModel.userAccount.observeAsState()
    
    LaunchedEffect( Unit) {
        loginViewModel.authenticateActiveUser()
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ){
    Image(painter = painterResource(id = R.drawable.travel_diaries__1_), contentDescription = "Logo",
            alignment = Alignment.Center
        )
        when(observedValue){
            is ViewState.Failure -> {
                navigator.navigate(route = Route.login.route)
            }
            ViewState.Loading -> TODO()
            is ViewState.Success -> {
                navigator.navigate(Route.navigator.route)
            }
            null -> {
                Log.d(TAG, "NULL on observed value")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen(){
SplashScreen(rememberNavController(), LoginViewModel())
}