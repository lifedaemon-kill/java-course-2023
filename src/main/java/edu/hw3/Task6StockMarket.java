package edu.hw3;

import java.util.Comparator;
import java.util.PriorityQueue;

final class Task6StockMarket {
    private Task6StockMarket() {
    }

    private interface StockMarket {
        void add(Stock stock);

        void remove(Stock stock);

        Stock mostValuableStock();
    }

    public record Stock(int id, int price, String company) {
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof Stock stock)) {
                return false;
            }

            return this.toString().equals(stock.toString());
        }

        @Override
        public int hashCode() {
            return this.toString().hashCode();
        }

        public static class StockComparatorABS implements Comparator<Stock> {
            @Override
            public int compare(Stock stock1, Stock stock2) {
                return Integer.compare(stock2.price, stock1.price);
            }
        }
    }

    public static class Market implements StockMarket {
        PriorityQueue<Stock> queue;
        Comparator<Stock> comparator = new Stock.StockComparatorABS();

        Market() {
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
}
