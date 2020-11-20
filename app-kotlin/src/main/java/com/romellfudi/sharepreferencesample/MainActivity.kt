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

//        SessionObj.getInstance().objectDetailBeanCurrent =
//                ObjectDetailBean(true,99,1234.56, ArrayList<String>().apply {
//                    add("hello")
//                    add("wait")
//                    add("bye")})
        (findViewById<View>(R.id.texto) as TextView)
                .append("\n${SessionObj.getInstance().objectDetailBeanCurrent?.details!!}," +
                        "${SessionObj.getInstance().objectDetailBeanCurrent?.value!!} ," +
                        "${SessionObj.getInstance().objectDetailBeanCurrent?.valueDouble!!} ," +
                        "${SessionObj.getInstance().objectDetailBeanCurrent?.state!!}")
    }
}
