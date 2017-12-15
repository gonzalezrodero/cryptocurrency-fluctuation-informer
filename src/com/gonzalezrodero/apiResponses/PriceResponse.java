package com.gonzalezrodero.apiResponses;

public class PriceResponse {
    // last 24 hours price high
    private String high;
    // last price
    private String last;
    // unix timestamp date and time
    private String timestamp;
    // highest buy order
    private String bid;
    // last 24 hours volume weighted average price --> https://en.wikipedia.org/wiki/Volume-weighted_average_price
    private String vwap;
    // last 24 hours volume
    private String volume;
    // last 24 hours price low
    private String low;
    // lowest sell order
    private String ask;
    // first price of the day
    private String open;

    public String getlatestPrice() {
//        double vwap = Double.parseDouble(this.vwap);
//        // 0.022 is a factor to get as close as possible to the Revolut value
//        return vwap - vwap*0.019;
        return last;
    }
}
