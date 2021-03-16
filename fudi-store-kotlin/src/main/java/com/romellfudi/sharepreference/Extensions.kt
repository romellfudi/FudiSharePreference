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
    if (T::class.isData)
        (T::class.annotations.find { it is Fudi } as? Fudi)?.let {
            val obj = SharePreferenced.load(T::class.java)
            val empty = T::class.java.constructors
                    .first { it.parameterCount == 0 }.newInstance()
            T::class.java.declaredFields.forEach {
                it.isAccessible = true
                it.set(this,it.get(obj ?: empty))
            }
        }
}

@SuppressLint("NewApi")
inline fun <reified T : Any> T.load(tag: String = "tag") {
    if (T::class.isData)
        (T::class.annotations.find { it is Fudi } as? Fudi)?.let {
            val obj = SharePreferenced.load(T::class.java, tag)
            val empty = T::class.java.constructors
                    .first { it.parameterCount == 0 }.newInstance()
            T::class.java.declaredFields.forEach {
                it.isAccessible = true
                it.set(this,it.get(obj ?: empty))
            }
        }
}

inline fun <reified T : Any> T.clear() {
    if (T::class.isData)
        (T::class.annotations.find { it is Fudi } as? Fudi)?.let {
            SharePreferenced.save(null, T::class.java)
        }
}

inline fun <reified T : Any> T.save() {
    if (T::class.isData)
        (T::class.annotations.find { it is Fudi } as? Fudi)?.let {
            SharePreferenced.save(this, T::class.java)
        }
}

inline fun <reified T : Any> T.saveTag(tag: String = "tag") {
    if (T::class.isData)
        (T::class.annotations.find { it is Fudi } as? Fudi)?.let {
            SharePreferenced.save(this, T::class.java, tag)
        }
}