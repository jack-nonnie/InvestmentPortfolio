package com.app.main.model;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class Position {

    private String ticker;

    private String amount;

    private String initialPrice;

    public Position() {

    }

    public Position(String ticker, String amount, String initialPrice) {
        this.ticker = ticker;
        this.amount = amount;
        this.initialPrice = initialPrice;
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

    public void setInitialPrice(String initialPrice) {
        this.initialPrice = initialPrice;
    }

    public void addTradeToPosition(String amount, String price) {
        float amt = Float.parseFloat(amount) + Float.parseFloat(this.amount);
        this.amount = String.valueOf(amt);
        double p = Double.parseDouble(price) + Double.parseDouble(this.initialPrice);
        this.initialPrice = String.valueOf(p);
    }

    public String getCurrentPrice() {
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
        
        /*try {
            HttpResponse<String> response = client.send(request, handler);
            System.out.println("HEREEEEEEEEE");
            System.out.println(response.body());
            ObjectMapper mapper = new ObjectMapper();
            return "B";
        } catch (IOException e) {
            e.printStackTrace();
            return "A";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "A";
        }*/

    }

    @Override
    public String toString() {
        return "";
    }

}
