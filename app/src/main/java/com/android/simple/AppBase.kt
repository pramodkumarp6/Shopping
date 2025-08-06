package com.android.simple

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppBase: Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize global resources here (e.g., Firebase, logging, etc.)
    }
}