package com.romellfudi.sharepreferencesample

import org.codehaus.jackson.annotate.JsonIgnoreProperties
import java.util.*

/**
 * Created by romelldominguez on 5/15/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class ObjectDetailBean(var details: ArrayList<String>?) {
    constructor() : this(null)
}