package com.pdm0126.labo5app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.pdm0126.labo5app.navigation.Labo5App
import com.pdm0126.labo5app.ui.theme.Labo5AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Labo5AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Labo5App(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
