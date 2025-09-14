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
fun RegisterScreen(
    onSignUp: (String, String, String) -> Unit = { _, _, _ -> },
    onBack: () -> Unit = {},
    onGoToLogin: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var confirm by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(8.dp))

        Text(
            text = "Create Account",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(6.dp))
        Text(
            text = "Create an account so you can explore all the existing jobs",
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
        Spacer(Modifier.height(12.dp))
        LabeledTextField(
            value = confirm,
            onValueChange = { confirm = it },
            label = "Confirm Password",
            isPassword = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))
        PrimaryButton(
            text = "Sign up",
            onClick = { onSignUp(email, pass, confirm) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))
        TextButton(onClick = onGoToLogin) {
            Text("Already have an account")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RegisterPreview() {
    MyApplicationTheme { RegisterScreen() }
}
