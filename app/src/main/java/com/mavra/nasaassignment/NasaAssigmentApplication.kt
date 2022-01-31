package com.mavra.nasaassignment

import android.app.Application
import com.facebook.soloader.SoLoader
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NasaAssigmentApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        SoLoader.init(this, false);
    }

}
