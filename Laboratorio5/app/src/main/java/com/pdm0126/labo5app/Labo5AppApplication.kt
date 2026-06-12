package com.pdm0126.labo5app

import android.app.Application
import com.pdm0126.labo5app.data.AppProvider

class Labo5AppApplication : Application(){
    val appProvider by lazy { AppProvider(this) }
}

