package com.example.countercompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object Routes {
    const val COUNTER = "counter"
    const val DATA_DIRI = "data_diri"
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.COUNTER,
        modifier = modifier
    ) {
        composable(Routes.COUNTER) {
            CounterApp(
                onNext = { navController.navigate(Routes.DATA_DIRI) }
            )
        }
        composable(Routes.DATA_DIRI) {
            DataDiriApp(
                onBack = { navController.popBackStack() }
            )
        }
    }
}