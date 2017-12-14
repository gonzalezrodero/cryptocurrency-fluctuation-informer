package com.gonzalezrodero.interfaces;

import com.gonzalezrodero.ExchangeRates.ExchangeRate;

public interface Observer {
    void update(ExchangeRate er);
}
