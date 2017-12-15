package com.gonzalezrodero.interfaces;

import com.gonzalezrodero.exchangeRates.ExchangeRates;

public interface Observer {
    void update(ExchangeRates er);
}
