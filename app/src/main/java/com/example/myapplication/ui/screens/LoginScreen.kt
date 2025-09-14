package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.components.LabeledTextField
import com.example.myapplication.ui.components.PrimaryButton
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun LoginScreen(
    onSignIn: (String, String) -> Unit = { _, _ -> },
    onBack: () -> Unit = {},
    onGoToRegister: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(8.dp))

        Text(
            text = "Login here",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Welcome back you've been missed!",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(Modifier.height(24.dp))

        LabeledTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(12.dp))
        LabeledTextField(
            value = pass,
            onValueChange = { pass = it },
            label = "Password",
            isPassword = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            TextButton(onClick = { /* TODO forgot */ }) {
                Text("Forgot your password?")
            }
        }

        Spacer(Modifier.height(8.dp))
        PrimaryButton(
            text = "Sign in",
            onClick = { onSignIn(email, pass) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))
        TextButton(onClick = onGoToRegister) {
            Text("Create new account")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginPreview() {
    MyApplicationTheme { LoginScreen() }
}

