package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    onSignUp: (email: String, pass: String, confirm: String) -> Unit = { _, _, _ -> },
    onBack: () -> Unit = {},
    onGoToLogin: () -> Unit = {},
) {
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var confirm by remember { mutableStateOf("") }
    var showPass by remember { mutableStateOf(false) }
    var showConfirm by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Create Account",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
        )
        Text(
            text = "Create an account so you can explore all the existing jobs",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )

        Spacer(Modifier.height(24.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )
        Spacer(Modifier.height(12.dp))
        OutlinedTextField(
            value = pass,
            onValueChange = { pass = it },
            label = { Text("Password") },
            singleLine = true,
            visualTransformation = if (showPass) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                TextButton(onClick = { showPass = !showPass }) {
                    Text(if (showPass) "Hide" else "Show")
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )
        Spacer(Modifier.height(12.dp))
        OutlinedTextField(
            value = confirm,
            onValueChange = { confirm = it },
            label = { Text("Confirm Password") },
            singleLine = true,
            visualTransformation = if (showConfirm) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                TextButton(onClick = { showConfirm = !showConfirm }) {
                    Text(if (showConfirm) "Hide" else "Show")
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { onSignUp(email, pass, confirm) },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp)
        ) { Text("Sign up") }

        Spacer(Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            TextButton(onClick = onGoToLogin) { Text("Already have an account") }
        }

        Spacer(Modifier.height(12.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text("Or continue with", color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f))
        }
        Spacer(Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
        ) {
            listOf("G", "f", "").forEach { label ->
                Surface(shape = CircleShape, tonalElevation = 2.dp, modifier = Modifier.size(40.dp)) {
                    Box(contentAlignment = Alignment.Center) { Text(label) }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RegisterPreview() {
    MyApplicationTheme { RegisterScreen() }
}
