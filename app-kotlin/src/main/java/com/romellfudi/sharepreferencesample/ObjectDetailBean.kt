package com.romellfudi.sharepreferencesample

import org.codehaus.jackson.annotate.JsonIgnoreProperties
import java.util.*

/**
 * Created by romelldominguez on 5/15/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class ObjectDetailBean(var state: Boolean,var value: Int, var valueDouble: Double, var details: ArrayList<String>?) {
    constructor() : this(false,-1, 0.0,null)
}