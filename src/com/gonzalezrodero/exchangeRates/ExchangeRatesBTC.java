package com.gonzalezrodero.exchangeRates;

import com.gonzalezrodero.CryptoCurrencyPrices;
import com.gonzalezrodero.interfaces.Observer;

public class ExchangeRatesBTC implements Observer {
    private String BTCtoEUR;

    public ExchangeRatesBTC(CryptoCurrencyPrices ccp){
        ccp.registerObserver(this);
    }

    public ExchangeRatesBTC getBTCExchangeRates(){
        return this;
    }

    @Override
    public void update(ExchangeRates er) {
        BTCtoEUR = er.BTCtoEUR;
    }
}
