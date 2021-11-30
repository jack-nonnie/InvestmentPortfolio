package com.app.main.model;

import java.util.ArrayList;

public class Portfolio {
    private ArrayList<Stock_api> stocks;
    private ArrayList<Float> positions;
    private ArrayList<Float> originalPrices;

    public Portfolio() {
        this.stocks = new ArrayList<Stock_api>();
        this.positions = new ArrayList<Float>();
        this.originalPrices = new ArrayList<Float>();
    }

    public Portfolio(ArrayList<Stock_api> stocks, ArrayList<Float> positions, ArrayList<Float> originalPrices) {
        this.stocks = stocks;
        this.positions = positions;
        this.originalPrices = originalPrices;
    }

    public float getTotalValueOfStocks() {
        float tot = 0;
        for (int i = 0; i < stocks.size(); i++) {
            //tot += this.positions.get(i) * this.stocks.get(i).getC();
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
        return (float) 0;
        //return this.positions.get(index) * Float.this.stocks.get(index).getC();
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

    public Stock_api getStockByIndex(int index) {
        if (index >= this.stocks.size() || index < 0) {
            return null;
        }
        return this.stocks.get(index);
    }

    public void updateStocks(ArrayList<Stock_api> stocks) {
        this.stocks = stocks;
    }

    public void sellPosition(Stock_api stock, float position, float originalPrice) {
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
    //{c=160.24, d=3.43, dp=2.1874, h=161.19, l=158.7901, o=159.37, pc=156.81, t=1638219604}

    public void addPosition(Stock_api stock, float position, float originalPrice) {
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