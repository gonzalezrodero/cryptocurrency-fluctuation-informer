package com.gonzalezrodero.constants;

import java.net.MalformedURLException;
import java.net.URL;

public class ApiUrlType {
    public static URL BTCtoEUR;
    public static URL ETHtoEUR;
    public static URL LTCtoEUR;

    static {
        try {
            BTCtoEUR = new URL("https://www.bitstamp.net/api/v2/ticker_hour/btceur/");
            ETHtoEUR = new URL("https://www.bitstamp.net/api/v2/ticker_hour/etheur/");
            LTCtoEUR = new URL("https://www.bitstamp.net/api/v2/ticker_hour/ltceur/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
