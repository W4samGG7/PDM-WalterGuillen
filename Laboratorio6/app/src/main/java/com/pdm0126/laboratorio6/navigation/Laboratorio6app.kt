package com.pdm0126.laboratorio6.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.laboratorio6.ui.screens.MealList.MealListScreen

@Composable
fun Laboratorio6App(){
    val backStack = rememberNavBackStack(Routes.MealList)

    NavDisplay(
        backStack = backStack,
        onBack = {backStack.removeLastOrNull()},
        entryProvider = entryProvider {
            entry<Routes.MealList> {
                MealListScreen()
            }
        }
    )

}