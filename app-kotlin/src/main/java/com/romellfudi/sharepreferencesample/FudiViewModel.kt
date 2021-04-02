/*
 * Copyright (c) 2021. BoostTag E.I.R.L. Romell D.Z.
 * All rights reserved
 * portfolio.romellfudi.com
 */

package com.romellfudi.sharepreferencesample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * View Model
 *
 * @version 1.0.a
 * @autor Romell Domínguez (@romellfudi)
 * @date 4/1/21
 */
class FudiViewModel : ViewModel() {

    private val _response = MutableLiveData<ObjectDetailBean>()
    val response: LiveData<ObjectDetailBean>
        get() = _response
    var notChanged:Boolean=true

    fun addObjectOnBoard(appEndString: ObjectDetailBean) {
        _response.value = appEndString
    }

}