package au.com.monk.traveldiaries

import TabNavigator
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import au.com.monk.traveldiaries.routes.Route
import au.com.monk.traveldiaries.ui.screens.CustomSingUpScreen
import au.com.monk.traveldiaries.ui.screens.LoginScreenView
import au.com.monk.traveldiaries.ui.screens.SplashScreen
import au.com.monk.traveldiaries.ui.theme.TravelDiariesTheme
import au.com.monk.traveldiaries.viewmodels.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginViewModel: LoginViewModel by viewModels()
        setContent {

            TravelDiariesTheme {
                val navController = rememberNavController()
                val graph: NavGraph = remember(navController) {
                    navController.createGraph(startDestination = Route.splash.route) {
                        composable(Route.splash.route) {
                            SplashScreen(
                                navController,
                                loginViewModel = loginViewModel
                            )
                        }
                        composable(Route.login.route) {
                            LoginScreenView(
                                navController,
                                loginViewModel = loginViewModel
                            )
                        }
                        composable(Route.signup.route) { CustomSingUpScreen() }
                        composable(Route.navigator.route) { TabNavigator() }
                    }
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, graph = graph)
                }
            }
        }
    }
}

