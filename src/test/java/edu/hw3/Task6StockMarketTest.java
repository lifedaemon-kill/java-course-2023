package edu.hw3;

import edu.hw3.Task6.Market;
import edu.hw3.Task6.Stock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6StockMarketTest {
    @Test
    @DisplayName("400 600 300")
    void test1() {

        Stock maxStock;

        Market market = new Market();

        market.add(new Stock(0, 400, "Google"));

        maxStock = new Stock(1, 600, "Microsoft");

        market.add(maxStock);
        market.add(new Stock(2, 300, "Firefox"));

        assertThat(market.mostValuableStock()).isEqualTo(maxStock);
    }

    @Test
    @DisplayName("200 300 400")
    void test2() {
        Stock maxStock;

        Market market = new Market();

        market.add(new Stock(0, 200, "Google"));
        market.add(new Stock(1, 300, "Firefox"));

        maxStock = new Stock(2, 400, "Microsoft");
        market.add(maxStock);

        assertThat(market.mostValuableStock()).isEqualTo(maxStock);
    }

    @Test
    @DisplayName("400 300 200")
    void test3() {
        Stock maxStock;
        Market market = new Market();

        maxStock = new Stock(0, 400, "Microsoft");

        market.add(maxStock);
        market.add(new Stock(1, 300, "Firefox"));
        market.add(new Stock(2, 200, "Google"));

        assertThat(market.mostValuableStock()).isEqualTo(maxStock);
    }

    @Test
    @DisplayName("300 200 -> 200 -> 200 400")
    void test4() {
        Stock maxStock;

        Market market = new Market();

        maxStock = new Stock(0, 400, "Microsoft");

        market.add(maxStock);
        market.add(new Stock(1, 300, "Firefox"));
        market.add(new Stock(2, 200, "Google"));

        market.remove(new Stock(1, 300, "Firefox"));
        market.add(maxStock);

        assertThat(market.mostValuableStock()).isEqualTo(maxStock);
    }
}
