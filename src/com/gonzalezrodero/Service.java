package com.gonzalezrodero;

import com.gonzalezrodero.apiResponses.PriceResponse;
import com.gonzalezrodero.constants.ApiUrlType;
import com.gonzalezrodero.utilities.ConversionUtilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.TimerTask;

public class Service extends TimerTask {
    private CryptoCurrencyPrices ccp;

    Service(CryptoCurrencyPrices ccp){
        this.ccp = ccp;
    }

    public void run() {
        try {
            getLatestExchangeRatesFromApi();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getLatestExchangeRatesFromApi() throws IOException {
        ccp.getLatestExchangeRates(
                getFromApi(ApiUrlType.BTCtoEUR).getlatestPrice(),
                getFromApi(ApiUrlType.ETHtoEUR).getlatestPrice(),
                getFromApi(ApiUrlType.LTCtoEUR).getlatestPrice()
        );
    }

    private PriceResponse getFromApi(URL apiCall) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) apiCall.openConnection();
        conn.setRequestMethod("GET");
        String jsonString = ConversionUtilities.convertStreamToString(conn.getInputStream());
        conn.disconnect();
        return ConversionUtilities.convertJsonStringToObject(PriceResponse.class, jsonString);
    }
}
