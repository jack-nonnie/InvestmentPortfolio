package ee552.investment.portfolio;

public class Stock {
  public String ticker;
  public String openPrice;
  public String highPrice;
  public String lowPrice;
  public String currentPrice;
  public String previousClosingPrice;

  public Stock(String ticker, String open, String high, String low, String current, String prev) {
    this.ticker = ticker;
    this.openPrice = open;
    this.highPrice = high;
    this.lowPrice = low;
    this.currentPrice = current;
    this.previousClosingPrice = prev;
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