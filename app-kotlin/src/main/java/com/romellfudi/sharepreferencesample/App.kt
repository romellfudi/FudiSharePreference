/*
 * Copyright (c) 2021. BoostTag E.I.R.L. Romell D.Z.
 * All rights reserved
 * portfolio.romellfudi.com
 */

package com.romellfudi.sharepreferencesample

import android.app.Application

import com.romellfudi.sharepreference.SharePreferenced

/**
 * @version 1.0
 * @autor Romell Domínguez
 * @date 3/11/17
 */

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        SharePreferenced.init(applicationContext)
    }
}
