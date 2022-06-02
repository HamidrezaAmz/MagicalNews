package ir.hamidrezaAmz.magicalnews

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MagicalNewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}