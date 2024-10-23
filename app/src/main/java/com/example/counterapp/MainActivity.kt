package com.example.counterapp
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCounterApp()
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyCounterApp() {
    // State variable to hold the counter value
    var count by remember { mutableStateOf(0) }

    // Scaffold is used to provide a default layout
    Scaffold(
        content = {
            // Column to arrange elements vertically
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Display the current count
                Text(
                    text = "Counter: $count",
                    style = MaterialTheme.typography.h4
                )

                // Button to increase the counter
                Button(
                    onClick = { count++ },
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text("Increase")
                }

                // Button to decrease the counter
                Button(
                    onClick = { if (count > 0) count-- },
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text("Decrease")
                }

                // Button to reset the counter
                Button(
                    onClick = { count = 0 },
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text("Reset")
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyCounterApp()
}
