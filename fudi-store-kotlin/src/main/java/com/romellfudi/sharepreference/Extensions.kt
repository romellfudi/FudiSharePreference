/*
 * Copyright (c) 2021. BoostTag E.I.R.L. Romell D.Z.
 * All rights reserved
 * portfolio.romellfudi.com
 */

package com.romellfudi.sharepreference

import android.annotation.SuppressLint

/**
 * Data Class Extensions
 * Using @data class
 *
 * @version 1.1.a
 * @autor Romell Domínguez (@romellfudi)
 * @date 3/16/21
 */

@SuppressLint("NewApi")
inline fun <reified T : Any> T.load() {
    (T::class.java.annotations.find { it is Fudi } as? Fudi)?.let {
        var obj = SharePreferenced.load(T::class.java)
        val t = T::class.java.constructors
        var empty = T::class.java.constructors.first { it.parameterCount==0 }.newInstance() as T
        for (a in T::class.java.declaredFields) {
            a.isAccessible = true
            a.set(this, a.get(obj ?: empty))
        }
    }
}

inline fun <reified T : Any> T.load(tag: String = "tag") {
    (T::class.java.annotations.find { it is Fudi } as? Fudi)?.let {
        var obj = SharePreferenced.load(T::class.java, tag)
        var empty = T::class.java.constructors[0].newInstance() as T
        for (a in T::class.java.declaredFields) {
            a.isAccessible = true
            a.set(this, a.get(obj ?: empty))
        }
    }
}

inline fun <reified T : Any> T.clear() =
        (T::class.java.annotations.find { it is Fudi } as? Fudi)?.let {
            SharePreferenced.save(null, T::class.java)
        }

inline fun <reified T : Any> T.save() =
        (T::class.java.annotations.find { it is Fudi } as? Fudi)?.let {
            SharePreferenced.save(this, T::class.java)
        }

inline fun <reified T : Any> T.saveTag(tag: String = "tag") =
        (T::class.java.annotations.find { it is Fudi } as? Fudi)?.let {
            SharePreferenced.save(this, T::class.java, tag)
        }