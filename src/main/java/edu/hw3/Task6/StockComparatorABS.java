package edu.hw3.Task6;

import java.util.Comparator;

public class StockComparatorABS implements Comparator<Stock> {
    @Override
    public int compare(Stock stock1, Stock stock2) {
        return Integer.compare(stock2.price(), stock1.price());
    }
}
