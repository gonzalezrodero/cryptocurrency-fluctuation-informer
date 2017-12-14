package com.gonzalezrodero;

import com.gonzalezrodero.ExchangeRates.ExchangeRate;
import com.gonzalezrodero.interfaces.Observer;
import com.gonzalezrodero.interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class CryptoCurrencyPrices implements Subject {
    private ExchangeRate exchangeRate;

    private void setExchangeRate(ExchangeRate er){
        exchangeRate = er;
    }

    // Observer design pattern applied

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
            observer.update(exchangeRate);
        }
    }
}