package com.gonzalezrodero;

import com.gonzalezrodero.exchangeRates.ExchangeRates;
import com.gonzalezrodero.interfaces.Observer;
import com.gonzalezrodero.interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class CryptoCurrencyPrices implements Subject {
    private ExchangeRates exchangeRates = new ExchangeRates();

    public void getLatestExchangeRates(String BTCtoEUR, String ETHtoEUR, String LTCtoEUR){
        exchangeRates.setBTCtoEUR(BTCtoEUR);
        exchangeRates.setETHtoEUR(ETHtoEUR);
        exchangeRates.setLTCtoEUR(LTCtoEUR);
        informCurrentExchangeRates();
    }

    // Observer design pattern

    private List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(exchangeRates);
        }
    }

    private void informCurrentExchangeRates() {
        notifyObservers();
    }
}