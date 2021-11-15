package ee552.investment.portfolio;

import java.util.ArrayList;

public class Portfolio {
    ArrayList<Stock> stocks = new ArrayList<Stock>();
    ArrayList<Float> positions = new ArrayList<Float>();
    ArrayList<Float> originalPrices = new ArrayList<Float>();

    public void updateStocks(ArrayList<Stock> stocks) {
        this.stocks = stocks;
    }

    public void sellPosition(Stock stock, float position, float originalPrice) {
        // need to implement the conversion to cash
        for (int i = 0; i < stocks.size(); i++) {
            if (this.stocks.get(i) == stock) {
                if (this.positions.get(i) > position) {
                    // to implement later
                    continue;
                } else if (this.positions.get(i) == position) {
                    this.positions.remove(i);
                    this.stocks.remove(i);
                    this.originalPrices.remove(i);
                } else {
                    this.positions.set(i, this.positions.get(i) - position);
                    this.originalPrices.set(i, this.originalPrices.get(i) - originalPrice);
                }
                break;
            }
        }
    }

    public void addPosition(Stock stock, float position, float originalPrice) {
        boolean added = false;
        for (int i = 0; i < stocks.size(); i++) {
            if (this.stocks.get(i) == stock) {
                this.positions.set(i, this.positions.get(i) + position);
                this.originalPrices.set(i, this.originalPrices.get(i) + originalPrice);
                added = true;
                break;
            }
        }
        if (!added) {
            this.stocks.add(stock);
            this.positions.add(position);
            this.originalPrices.add(originalPrice);
        }
    }
}