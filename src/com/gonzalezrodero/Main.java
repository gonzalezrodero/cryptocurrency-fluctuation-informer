package com.gonzalezrodero;

import com.gonzalezrodero.apiResponses.PriceResponseEUR;
import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder("https://min-api.cryptocompare.com/data");
        sb.append("/price?");
        sb.append("fsym=BTC&tsyms=EUR,GBP");
        URL url = new URL(sb.toString());

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        String s = convertStreamToString(conn.getInputStream());

        PriceResponseEUR p = getEURPriceObject(PriceResponseEUR.class, s);

        System.out.println("ETH is " + p.getPriceEUR() + " EUR");
        System.out.println("ETH is " + p.getPriceGBP() + " GBP");

        conn.disconnect();
    }

    private static <T> T getEURPriceObject(Class<T> responseType, String jsonResponse){
        Gson gson = new Gson();
        return gson.fromJson(jsonResponse, responseType);
    }

    private static String convertStreamToString(InputStream is) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString("UTF-8");
    }
}
