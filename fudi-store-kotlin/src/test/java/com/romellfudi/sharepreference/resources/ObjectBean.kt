package com.romellfudi.sharepreference.resources

import org.codehaus.jackson.annotate.JsonIgnoreProperties
import java.util.*

/**
 * Created by romelldominguez on 5/15/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class ObjectBean(var data: String?, var objectDetailBeans: ArrayList<ObjectDetailBean>?) {
    constructor() : this(null, null)
    constructor(data: String) : this(data, null)
}
