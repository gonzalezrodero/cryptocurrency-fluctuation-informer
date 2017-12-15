package com.gonzalezrodero;

import com.gonzalezrodero.apiResponses.PriceResponse;
import com.gonzalezrodero.constants.APICallType;
import com.gonzalezrodero.exchangeRates.ExchangeRatesBTC;
import com.gonzalezrodero.exchangeRates.ExchangeRatesETH;
import com.gonzalezrodero.exchangeRates.ExchangeRatesLTC;
import com.gonzalezrodero.utilities.ConversionUtilities;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;

public class Main {
    private static CryptoCurrencyPrices ccp = new CryptoCurrencyPrices();
    private static ExchangeRatesBTC ratesBTC = new ExchangeRatesBTC(ccp);
    private static ExchangeRatesETH ratesETH = new ExchangeRatesETH(ccp);
    private static ExchangeRatesLTC ratesLTC = new ExchangeRatesLTC(ccp);

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new RecurrentAPICall(ratesBTC, ratesETH, ratesLTC), 0, 10000);
    }
}
