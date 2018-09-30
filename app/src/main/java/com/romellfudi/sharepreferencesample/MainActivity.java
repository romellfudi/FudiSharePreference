package com.romellfudi.sharepreferencesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.texto);

        ObjectDetailBean objectDetailBean
                = new ObjectDetailBean();
        ArrayList<String> data = new ArrayList<>();
        data.add("hello");
        data.add("wait");
        data.add("bye");
        objectDetailBean.setDetails(data);

        SessionObj.getInstance().setObjectDetailBeanCurrent(objectDetailBean);
        textView.append("\n" +
                SessionObj.getInstance().getObjectDetailBeanCurrent().getDetails()
        );
    }
}
