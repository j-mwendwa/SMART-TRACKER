package com.example.smarttracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.smarttracker.navigation.NavigationGraph
import com.example.smarttracker.ui.theme.SmartTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartTrackerTheme {
                NavigationGraph()
            }
        }
    }
}

