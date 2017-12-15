package com.gonzalezrodero.exchangeRates;

import com.gonzalezrodero.CryptoCurrencyPrices;
import com.gonzalezrodero.interfaces.Observer;

public class ExchangeRatesLTC implements Observer {
    private String LTCtoEUR;

    public ExchangeRatesLTC(CryptoCurrencyPrices ccp){
        ccp.registerObserver(this);
    }

    public double getLTCExchangeRates(){
        return Double.parseDouble(LTCtoEUR);
    }

    @Override
    public void update(ExchangeRates er) {
        LTCtoEUR = er.getLTCtoEUR();
        System.out.println(LTCtoEUR);
    }
}
