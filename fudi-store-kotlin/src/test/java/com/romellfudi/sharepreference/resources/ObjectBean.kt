/*
 * Copyright (c) 2021. BoostTag E.I.R.L. Romell D.Z.
 * All rights reserved
 * portfolio.romellfudi.com
 */

package com.romellfudi.sharepreference.resources

import com.romellfudi.sharepreference.Fudi
import org.codehaus.jackson.annotate.JsonIgnoreProperties
import java.util.*

/**
 * Created by romelldominguez on 5/15/16.
 */
@Fudi
@JsonIgnoreProperties(ignoreUnknown = true)
data class ObjectBean(var data: String?="", var objectDetailBeans: ArrayList<ObjectDetailBean>?=null) {
}
