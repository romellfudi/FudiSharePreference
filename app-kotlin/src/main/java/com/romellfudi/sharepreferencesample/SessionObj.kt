package com.romellfudi.sharepreferencesample

import com.romellfudi.sharepreference.SharePreferenced

/**
 * @version 1.0
 * @autor Romell Domínguez
 * @date 3/11/17
 */

object SessionObj {
    var objectDetailBeanCurrent: ObjectDetailBean?
        get() = SharePreferenced.load(ObjectDetailBean::class.java)
        set(it) =
            SharePreferenced.save(it, ObjectDetailBean::class.java)
    var objectDetailBeanCurrentTAG: ObjectDetailBean?
        get() = SharePreferenced.load(ObjectDetailBean::class.java, "TAG")
        set(it) =
            SharePreferenced.save(it, ObjectDetailBean::class.java, "TAG")

}
