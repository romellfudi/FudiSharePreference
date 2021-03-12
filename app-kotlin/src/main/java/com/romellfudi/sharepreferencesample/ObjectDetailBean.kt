package com.romellfudi.sharepreferencesample

import org.codehaus.jackson.annotate.JsonIgnoreProperties
import java.util.*

/**
 * Created by romelldominguez on 5/15/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class ObjectDetailBean(var state: Boolean=false,
                            var value: Int=-1,
                            var valueDouble: Double=0.0,
                            var details: ArrayList<String>?=null)