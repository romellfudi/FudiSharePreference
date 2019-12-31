package com.romellfudi.sharepreferencesample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<View>(R.id.texto) as TextView

        val objectDetailBean = ObjectDetailBean()
        val data = ArrayList<String>()
        data.add("hello")
        data.add("wait")
        data.add("bye")
        objectDetailBean.details = data

        SessionObj.getInstance().objectDetailBeanCurrent = objectDetailBean
        textView.append("\n" + SessionObj.getInstance().objectDetailBeanCurrent!!.details!!
        )
    }
}
