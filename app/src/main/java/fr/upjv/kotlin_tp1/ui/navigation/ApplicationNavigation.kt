package fr.upjv.kotlin_tp1.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.upjv.kotlin_tp1.ui.Screen.ChuckScreen
import fr.upjv.kotlin_tp1.ui.Screen.ListScreen
import fr.upjv.kotlin_tp1.ui.Screen.MainScreen


object NavigationPath {
    const val MAIN_SCREEN = "main_screen"
    const val LIST_SCREEN = "list_screen"
    const val CHUCK_SCREEN = "chuck_screen"
}


fun NavGraphBuilder.addMainScreenNav(
    onButtonClick: () -> Unit,
    onButton2Click: () -> Unit
) {
    composable(
        route = NavigationPath.MAIN_SCREEN,
    ) {
        MainScreen(
            onButtonClick = {
                onButtonClick()
            },
            onButton2Click = {
                onButton2Click()
            }
        )
    }
}


fun NavGraphBuilder.addListScreenNavigation() {
    composable(
        route = NavigationPath.LIST_SCREEN,
    ) {
        ListScreen()
    }
}

fun NavGraphBuilder.addChuckScreenNavigation() {
    composable(
        route = NavigationPath.CHUCK_SCREEN,
    ) {
        ChuckScreen()
    }
}


@Composable
fun HomeNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = NavigationPath.MAIN_SCREEN,
    ) {
        addMainScreenNav(
            onButtonClick = {
                navController.navigate(NavigationPath.LIST_SCREEN)
            },
            onButton2Click = {navController.navigate(NavigationPath.CHUCK_SCREEN)}
        )
        addListScreenNavigation()
        addChuckScreenNavigation()
    }
}
