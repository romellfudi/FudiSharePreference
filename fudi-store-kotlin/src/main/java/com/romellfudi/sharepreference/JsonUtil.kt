package com.romellfudi.sharepreference

import android.content.Context
import com.google.gson.Gson
import org.codehaus.jackson.JsonFactory
import org.codehaus.jackson.map.ObjectMapper
import org.reflections.util.Utils
import java.io.*
import java.lang.reflect.Type

/**
 * Tools class Factory
 *
 * @version 1.0.a
 * @autor Romell Dominguez
 * @date 3/11/16
 */
class JsonUtil {

    companion object {
        @Throws(Exception::class)
        internal fun toJson(var0: Any, var1: Boolean): String {
            val jsonFactory = JsonFactory()
            val objMapper = ObjectMapper()

            val var2 = StringWriter()
            val var3 = jsonFactory.createJsonGenerator(var2)
            if (var1) {
                var3.useDefaultPrettyPrinter()
            }

            objMapper.writeValue(var3, var0)
            return var2.toString()
        }

        internal fun <T> fromJson(name: String, classes: Class<T>): Any? {
            val objMapper = ObjectMapper()
            try {
                return objMapper.readValue(name, classes)
            } catch (exc: Exception) {
                exc.printStackTrace()
                return null
            }

        }

        internal fun <T> getObjecToFile(context: Context, nameFile: String, typeOf: Type): T? {
            val json = getStringToAssets(context, nameFile)
            if (!Utils.isEmpty(nameFile)) {
                val gson = Gson()
                return gson.fromJson<T>(json, typeOf)
            } else
                return null
        }

        internal fun getStringToAssets(context: Context, nameFile: String): String? {
            val buf = StringBuilder()
            var `is`: InputStream? = null
            var `in`: BufferedReader? = null
            var json: String? = null
            try {
                `is` = context.assets.open("json/$nameFile")
                `in` = BufferedReader(InputStreamReader(`is`, "UTF-8"))
                var str: String? = null
                str = `in`.readLine()
                while (str != null) {
                    buf.append(str)
                    str = `in`.readLine()
                }
                `in`.close()
                json = buf.toString()
            } catch (e: IOException) {
                e.printStackTrace()
            }

            return json
        }
    }
}
