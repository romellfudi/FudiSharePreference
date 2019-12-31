package com.romellfudi.sharepreferencesample

import org.codehaus.jackson.annotate.JsonIgnoreProperties
import java.util.*

/**
 * Created by romelldominguez on 5/15/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class ObjectDetailBean {

    var details: ArrayList<String>? = null

    constructor() {

    }

    constructor(details: ArrayList<String>) {
        this.details = details
    }
}
