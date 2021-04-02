/*
 * Copyright (c) 2021. BoostTag E.I.R.L. Romell D.Z.
 * All rights reserved
 * portfolio.romellfudi.com
 */

package com.romellfudi.sharepreferencesample

import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.romellfudi.sharepreference.clear
import com.romellfudi.sharepreference.load
import com.romellfudi.sharepreference.save
import com.romellfudi.sharepreference.saveTag
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Testing Activity
 *
 * @version 1.0.a
 * @autor Romell Dominguez
 * @date 3/11/16
 */
class MainActivity : AppCompatActivity(), KoinComponent {

    private val fudiViewModel: FudiViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fudiViewModel.response.observe(this, Observer { onPrintResult(it) })
        if (fudiViewModel.notChanged)
           Handler().postDelayed(::postDelay,100)
    }

    private fun postDelay(){
        var bean = ObjectDetailBean(true, 99,
                1234.56, arrayListOf("hello", "wait", "bye"))
        fudiViewModel.addObjectOnBoard(bean)
        bean.save()
        bean.value = 0
        bean.valueDouble = 8.9999999
        bean.state = false
        bean.load()
        fudiViewModel.addObjectOnBoard(bean)
        bean.valueDouble = 454.54
        bean.state = true
        bean.load()
        fudiViewModel.addObjectOnBoard(bean)
        bean.clear()
        bean.load()
        fudiViewModel.addObjectOnBoard(bean)
        bean.valueDouble = 222.222
        bean.state = false
        bean.details = arrayListOf("byte", "right now")
        bean.saveTag("esto1")
        bean.saveTag("esto2")
        bean.valueDouble = 99999.999
        bean.load()
        fudiViewModel.addObjectOnBoard(bean)
        bean.load("esto2")
        fudiViewModel.addObjectOnBoard(bean)
    }

    private fun onPrintResult(result: ObjectDetailBean) {
        texto.append("\n\n${result}")
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        fudiViewModel.notChanged =false
    }
}
