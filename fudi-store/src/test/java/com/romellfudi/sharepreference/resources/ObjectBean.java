package com.romellfudi.sharepreference.resources;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;

/**
 * Created by romelldominguez on 5/15/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectBean {

    private String data;

    private ArrayList<ObjectDetailBean> objectDetailBeans;

    public ObjectBean() {
    }

    public ObjectBean(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ArrayList<ObjectDetailBean> getObjectDetailBeans() {
        return objectDetailBeans;
    }

    public void setObjectDetailBeans(ArrayList<ObjectDetailBean> objectDetailBeans) {
        this.objectDetailBeans = objectDetailBeans;
    }
}
