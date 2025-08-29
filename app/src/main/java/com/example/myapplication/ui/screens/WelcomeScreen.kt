package com.example.myapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.ui.res.painterResource
import com.example.myapplication.R


@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onLogin: () -> Unit = {},
    onRegister: () -> Unit = {},
) {
    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.welcome),
            contentDescription = "Welcome illustration",
            modifier = Modifier.size(220.dp)
        )
        Spacer(Modifier.height(24.dp))
        Text("Discover Your\nDream Job here",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center)
        Spacer(Modifier.height(8.dp))
        Text("Explore all the existing job roles based on your interest and study major",
            textAlign = TextAlign.Center, style = MaterialTheme.typography.bodyMedium)
        Spacer(Modifier.height(24.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(onClick = onLogin) { Text("Login") }
            TextButton(onClick = onRegister) { Text("Register") }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomePreview() {
    MyApplicationTheme { WelcomeScreen() }
}



