package com.example.mbank.ui

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mbank.ui.theme.ClassesTheme
import com.example.mbank.navigation.MyCityNavHost

@Composable
fun MyCityApp(
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier) {
        MyCityNavHost()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MyCityAppPreview() {
    ClassesTheme(dynamicColor = false) {
        MyCityApp()
    }
}
