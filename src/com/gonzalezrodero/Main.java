package com.gonzalezrodero;

import com.gonzalezrodero.exchangeRates.ExchangeRatesBTC;
import com.gonzalezrodero.exchangeRates.ExchangeRatesETH;
import com.gonzalezrodero.exchangeRates.ExchangeRatesLTC;

import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        CryptoCurrencyPrices ccp = new CryptoCurrencyPrices();
        ExchangeRatesBTC ratesBTC = new ExchangeRatesBTC(ccp);
        ExchangeRatesETH ratesETH = new ExchangeRatesETH(ccp);
        ExchangeRatesLTC ratesLTC = new ExchangeRatesLTC(ccp);
        new Timer().schedule(new Service(ccp), 0, 5000);
    }
}
