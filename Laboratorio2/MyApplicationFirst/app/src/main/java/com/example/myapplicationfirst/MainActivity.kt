package com.example.myapplicationfirst

import android.graphics.Color.blue
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplicationfirst.ui.theme.MyApplicationFirstTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationFirstTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    listaConNombres(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun listaConNombres(modifier: Modifier = Modifier) {
    val texto: List<String> = listOf("Sam","Yo")
    val lista: MutableState<String> = remember { mutableStateOf("") }

    Column(

    ) {Box(modifier = Modifier.fillMaxSize().weight(1f), contentAlignment = Alignment.Center) {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            TextField(
                value = lista.value,
                onValueChange = {
                    lista.value = it
                }
            )

            Button(
                onClick = {

                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Guardar")
            }
        }
    }
        Box() {
            Row(modifier = Modifier.padding(start = 20.dp, end = 20.dp)) {
                Text(
                    text = "Listado de nombre y posicion en la fila",
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(5.dp)
                )
                Button(
                    onClick = {

                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Limpiar")
                }

            }
        }
        Box(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .border(
                    color = Color(0, 0, 250),
                    width = 2.dp,
                    shape = RectangleShape,
                )
        ) {
            LazyColumn() {
                itemsIndexed(texto.toList()) { index, item ->
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

@Preview(showBackground = true)
@Composable
fun listaConNombresPreview() {
    MyApplicationFirstTheme {
        listaConNombres()
    }
}