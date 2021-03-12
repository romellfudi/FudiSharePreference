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

    private lateinit var mContext: Context
    private var SESSION: String? = null

    fun init(context: Context) {
        mContext = context
        SESSION = mContext.packageName + ".SHARED_PREFERENCE_SESSION"
    }

    private fun setSharedPreference(context: Context, key: String, value: String?) =
            with(context.getSharedPreferences(
                    SESSION, Context.MODE_PRIVATE).edit()) {
                putString(key, value ?: "")
                commit()
            }

    private fun getSharedPreference(context: Context, value: String): String? =
            context.getSharedPreferences(
                    SESSION, Context.MODE_PRIVATE).let { it.getString(value, "") }

    fun save(any: Any?, cls: Class<*>) {
        setSharedPreference(mContext, cls.simpleName, JsonUtil.toJson(any, false))
    }

    fun <T> load(cls: Class<T>): T? = getSharedPreference(mContext, cls.simpleName)?.let {
        cls.cast(JsonUtil.fromJson(it, cls))
    }

    fun save(any: Any?, cls: Class<*>, tag: String) {
        setSharedPreference(mContext, cls.simpleName + tag, JsonUtil.toJson(any, false))
    }

    fun <T> load(cls: Class<T>, tag: String): T? =
            getSharedPreference(mContext, cls.simpleName + tag)?.let {
                cls.cast(JsonUtil.fromJson(it, cls))
            }

}
