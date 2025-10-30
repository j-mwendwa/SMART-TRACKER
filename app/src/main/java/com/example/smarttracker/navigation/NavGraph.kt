package com.example.smarttracker.navigation

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smarttracker.auth.LoginScreen
import com.example.smarttracker.auth.SignUpScreen

@Composable
fun navGraph (startDestination: String= Routes.Splash.route){
    val navController : NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination){
        composable (Routes.Splash.route){ SplashScreen(NavController) }
        composable(Routes.Login.route){LoginScreen(navController)}
        composable(Routes.Signup.route){ SignUpScreen(navController)}
        composable(Routes.Home.route){HomeScreen(navController)}
        composable(Routes.AddExpense.route){AddExpenseScreen(navController)}
        composable(Routes.Insights.route){InsightsScreen(navController)}
        composable(Routes.Profile.route){ProfileScreen(navController)}


    }
}
