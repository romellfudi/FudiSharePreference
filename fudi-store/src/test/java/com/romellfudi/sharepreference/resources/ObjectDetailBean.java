package com.romellfudi.sharepreference.resources;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;

/**
 * Created by romelldominguez on 5/15/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectDetailBean {

    private String idNotHasSetter;

    private String name;

    private ArrayList<String> details;

    public ObjectDetailBean() {

    }

    public ObjectDetailBean(String id) {
        this.idNotHasSetter = id;
    }

    public ObjectDetailBean(ArrayList<String> details) {
        this.details = details;
    }

    public ArrayList<String> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<String> details) {
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return idNotHasSetter;
    }
}
