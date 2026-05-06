package com.pdm0126.labo3.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun listaDinamica(modifier: Modifier = Modifier, NavtoHome:() -> Unit) {
    val nombreNuevo = remember { mutableStateOf("") }
    val nombreEnlistado = remember { mutableStateListOf<String>() }

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
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
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 3.dp),
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
                .border(3.dp, Color.Blue)
                .weight(4f)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
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
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {NavtoHome()}
        ) {
            Text(
                text = "Home"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun listaDinamicaPreview() {
    listaDinamica(modifier = Modifier, {})
}