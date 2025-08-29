package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "welcome",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("welcome") {
                            com.example.myapplication.ui.screens.WelcomeScreen(
                                onLogin = { navController.navigate("login") },
                                onRegister = { navController.navigate("register") }
                            )
                        }
                        composable("login") {
                            com.example.myapplication.ui.screens.LoginScreen(
                                onSignIn = { _, _ -> /* TODO: autenticación */ },
                                onBack = { navController.popBackStack() },
                                onGoToRegister = { navController.navigate("register") }
                            )
                        }
                        composable("register") {
                            com.example.myapplication.ui.screens.RegisterScreen(
                                onSignUp = { _, _, _ -> /* TODO: registro */ },
                                onBack = { navController.popBackStack() },
                                onGoToLogin = { navController.navigate("login") }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    MyApplicationTheme {
        com.example.myapplication.ui.screens.WelcomeScreen(
            onLogin = {},
            onRegister = {}
        )
    }
}
