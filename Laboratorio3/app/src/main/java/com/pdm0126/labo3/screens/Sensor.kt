package com.pdm0126.labo3.screens

import android.hardware.Sensor
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pdm0126.labo3.components.useSensor


@Composable
fun Sensores(modifier: Modifier = Modifier, NavtoHome:() -> Unit) {
    val lightValues = useSensor(Sensor.TYPE_LIGHT)

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sensor de Luz",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Intensidad:${lightValues[0]} 1x",
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {NavtoHome()}
        ) {
            Text(text = "Home")
        }
    }
}

@Preview
@Composable
fun SensoresPreview(){
    Sensores(modifier = Modifier, {})
}