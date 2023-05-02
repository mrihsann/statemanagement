package com.ihsanarslan.statemanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ihsanarslan.statemanagement.ui.theme.StateManagementTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateManagementTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Counter()
                }
            }
        }
    }
}

@Composable
fun Counter() {
    val countState = remember { mutableStateOf(0) }

    Column {
        Button(onClick = { countState.value -= 1 }) {
            Text("-")
        }
        Text(text = countState.value.toString())
        Button(onClick = { countState.value += 1 }) {
            Text("+")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StateManagementTheme {
        Counter()
    }
}