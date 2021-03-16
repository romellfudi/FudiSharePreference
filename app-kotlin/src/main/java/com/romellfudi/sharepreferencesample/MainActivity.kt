/*
 * Copyright (c) 2021. BoostTag E.I.R.L. Romell D.Z.
 * All rights reserved
 * portfolio.romellfudi.com
 */

package com.romellfudi.sharepreferencesample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.romellfudi.sharepreference.*
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Testing Activity
 *
 * @version 1.0.a
 * @autor Romell Dominguez
 * @date 3/11/16
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bean = ObjectDetailBean(true, 99,
                1234.56, arrayListOf("hello", "wait", "bye"))
        texto.append("\n\n${bean}")
        bean.save()
        bean.value = 0
        bean.valueDouble = 8.9999999
        bean.state = false

        bean.load()
        texto.append("\n\n${bean}")
        bean.valueDouble = 454.54
        bean.state = true
        bean.load()
        texto.append("\n\n${bean}")
        bean.clear()
        bean.load()
        texto.append("\n\n${bean}")
        bean.valueDouble = 222.222
        bean.state = false
        bean.details = arrayListOf("byte", "right now")
        bean.saveTag("esto1")
        bean.saveTag("esto2")
        bean.valueDouble = 99999.999
        bean.load()
        texto.append("\n\n${bean}")
        bean.load("esto2")
        texto.append("\n\n${bean}")

    }
}
