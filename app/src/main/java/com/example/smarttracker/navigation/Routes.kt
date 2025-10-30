package com.example.smarttracker.navigation

sealed class Routes(val route: String){
    object Splash : Routes("splash")
    object Login : Routes ("login")
    object Signup  :Routes ("signup")
    object Home : Routes("home")
    object AddExpense : Routes("add_expense")
    object Insights : Routes("insights")
    object Profile : Routes("profile")
}