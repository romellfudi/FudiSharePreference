package com.romellfudi.sharepreferencesample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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

        SessionObj.objectDetailBeanCurrent = ObjectDetailBean(true, 99,
                1234.56, arrayListOf("hello", "wait", "bye"))
        texto.append("\n${SessionObj.objectDetailBeanCurrent?.toString()}")
        texto.append("\n----")
        SessionObj.objectDetailBeanCurrentTAG = SessionObj.objectDetailBeanCurrent
                ?.copy(state = false, details = arrayListOf("NotEmpty"))
        SessionObj.objectDetailBeanCurrent = null
        texto.append("\n${SessionObj.objectDetailBeanCurrent?.toString()}")
        texto.append("\n----")
        texto.append("\n${SessionObj.objectDetailBeanCurrentTAG?.toString()}")
        texto.append("\n----")
        texto.append("\n${SessionObj.objectDetailBeanCurrentTAG?.copy(value = -616).toString()}")
    }
}
