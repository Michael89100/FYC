package com.example.tpcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.rememberNavController
import com.example.tpcompose.ui.theme.TPComposeTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TPComposeTheme {
                val navController = rememberNavController()
                Scaffold {
                    //AuthApp()
                    //ProfileScreen()
                    AppNavHost(navController = navController)
                }
            }
        }
    }
}
