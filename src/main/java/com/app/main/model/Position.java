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

    public Position() {

    }

    public Position(String ticker, String amount, String initialPrice) {
        this.ticker = ticker;
        this.amount = amount;
        this.initialPrice = initialPrice;
        this.currentPrice = this.setCurrentPrice();
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
        return String.valueOf(100 *(Double.parseDouble(val) - Double.parseDouble(this.initialPrice))/Double.parseDouble(this.initialPrice)) + "%";
    }
    public String setCurrentPrice() {
        //System.setProperty("apiKey", "c67b6uaad3iai8rarkgg");
        final String apiKey = System.getProperty("apiKey");
        String str = "https://finnhub.io/api/v1/quote?symbol=" + this.ticker + "&token=" + apiKey;
        try { 
            URI uri = new URI(str);
            RestTemplate restTemplate = new RestTemplate();
            Map s = restTemplate.getForObject(uri, Map.class);
            return s.get("c").toString();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            return "0";
        }
        
        

    }

    @Override
    public String toString() {
        return "";
    }

}
