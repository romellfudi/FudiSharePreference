package com.romellfudi.sharepreferencesample

import com.romellfudi.sharepreference.SharePreferenced

/**
 * @version 1.0
 * @autor Romell Domínguez
 * @date 3/11/17
 */

class SessionObj private constructor() {
    var objectDetailBeanCurrent: ObjectDetailBean?
        get() = SharePreferenced.load(ObjectDetailBean::class.java)
        set(objectDetailBeanCurrent) = SharePreferenced.save(objectDetailBeanCurrent!!, ObjectDetailBean::class.java)
    var objectDetailBeanCurrentTAG: ObjectDetailBean?
        get() = SharePreferenced.load(ObjectDetailBean::class.java, "TAG")
        set(objectDetailBeanCurrent) = SharePreferenced.save(objectDetailBeanCurrent!!, ObjectDetailBean::class.java, "TAG")

    companion object {

        private var instance: SessionObj? = null

        fun getInstance(): SessionObj {
            if (instance == null)
                instance = SessionObj()
            return instance as SessionObj
        }
    }
}
