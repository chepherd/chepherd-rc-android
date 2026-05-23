package io.chepherd.rc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import io.chepherd.rc.style.Palette
import io.chepherd.rc.ui.ChepherdTheme
import io.chepherd.rc.ui.RootView

class ChepherdActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChepherdTheme {
                Surface(modifier = Modifier.fillMaxSize().background(Palette.background)) {
                    RootView()
                }
            }
        }
    }
}
