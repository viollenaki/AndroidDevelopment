package com.example.mbank.ui

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mbank.navigation.MyCityNavHost

@Composable
fun MyCityApp(
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier) {
        MyCityNavHost()
    }
}
