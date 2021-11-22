package com.app.main.model;

public class Stock {
  private String ticker;
  private String openPrice;
  private String highPrice;
  private String lowPrice;
  private String currentPrice;
  private String previousClosingPrice;

  public Stock(String ticker, String open, String high, String low, String current, String prev) {
    this.ticker = ticker;
    this.openPrice = open;
    this.highPrice = high;
    this.lowPrice = low;
    this.currentPrice = current;
    this.previousClosingPrice = prev;
  }

  public void setPreviousClosingPrice(String prev) {
    this.previousClosingPrice = prev;
  }

  public void setCurrent(String current) {
    this.currentPrice = current;
  }

  public void setLow(String low) {
    this.lowPrice = low;
  }

  public void setHigh(String high) {
    this.highPrice = high;
  }

  public void setOpen(String open) {
    this.openPrice = open;
  }

  public void setPrices(String open, String high, String low, String current, String prev) {
    this.openPrice = open;
    this.highPrice = high;
    this.lowPrice = low;
    this.currentPrice = current;
    this.previousClosingPrice = prev;
  }

  public String getTicker() {
    return this.ticker;
  }

  public float getOpenPrice() {
    return Float.parseFloat(this.openPrice);
  }

  public float getHighPrice() {
    return Float.parseFloat(this.highPrice);
  }

  public float getLowPrice() {
    return Float.parseFloat(this.lowPrice);
  }

  public float getCurrentPrice() {
    return Float.parseFloat(this.currentPrice);
  }

  public float getPreviousClosingPrice() {
    return Float.parseFloat(this.previousClosingPrice);
  }

  @Override
  public String toString() {
    return "Opening Price: " + openPrice + " Daily High Price: " + this.highPrice + " Daily Low Price " + this.lowPrice
        + " Current Price: " + this.currentPrice + " Yesterday Closing Price: " + this.previousClosingPrice;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Stock) {
      Stock o = (Stock) other;
      if (this.ticker.equals(o.ticker)) {
        return true;
      }
    }
    return false;
  }
}