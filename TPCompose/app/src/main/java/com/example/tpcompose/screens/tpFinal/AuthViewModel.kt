package com.example.tpcompose.screens.tpFinal

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class AuthState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isSuccess: Boolean = false
)

class AuthViewModel : ViewModel() {
    var loginState by mutableStateOf(AuthState())
        private set

    var signupState by mutableStateOf(AuthState())
        private set

    fun login(email: String, password: String) {
        loginState = loginState.copy(isLoading = true, errorMessage = null)
        viewModelScope.launch {
            delay(2000)
            if (email == "user@example.com" && password  == "password") {
                loginState = loginState.copy(isLoading = false, isSuccess = true)
            } else {
                loginState = loginState.copy(isLoading = false, errorMessage = "Email ou mot de passe incorrect")
            }
        }
    }

    fun signup(email: String, password: String) {
        signupState = signupState.copy(isLoading = true, errorMessage = null)
        viewModelScope.launch {
            delay(2000) // Simuler un appel réseau
            if (email.isNotEmpty() && password.length >= 6) {
                signupState = signupState.copy(isLoading = false, isSuccess = true)
            } else {
                signupState = signupState.copy(
                    isLoading = false,
                    errorMessage = "Veuillez fournir un email valide et un mot de passe d'au moins 6 caractères"
                )
            }
        }
    }
}
