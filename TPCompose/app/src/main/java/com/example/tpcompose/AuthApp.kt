package com.example.tpcompose

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.tpcompose.screens.tpFinal.AuthViewModel
import com.example.tpcompose.screens.tpFinal.LoginScreen
import com.example.tpcompose.screens.tpFinal.SignupScreen

@Composable
fun AuthApp() {
    val viewModel = remember { AuthViewModel() }
    var isLoginScreen by remember { mutableStateOf(true) }

    if (isLoginScreen) {
        LoginScreen(viewModel = viewModel, onSignupClick = { isLoginScreen = false })
    } else {
        SignupScreen(viewModel = viewModel, onLoginClick = { isLoginScreen = true })
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAuthApp() {
    AuthApp()
}
