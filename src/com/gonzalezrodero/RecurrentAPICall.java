package com.gonzalezrodero;

import com.gonzalezrodero.apiResponses.PriceResponse;
import com.gonzalezrodero.constants.APICallType;
import com.gonzalezrodero.exchangeRates.ExchangeRates;
import com.gonzalezrodero.exchangeRates.ExchangeRatesBTC;
import com.gonzalezrodero.exchangeRates.ExchangeRatesETH;
import com.gonzalezrodero.exchangeRates.ExchangeRatesLTC;
import com.gonzalezrodero.utilities.ConversionUtilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.TimerTask;

public class RecurrentAPICall extends TimerTask {
    ExchangeRatesBTC erBTC;
    ExchangeRatesETH erETH;
    ExchangeRatesLTC erLTC;

    RecurrentAPICall(ExchangeRatesBTC erBTC, ExchangeRatesETH erETH, ExchangeRatesLTC erLTC){
        this.erBTC = erBTC;
        this.erETH = erETH;
        this.erLTC = erLTC;
    }

    public void run() {
        try {
            URL BTCtoEURer = new URL(APICallType.BTCtoEUR);
            URL ETHtoEURer = new URL(APICallType.ETHtoEUR);
            URL LTCtoEURer = new URL(APICallType.LTCtoEUR);

            HttpURLConnection conn = (HttpURLConnection) BTCtoEURer.openConnection();
            conn.setRequestMethod("GET");
            String s = ConversionUtilities.convertStreamToString(conn.getInputStream());
            PriceResponse p = ConversionUtilities.convertJsonStringToObject(PriceResponse.class, s);
            System.out.println(p.getPrice());

            conn = (HttpURLConnection) ETHtoEURer.openConnection();
            conn.setRequestMethod("GET");
            s = ConversionUtilities.convertStreamToString(conn.getInputStream());
            p = ConversionUtilities.convertJsonStringToObject(PriceResponse.class, s);
            System.out.println(p.getPrice());

            conn = (HttpURLConnection) LTCtoEURer.openConnection();
            conn.setRequestMethod("GET");
            s = ConversionUtilities.convertStreamToString(conn.getInputStream());
            p = ConversionUtilities.convertJsonStringToObject(PriceResponse.class, s);
            System.out.println(p.getPrice());

            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
