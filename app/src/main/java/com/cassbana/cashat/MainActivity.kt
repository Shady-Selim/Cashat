package com.cassbana.cashat

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cassbana.cashat.helper.LtrRtlDarkLightPreviews
import com.cassbana.cashat.navigation.Routes
import com.cassbana.cashat.navigation.mainNav
import com.cassbana.cashat.ui.theme.CassbanaTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        val splashScreen =
        installSplashScreen()
        super.onCreate(savedInstanceState)

//        var uiState: MainActivityUiState by mutableStateOf(MainActivityUiState.Loading)
        resources.configuration.setLocale(java.util.Locale("ar"))

        /* // Update the uiState
         lifecycleScope.launch {
             lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                 viewModel.uiState
                     .onEach {
                         uiState = it
                     }
                     .collect()
             }
         }*/
        /*splashScreen.setKeepOnScreenCondition {
            when (uiState) {
                MainActivityUiState.Loading -> true
                is MainActivityUiState.Success -> false
            }
        }*/
        setContent {
            CassbanaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Main()
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun Main() {
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination?.route
    Box {
        currentDestination.let {
            if (checkCurrentDestination(it)) {
                IconButton(onClick = {
                    navController.navigateUp()
                }) { Icon(Icons.Rounded.ArrowForward, "") }
            }
        }
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 119.dp)
        ) {
            NavHost(navController, startDestination = "main") {
                mainNav(navController)
            }
        }
    }
}

fun checkCurrentDestination(currentDestination: String?): Boolean {
    return when (currentDestination.toString()) {
        Routes.PinCheck.routeWithArgs,
        Routes.GetIntroduced.routeWithArgs -> true
        else -> false
    }
}

@LtrRtlDarkLightPreviews
@Composable
fun DefaultPreview() {
    CassbanaTheme {
        Main()
    }
}

