package com.gonzalezrodero.ExchangeRates;

import com.gonzalezrodero.CryptoCurrencyPrices;
import com.gonzalezrodero.interfaces.Observer;

public class ExchangeRate implements Observer {
    public String BTCtoEUR;
    public String BTCtoGBP;
    public String ETHtoEUR;
    public String ETHtoGBP;
    public String LTCtoEUR;
    public String LTCtoGBP;

    public ExchangeRate(CryptoCurrencyPrices ccp){
        ccp.registerObserver(this);
    }

    @Override
    public void update(ExchangeRate er) {
        BTCtoEUR = er.BTCtoEUR;
        BTCtoGBP = er.BTCtoGBP;
        ETHtoEUR = er.ETHtoEUR;
        ETHtoGBP = er.ETHtoGBP;
        LTCtoEUR = er.LTCtoEUR;
        LTCtoGBP = er.LTCtoGBP;
    }
}
