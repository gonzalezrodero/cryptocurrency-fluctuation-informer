package com.gonzalezrodero.exchangeRates;

import com.gonzalezrodero.CryptoCurrencyPrices;
import com.gonzalezrodero.interfaces.Observer;

public class ExchangeRatesBTC implements Observer {
    private String BTCtoEUR;

    public ExchangeRatesBTC(CryptoCurrencyPrices ccp){
        ccp.registerObserver(this);
    }

    public double getBTCExchangeRates(){
        return Double.parseDouble(BTCtoEUR);
    }

    @Override
    public void update(ExchangeRates er) {
        BTCtoEUR = er.getBTCtoEUR();
        System.out.println(BTCtoEUR);
    }
}
