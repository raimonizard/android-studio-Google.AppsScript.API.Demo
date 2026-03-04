package com.example.googleappsscriptapidemo

import com.example.googleappsscriptapidemo.ui.view.OnePieceScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OnePieceScreen(
                apiKey = BuildConfig.API_KEY
            )
        }
    }
}