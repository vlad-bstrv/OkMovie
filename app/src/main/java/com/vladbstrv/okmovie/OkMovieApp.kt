package com.vladbstrv.okmovie

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class OkMovieApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@OkMovieApp)
            modules(appModule)
        }
    }


}