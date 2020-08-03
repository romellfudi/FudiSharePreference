package com.romellfudi.sharepreference.resources

import org.codehaus.jackson.annotate.JsonIgnoreProperties
import java.util.*

/**
 * Created by romelldominguez on 5/15/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class ObjectDetailBean(var idNotHasSetter: String? = null,
                            var details: ArrayList<String>? = null) {
    var name: String? = null

    constructor() : this(null, null)

    constructor(id: String) : this(id, null)

    constructor(details: ArrayList<String>) : this(null, details)
}
