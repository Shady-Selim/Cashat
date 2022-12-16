package com.cassbana.cashat.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Routes(val route: String) {
    object Login : Routes("login")
    object PinCheck : Routes("pinCheck") {
        const val pinCheckArg = "otp"
        val routeWithArgs = "$route/{$pinCheckArg}"
        val arguments = listOf(navArgument(pinCheckArg) { type = NavType.StringType })
//        val deepLinks = listOf( navDeepLink { uriPattern = "android-app://androidx.navigation/$routeWithArgs" } )
    }

    object GetIntroduced : Routes("getIntroduced") {
        const val mobileArg = "mobile"
        val routeWithArgs = "$route/{$mobileArg}"
        val arguments = listOf(navArgument(mobileArg) { type = NavType.StringType })
    }
}

