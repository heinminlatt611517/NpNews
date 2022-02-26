package com.heinminlatt.npnews.root

import android.app.Application
import com.heinminlatt.npnews.utils.SessionManager


class NpNewsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SessionManager.init(applicationContext)
    }

}