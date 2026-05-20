package com.pdm0126.labo4app

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey {

    @Serializable
    data object  Home: Routes()

    @Serializable
    data object General: Routes()
}