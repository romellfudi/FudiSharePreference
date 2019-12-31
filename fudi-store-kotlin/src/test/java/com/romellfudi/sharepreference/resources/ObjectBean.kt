package com.romellfudi.sharepreference.resources

import org.codehaus.jackson.annotate.JsonIgnoreProperties

import java.util.ArrayList

/**
 * Created by romelldominguez on 5/15/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class ObjectBean {

    var data: String? = null

    var objectDetailBeans: ArrayList<ObjectDetailBean>? = null

    constructor() {}

    constructor(data: String) {
        this.data = data
    }
}
