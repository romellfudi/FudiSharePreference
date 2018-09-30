package com.romellfudi.sharepreference;

import android.content.Context;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

/**
 * Clase utilitaria para la transformación de objetos a una estructura json
 *
 * @version 1.0.a
 * @autor Romell Domínguez
 * @date 3/11/17
 */
public class JsonUtil {

    protected static String toJson(Object var0, boolean var1) throws Exception {
        JsonFactory jsonFactory = new JsonFactory();
        ObjectMapper objMapper = new ObjectMapper();

        StringWriter var2 = new StringWriter();
        JsonGenerator var3 = jsonFactory.createJsonGenerator(var2);
        if (var1) {
            var3.useDefaultPrettyPrinter();
        }

        objMapper.writeValue(var3, var0);
        return var2.toString();
    }

    protected static <T> Object fromJson(String name, Class<T> classes) {
        ObjectMapper objMapper = new ObjectMapper();
        try {
            return objMapper.readValue(name, classes);
        } catch (Exception exc) {
            exc.printStackTrace();
            return null;
        }
    }

//    protected static <T> T getObjecToFile(Context context, String nameFile, Type typeOf) {
//        String json = getStringToAssets(context, nameFile);
//        if (!Utils.isEmpty(nameFile)) {
//            Gson gson = new Gson();
//            return gson.fromJson(json, typeOf);
//        } else
//            return null;
//    }

    protected static String getStringToAssets(Context context, String nameFile) {
        StringBuilder buf = new StringBuilder();
        InputStream is = null;
        BufferedReader in = null;
        String json = null;
        try {
            is = context.getAssets().open("json/" + nameFile);
            in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String str = null;
            while ((str = in.readLine()) != null) {
                buf.append(str);
            }
            in.close();
            json = buf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

}
