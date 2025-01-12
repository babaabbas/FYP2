package com.example.fyp


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import com.example.fyp.ui.theme.FYPTheme
import kotlinx.coroutines.delay
import androidx.compose.ui.platform.LocalContext

class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen()
        }
    }
}

@Composable
fun SplashScreen() {
    // Get context to start activity after delay
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        delay(0)  // Show splash screen for 2 seconds
        // Navigate to MainActivity
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
        // Finish SplashActivity so it doesn't remain in the back stack
        (context as? ComponentActivity)?.finish()
    }

    // Splash screen content (e.g., logo or animation)
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Splash Screen", modifier = Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FYPTheme {
        SplashScreen()
    }
}