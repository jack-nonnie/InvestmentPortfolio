package com.app.main.model;

public class Position {

    private String ticker;

    private String amount;

    private String initialPrice;

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

}
