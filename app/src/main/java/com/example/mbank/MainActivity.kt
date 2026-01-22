package com.example.mbank
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mbank.ui.theme.ClassesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClassesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }
    var count2 by remember {mutableStateOf(0)}
    var count3 by remember {mutableStateOf(0)}
    var lastClicked by remember { mutableStateOf("None") }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        // Используем имя
        Text(text = "Hello $name!", modifier = Modifier.padding(8.dp))

        Row{
            Text("Count 1: $count", modifier = Modifier.padding(16.dp))
            Text("Count 2: $count2", modifier = Modifier.padding(16.dp))
            Text("Count 3: $count3", modifier = Modifier.padding(16.dp))
        }
        Row{
            Button(
                onClick = {
                    count++
                    lastClicked = "Button 1"
                },
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text("Button 1")
            }
            Button(
                onClick = {
                    count2++
                    lastClicked = "Button 2"
                },
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green
                )
            ) {
                Text("Button 2")
            }
            Button(
                onClick = {
                    count3++
                    lastClicked = "Button 3"
                },
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Magenta
                )
            ) {
                Text("Button 3")
            }

        }
        Text(
            text = "Last clicked: $lastClicked",
            modifier = Modifier.padding(16.dp),
            fontSize = 20.sp,
            color = Color.Red
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClassesTheme {
        Greeting("Android")
    }
}
