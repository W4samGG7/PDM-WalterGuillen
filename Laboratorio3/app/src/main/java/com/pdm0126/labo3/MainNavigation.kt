package com.pdm0126.labo3

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.labo3.screens.HomeScreen
import com.pdm0126.labo3.screens.Sensores
import com.pdm0126.labo3.screens.listaDinamica


@Composable
fun Labo3App (modifier: Modifier = Modifier){
    val backstack = rememberNavBackStack(Routes.Home)

    NavDisplay(
    backStack = backstack,
        onBack = {backstack.removeLastOrNull()},
        entryProvider = entryProvider{
            entry<Routes.Home>{
                HomeScreen(
                    modifier = modifier,
                    NavtoLista = {
                        backstack.add(Routes.Lista)
                    },
                    NavtoSensor = {
                        backstack.add(Routes.Sensor)
                    }
                )
            }
            entry<Routes.Lista>{
                listaDinamica (
                    modifier = modifier,
                    NavtoHome = {
                        backstack.removeLastOrNull()
                    }
                )
            }
            entry<Routes.Sensor> {
                Sensores(
                  modifier = modifier,
                    NavtoHome = {
                        backstack.removeLastOrNull()
                    }
                )
            }
        }

    )
}