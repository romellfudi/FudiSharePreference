package com.romellfudi.sharepreferencesample;

import android.app.Application;

import com.romellfudi.sharepreference.SharePreferenced;

/**
 * @version 1.0
 * @autor Romell Domínguez
 * @date 3/11/17
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SharePreferenced.init(getApplicationContext());
    }
}
