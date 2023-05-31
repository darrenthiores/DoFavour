package com.example.dofavour.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dofavour.android.core_ui.navigation.Route
import com.example.dofavour.android.landing.presentation.boarding.BoardingScreen
import com.example.dofavour.android.landing.presentation.login.AndroidLoginViewModel
import com.example.dofavour.android.landing.presentation.login.LoginScreen
import com.example.dofavour.core.utils.UiEvent

@Composable
fun DoFavour(
    appState: AppState = rememberAppState(),
    shouldShowOnBoarding: Boolean = true
) {
    val scaffoldState = appState.scaffoldState
    val navController = appState.navController

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        scaffoldState = scaffoldState
    ) { paddingValues ->
        NavHost(
            modifier = Modifier
                .padding(paddingValues),
            navController = navController,
            startDestination = Route.Boarding.name
        ) {
            composable(Route.Boarding.name) {
                BoardingScreen(
                    onLoginClick = {
                        navController.navigate(Route.Login.name)
                    },
                    onSignUpClick = {

                    }
                )
            }

            composable(Route.Login.name) {
                val viewModel: AndroidLoginViewModel = hiltViewModel()
                val state by viewModel.state.collectAsState()

                LaunchedEffect(key1 = true) {
                    viewModel.uiEvent.collect { event ->
                        when(event) {
                            is UiEvent.Success -> {

                            }
                            is UiEvent.ShowSnackBar -> appState.showSnackBar(event.message)
                            else -> Unit
                        }
                    }
                }

                LoginScreen(
                    state = state,
                    onEvent = viewModel::onEvent,
                    onBackClick = {
                        navController.navigateUp()
                    },
                    onSignUp = {  }
                )
            }
        }
    }
}