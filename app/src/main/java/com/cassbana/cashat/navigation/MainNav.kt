package com.cassbana.cashat.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.cassbana.cashat.ui.authentication.GetIntroduced
import com.cassbana.cashat.ui.authentication.Login
import com.cassbana.cashat.ui.authentication.PinCheck

/*@Composable
fun MainNav(navController: NavController) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Routes.Login.route) {
        composable(Routes.Login.route) {
            Login(
                onRegisterClick = { navController.navigateSingleTopTo("${Routes.PinCheck.route}/$it") })
        }
    }
}*/

fun NavGraphBuilder.mainNav(navController: NavHostController) {
    navigation(startDestination = Routes.Login.route, route = "main") {
        composable(Routes.Login.route) {
            Login(
                onRegisterClick = { navController.navigate("${Routes.PinCheck.route}/$it") })
        }
        composable(
            Routes.PinCheck.routeWithArgs,
            arguments = Routes.PinCheck.arguments
        ) {//,deepLinks = Routes.PinCheck.deepLinks
            val otp = it.arguments?.getString(Routes.PinCheck.pinCheckArg)
            otp?.let {
                PinCheck(it,
                    onConfirmClick = { navController.navigate("${Routes.GetIntroduced.route}/$it") })
            }
        }
        composable(
            Routes.GetIntroduced.routeWithArgs,
            arguments = Routes.GetIntroduced.arguments
        ) {
            val mobile = it.arguments?.getString(Routes.GetIntroduced.mobileArg)
            mobile?.let { GetIntroduced(it) }
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }
