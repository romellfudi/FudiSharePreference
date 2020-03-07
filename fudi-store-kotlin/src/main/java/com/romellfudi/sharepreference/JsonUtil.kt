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
            return try {
                objMapper.readValue(name, classes)
            } catch (exc: Exception) {
                exc.printStackTrace()
                null
            }

        }

        internal fun <T> getObjecToFile(context: Context, nameFile: String, typeOf: Type): T? {
            val json = getStringToAssets(context, nameFile)
            return if (!Utils.isEmpty(nameFile)) {
                Gson().fromJson<T>(json, typeOf)
            } else
                null
        }

        private fun getStringToAssets(context: Context, nameFile: String): String? {
            val buf = StringBuilder()
            var inputStream: InputStream?
            var bufferedReader: BufferedReader?
            var json: String? = null
            try {
                inputStream = context.assets.open("json/$nameFile")
                bufferedReader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
                var str: String?
                str = bufferedReader.readLine()
                while (str != null) {
                    buf.append(str)
                    str = bufferedReader.readLine()
                }
                bufferedReader.close()
                json = buf.toString()
            } catch (e: IOException) {
                e.printStackTrace()
            }

            return json
        }
    }
}
