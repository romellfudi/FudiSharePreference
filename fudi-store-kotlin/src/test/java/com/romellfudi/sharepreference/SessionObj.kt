package com.romellfudi.sharepreference

import com.romellfudi.sharepreference.resources.ObjectBean
import com.romellfudi.sharepreference.resources.ObjectDetailBean

/**
 * Created by romelldominguez on 5/15/16.
 */
object SessionObj {
    var objectDetailBeanCurrent: ObjectDetailBean?
        get() = SharePreferenced.load(ObjectDetailBean::class.java)
        set(objectDetailBeanCurrent) = SharePreferenced.save(objectDetailBeanCurrent!!, ObjectDetailBean::class.java)
    var objectDetailBeanCurrentTAG: ObjectDetailBean?
        get() = SharePreferenced.load(ObjectDetailBean::class.java, "TAG")
        set(objectDetailBeanCurrent) = SharePreferenced.save(objectDetailBeanCurrent!!, ObjectDetailBean::class.java, "TAG")

    fun currentObject(objectBean: ObjectBean) {
        SharePreferenced.save(objectBean, ObjectBean::class.java)
    }

    fun currentObject(): ObjectBean? {
        return SharePreferenced.load(ObjectBean::class.java)
    }
}
