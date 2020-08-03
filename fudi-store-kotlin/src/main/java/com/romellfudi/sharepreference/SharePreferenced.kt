package com.romellfudi.sharepreference

import android.content.Context

/**
 * Tool class SharedPreferences
 *
 * @version 1.0.a
 * @autor Romell Dominguez
 * @date 3/11/16
 */
object SharePreferenced {

    private var mContext: Context? = null
    private var SHARED_PREFERENCE_SESSION: String? = null

    fun init(context: Context) {
        mContext = context
        SHARED_PREFERENCE_SESSION = mContext!!.packageName + ".SHARED_PREFERENCE_SESSION"
    }

    private fun setSharedPreference(context: Context?, key: String, value: String?) {
        var value = value
        if (value == null)
            value = ""
        val sharedPref = context!!.getSharedPreferences(
                SHARED_PREFERENCE_SESSION, Context.MODE_PRIVATE)
        sharedPref.edit().putString(key, value)
        sharedPref.edit().commit()
    }

    private fun getSharedPreference(context: Context, value: String): String? {
        val sharedPref = context.getSharedPreferences(
                SHARED_PREFERENCE_SESSION, Context.MODE_PRIVATE)
        return sharedPref.getString(value, "")
    }

    fun save(any: Any, cls: Class<*>) {
        var json = ""
        try {
            json = JsonUtil.toJson(any, false)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        setSharedPreference(mContext, cls.simpleName, json)
    }

    fun <T> load(cls: Class<T>): T? {
        val json = getSharedPreference(mContext!!, cls.simpleName)
        var any: Any? = null
        if (json != "")
            any = JsonUtil.fromJson(json!!, cls)
        return cls.cast(any)
    }

    fun save(any: Any, cls: Class<*>, TAG: String) {
        var json = ""
        try {
            json = JsonUtil.toJson(any, false)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        setSharedPreference(mContext, cls.simpleName + TAG, json)
    }

    fun <T> load(cls: Class<T>, tag: String): T? {
        val json = getSharedPreference(mContext!!, cls.simpleName + tag)
        var any: Any? = null
        if (json != "")
            any = JsonUtil.fromJson(json!!, cls)
        return cls.cast(any)
    }


}
