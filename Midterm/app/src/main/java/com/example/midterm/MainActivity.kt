package com.example.midterm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.midterm.ui.theme.MidtermTheme
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MidtermTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Converter()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Converter() {
    var litersText by remember { mutableStateOf("") }
    var gallonsText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = litersText,
            onValueChange = {
                litersText = it
                val liters = it.toDoubleOrNull() ?: 0.0
                val gallons = round(liters * 0.219 * 100.0) / 100
                gallonsText = gallons.toString()
            },
            label = { Text("Liters") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = gallonsText,
            onValueChange = {},
            label = { Text("Gallons") },
            modifier = Modifier.fillMaxWidth(),
            readOnly = true
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ConverterPreview() {
    MidtermTheme {
        Converter()
    }
}
