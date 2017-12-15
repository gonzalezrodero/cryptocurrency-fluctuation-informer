package com.gonzalezrodero.utilities;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ConversionUtilities {
    public static <T> T convertJsonStringToObject(Class<T> responseType, String jsonResponse){
        Gson gson = new Gson();
        return gson.fromJson(jsonResponse, responseType);
    }

    public static String convertStreamToString(InputStream is) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString("UTF-8");
    }
}
