package edu.hw3.Task6;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Market implements StockMarket {
    PriorityQueue<Stock> queue;
    Comparator<Stock> comparator = new StockComparatorABS();

    public Market() {
        queue = new PriorityQueue<>(comparator);
    }

    @Override
    public void add(Stock stock) {
        queue.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        queue.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return queue.element();
    }
}
