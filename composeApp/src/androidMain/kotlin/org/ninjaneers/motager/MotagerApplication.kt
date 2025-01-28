package org.ninjaneers.motager

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.ninjaneers.motager.app.di.initKoin

class MotagerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MotagerApplication)
        }
    }
}