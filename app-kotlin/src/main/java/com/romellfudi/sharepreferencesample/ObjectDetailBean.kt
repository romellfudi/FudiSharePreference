/*
 * Copyright (c) 2021. BoostTag E.I.R.L. Romell D.Z.
 * All rights reserved
 * portfolio.romellfudi.com
 */

package com.romellfudi.sharepreferencesample

import com.romellfudi.sharepreference.Fudi
import org.codehaus.jackson.annotate.JsonIgnoreProperties
import java.util.*

/**
 * Created by romelldominguez on 5/15/16.
 */
@Fudi
@JsonIgnoreProperties(ignoreUnknown = true)
data class ObjectDetailBean(var state: Boolean = false,
                            var value: Int = -1,
                            var valueDouble: Double = -999.99,
                            var details: ArrayList<String>? = arrayListOf("raw")) //: FudiDataClass