package com.example.wsggcuatro


import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wsggcuatro.ui.theme.WSGGCUATROTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WSGGCUATROTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    listaDinamica(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun listaDinamica(modifier: Modifier = Modifier) {
    val nombreNuevo = remember { mutableStateOf("") }
    val nombreEnlistado = remember { mutableStateListOf<String>() }

    Scaffold() { paddingValues ->
    Column(
        modifier = Modifier
            .fillMaxSize().padding(paddingValues)
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {   Box(
        modifier = Modifier.fillMaxSize().weight(1f),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = nombreNuevo.value,
                onValueChange = {
                    nombreNuevo.value = it
                },
                maxLines = 1,
                minLines = 1,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Nombre") }
            )
            Button(
                onClick = {
                    if (nombreNuevo.value.isNotBlank()) {
                        nombreEnlistado.add(nombreNuevo.value)
                        nombreNuevo.value = ""
                    }
                },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Guardar")
            }
        }}
    Box(
        modifier = Modifier.fillMaxSize().weight(1f),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(top=10.dp,bottom=3.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Listado de nombres y posición en la lista",
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 30.dp)
            )
            Button(
                onClick = {
                    nombreEnlistado.clear()
                    nombreNuevo.value = ""
                }
            ) {
                Text("Limpiar")
            }
        }
    }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(3.dp, Color.Blue).weight(4f)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            LazyColumn( modifier = Modifier.fillMaxSize()) {
                itemsIndexed(nombreEnlistado) { index, item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = item
                        )
                        Text(
                            text = (index + 1).toString()
                        )
                    }
                }
            }
        }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun listaDinamicaPreview() {
    listaDinamica()
}