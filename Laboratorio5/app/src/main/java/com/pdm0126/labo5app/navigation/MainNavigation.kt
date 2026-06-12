package com.pdm0126.labo5app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.labo5app.screens.General.General
import com.pdm0126.labo5app.screens.Home.HomeScreen

@Composable
fun Labo5App(modifier: Modifier = Modifier){
    val backStack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack = backStack,
        onBack = {backStack.removeLastOrNull()},
        entryProvider = entryProvider {
            entry<Routes.Home>{
                HomeScreen(modifier = modifier,
                    NavtoGeneral = {
                        backStack.add(Routes.General)
                    })
            }

            entry<Routes.General>{
                General()
            }
        }
    )
}