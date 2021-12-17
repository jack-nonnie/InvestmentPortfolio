package com.app.main.model;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class Position {

    private String ticker;

    private String amount;

    private String initialPrice;

    private String currentPrice;
    
    private String instrument;

    public Position() {

    }

    public Position(String ticker, String amount, String initialPrice, String instrument, String apiKey) {
        this.ticker = ticker;
        this.amount = amount;
        this.initialPrice = initialPrice;
        this.instrument = instrument;
        this.currentPrice = this.setCurrentPrice(apiKey);
    }

    public String getTicker() {
        return this.ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getInitialPrice() {
        return this.initialPrice;
    }
    public String getCurrentPrice(){
        return this.currentPrice;
    }

    public void setInitialPrice(String initialPrice) {
        this.initialPrice = initialPrice;
    }

    public String getInstrument(){
        return this.instrument;
    }

    public void setInstrument(String instrument){
        this.instrument = instrument;
    }

    public void addTradeToPosition(String amount, String price) {
        float amt = Float.parseFloat(amount) + Float.parseFloat(this.amount);
        this.amount = String.valueOf(amt);
        double p = Double.parseDouble(price) + Double.parseDouble(this.initialPrice);
        this.initialPrice = String.valueOf(p);
    }
    public String getValuation(){
        return String.valueOf(Double.parseDouble(this.currentPrice) * Double.parseDouble(this.amount));
    }
    public String getProfitLoss(){
        String val = this.getValuation();
        return String.format("%.2f",100 *(Double.parseDouble(val) - Double.parseDouble(this.initialPrice))/Double.parseDouble(this.initialPrice)) + "%";
    }
    public String setCurrentPriceStock(String apiKey) {
        
        String str = "https://finnhub.io/api/v1/quote?symbol=" + this.ticker + "&token=" + apiKey;
        try { 
            URI uri = new URI(str);
            RestTemplate restTemplate = new RestTemplate();
            Map s = restTemplate.getForObject(uri, Map.class);
            if(s == null){
                return "";
            }
            if(!s.containsKey("c")){
                return "";
            }
            return s.get("c").toString();
        } catch (URISyntaxException e) {
            return "0";
        }
    }

    public String setCurrentPriceCrypto(String apiKey){
        String str = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol=" + this.ticker + "&CMC_PRO_API_KEY=" + apiKey;
        URI uri;
        try {
            uri = new URI(str);
            RestTemplate coinRestTemplate = new RestTemplate();
            Map<String, Map<String, Map<String, Map<String, Map<String, Object>>>>> coinMap = coinRestTemplate.getForObject(uri, Map.class);
            if(coinMap == null){
                return "0";
            }
            if(coinMap.get("data") == null){
                return "0";
            }
            if(coinMap.get("data").get(this.ticker) == null){
                return "0";
            }
            if(coinMap.get("data").get(this.ticker).get("quote") == null){
                return "0";
            }
            if(coinMap.get("data").get(this.ticker).get("quote").get("USD") == null){
                return "0";
            }
            return coinMap.get("data").get(this.ticker).get("quote").get("USD").get("price").toString();
        } catch (URISyntaxException e) {
            return "0";
        }
    }

    public String setCurrentPriceCurr(String apiKey){
        String str = "https://web-services.oanda.com/rates/api/v1/rates/" + this.ticker + ".json?api_key=" + apiKey + "&quote=usd";
        URI uri;
        try {
            uri = new URI(str);
            RestTemplate currRestTemplate = new RestTemplate();
            Map<String, Map<String, Map<String, Object>>> currMap = currRestTemplate.getForObject(uri, Map.class);
            if(currMap == null){
                return "0";
            }
            return currMap.get("quotes").get("USD").get("ask").toString();
        } catch (URISyntaxException e) {
            return "0";
        }
    }

    public String setCurrentPrice(String apiKey){
        if(this.instrument.equals("stock")){
            return this.setCurrentPriceStock(apiKey);
        }
        else if(this.instrument.equals("curr")) {
            return this.setCurrentPriceCurr(apiKey);
        }
        else{
            return this.setCurrentPriceCrypto(apiKey);
        }
    }

    @Override
    public String toString() {
        return "";
    }

}
