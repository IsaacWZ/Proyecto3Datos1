package com.example.proyecto3datos1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyecto3datos1.ui.theme.Proyecto3Datos1Theme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto3Datos1Theme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { HomeScreen(navController) }
                    composable("register") { RegisterScreen() }
                }

            }
        }
    }
}





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val idValue = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa todoo el espacio disponible
            .padding(16.dp), // Padding alrededor del Column
        horizontalAlignment = Alignment.CenterHorizontally, // Alinea horizontalmente los elementos
        verticalArrangement = Arrangement.Center // Alinea verticalmente los elementos
    ){

        TextField(
            value = idValue.value,
            onValueChange = { newValue -> idValue.value = newValue },
            label = { Text("ID", color = Color(0xFFFFFFFF)) },
            placeholder = { Text("ID", color = Color(0xFFFFFFFF)) },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFF000000),
                textColor = Color(0xFFFFFFFF)))

        Button(onClick = { /* acción para Driver */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green) // Botón verde
        ) {
            Text(text = "Driver")

        }
        Button(onClick = { /* acción para Personal */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green) // Botón verde
        ) {
            Text(text = "Personal")
        }
        Button(
            onClick = { navController.navigate("register") },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
        ) {
            Text("Registrarse")
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenPreview() {
    val idValue = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa todoo el espacio disponible
            .padding(16.dp), // Padding alrededor del Column
        horizontalAlignment = Alignment.CenterHorizontally, // Alinea horizontalmente los elementos
        verticalArrangement = Arrangement.Center // Alinea verticalmente los elementos
    ){

        TextField(
            value = idValue.value,
            onValueChange = { newValue -> idValue.value = newValue },
            label = { Text("ID", color = Color(0xFFFFFFFF)) },
            placeholder = { Text("ID", color = Color(0xFFFFFFFF)) },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFF000000),
                textColor = Color(0xFFFFFFFF)))

        Button(onClick = { /* acción para Driver */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green) // Botón verde
        ) {
            Text(text = "Driver")

        }
        Button(onClick = { /* acción para Personal */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green) // Botón verde
        ) {
            Text(text = "Personal")
        }
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
        ) {
            Text("Registrarse")
        }


    }
}
@Composable
fun RegisterScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Text(text = "Pantalla de Registro", Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Proyecto3Datos1Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black // Fondo negro
        ){
            HomeScreenPreview()
        }
    }
}