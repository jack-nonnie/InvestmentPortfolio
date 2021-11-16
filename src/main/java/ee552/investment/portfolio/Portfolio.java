package ee552.investment.portfolio;

import java.util.ArrayList;

public class Portfolio {
    private ArrayList<Stock> stocks;
    private ArrayList<Float> positions;
    private ArrayList<Float> originalPrices;

    public Portfolio() {
        this.stocks = new ArrayList<Stock>();
        this.positions = new ArrayList<Float>();
        this.originalPrices = new ArrayList<Float>();
    }

    public Portfolio(ArrayList<Stock> stocks, ArrayList<Float> positions, ArrayList<Float> originalPrices) {
        this.stocks = stocks;
        this.positions = positions;
        this.originalPrices = originalPrices;
    }

    public float getTotalValueOfStocks() {
        float tot = 0;
        for (int i = 0; i < stocks.size(); i++) {
            tot += this.positions.get(i) * this.stocks.get(i).getCurrentPrice();
        }
        return tot;
    }

    public float getPercentChangeByIndex(int index) {
        float currentValue = this.getCurrentValueOfAPositionByIndex(index);
        float originalPrice = this.originalPrices.get(index);
        return (currentValue - originalPrice) / originalPrice;
    }

    public int getSize() {
        return this.stocks.size();
    }

    public float getCurrentValueOfAPositionByIndex(int index) {
        if (index >= this.stocks.size() || index < 0) {
            return -1;
        }
        return this.positions.get(index) * this.stocks.get(index).getCurrentPrice();
    }

    public float getOriginalPriceByIndex(int index) {
        if (index >= this.originalPrices.size() || index < 0) {
            return -1;
        }
        return this.originalPrices.get(index);
    }

    public float getPostionByIndex(int index) {
        if (index >= this.positions.size() || index < 0) {
            return -1;
        }
        return this.positions.get(index);
    }

    public Stock getStockByIndex(int index) {
        if (index >= this.stocks.size() || index < 0) {
            return null;
        }
        return this.stocks.get(index);
    }

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