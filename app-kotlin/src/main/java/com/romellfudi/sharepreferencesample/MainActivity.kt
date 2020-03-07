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
        val objectDetailBean = ObjectDetailBean()
        val data = ArrayList<String>()
        with(data) {
            add("hello")
            add("wait")
            add("bye")
        }
//        objectDetailBean.details = data
        SessionObj.getInstance().objectDetailBeanCurrent = objectDetailBean.apply { details = data }
        (findViewById<View>(R.id.texto) as TextView)
                .append("\n${SessionObj.getInstance().objectDetailBeanCurrent?.details!!}")
    }
}
