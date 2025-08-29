package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onSignIn: (email: String, password: String) -> Unit = { _, _ -> },
    onBack: () -> Unit = {},
    onGoToRegister: () -> Unit = {},
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text("Login here", style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold))
        Text("Welcome back you've been missed!", color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f))
        Spacer(Modifier.height(24.dp))
        OutlinedTextField(email, { email = it }, label = { Text("Email") }, singleLine = true,
            modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp))
        Spacer(Modifier.height(12.dp))
        OutlinedTextField(password, { password = it }, label = { Text("Password") }, singleLine = true,
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = { TextButton({ showPassword = !showPassword }) { Text(if (showPassword) "Hide" else "Show") } },
            modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp))
        Spacer(Modifier.height(8.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            TextButton(onClick = { /* TODO */ }) { Text("Forgot your password?") }
        }
        Spacer(Modifier.height(8.dp))
        Button({ onSignIn(email, password) }, Modifier.fillMaxWidth().height(48.dp), shape = RoundedCornerShape(12.dp)) {
            Text("Sign in")
        }
        Spacer(Modifier.height(8.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            TextButton(onClick = onGoToRegister) { Text("Create new account") }
        }
        Spacer(Modifier.height(16.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text("Or continue with", color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f))
        }
        Spacer(Modifier.height(12.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)) {
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
private fun LoginPreview() {
    MyApplicationTheme { LoginScreen() }
}
