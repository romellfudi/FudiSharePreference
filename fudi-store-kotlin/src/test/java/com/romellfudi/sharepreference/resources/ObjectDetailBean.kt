package com.romellfudi.sharepreference.resources

import org.codehaus.jackson.annotate.JsonIgnoreProperties
import java.util.*

/**
 * Created by romelldominguez on 5/15/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class ObjectDetailBean {

    var idNotHasSetter: String = ""
    var name: String? = null

    var details: ArrayList<String>? = null

    constructor() {

    }

    constructor(id: String) {
        this.idNotHasSetter = id
    }

    constructor(details: ArrayList<String>) {
        this.details = details
    }
}
