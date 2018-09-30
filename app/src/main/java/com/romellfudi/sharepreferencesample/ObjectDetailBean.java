package com.romellfudi.sharepreferencesample;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;

/**
 * Created by romelldominguez on 5/15/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectDetailBean {

    private ArrayList<String> details;

    public ObjectDetailBean(){

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
}
