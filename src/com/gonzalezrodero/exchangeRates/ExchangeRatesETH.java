package com.gonzalezrodero.exchangeRates;

import com.gonzalezrodero.CryptoCurrencyPrices;
import com.gonzalezrodero.interfaces.Observer;

public class ExchangeRatesETH implements Observer {
    private String ETHtoEUR;

    public ExchangeRatesETH(CryptoCurrencyPrices ccp){
        ccp.registerObserver(this);
    }

    public double getETHExchangeRates(){
        return Double.parseDouble(ETHtoEUR);
    }

    @Override
    public void update(ExchangeRates er) {
        ETHtoEUR = er.getETHtoEUR();
        System.out.println(ETHtoEUR);
    }
}
