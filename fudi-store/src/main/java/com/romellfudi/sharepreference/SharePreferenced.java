package com.romellfudi.sharepreference;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Tool class SharedPreferences
 *
 * @version 1.0.a
 * @autor Romell Dominguez
 * @date 3/11/16
 */
public class SharePreferenced {

    private static Context mContext;
    private static String SHARED_PREFERENCE_SESSION;

    public static void init(Context context) {
        mContext = context;
        SHARED_PREFERENCE_SESSION = mContext.getPackageName() + ".SHARED_PREFERENCE_SESSION";
    }

    private static void setSharedPreference(Context context, String key, String value) {
        if (value == null)
            value = "";
        SharedPreferences sharedPref = context.getSharedPreferences(
                SHARED_PREFERENCE_SESSION, Context.MODE_PRIVATE);
        sharedPref.edit().putString(key, value);
        sharedPref.edit().commit();
    }

    private static String getSharedPreference(Context context, String value) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                SHARED_PREFERENCE_SESSION, Context.MODE_PRIVATE);
        return sharedPref.getString(value, "");
    }

    public static void save(Object object, Class cls) {
        String json = "";
        try {
            json = JsonUtil.toJson(object, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setSharedPreference(mContext, cls.getSimpleName(), json);
    }

    public static <T> T load(Class<T> cls) {
        String json = getSharedPreference(mContext, cls.getSimpleName());
        Object object = null;
        if (!json.equals(""))
            object = JsonUtil.fromJson(json, cls);
        return cls.cast(object);
    }

    public static void save(Object object, Class cls, String TAG) {
        String json = "";
        try {
            json = JsonUtil.toJson(object, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setSharedPreference(mContext, cls.getSimpleName() + TAG, json);
    }

    public static <T> T load(Class<T> cls, String tag) {
        String json = getSharedPreference(mContext, cls.getSimpleName() + tag);
        Object object = null;
        if (!json.equals(""))
            object = JsonUtil.fromJson(json, cls);
        return cls.cast(object);
    }


}
