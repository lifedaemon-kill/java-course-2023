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
    @DisplayName("max value in the end")
    void test2() {
        // Arrange
        Market market = new Market();
        market.add(new Stock(0, 200, "Google"));
        market.add(new Stock(1, 300, "Firefox"));

        Stock expectedMax = new Stock(2, 400, "Microsoft");
        market.add(expectedMax);

        // Act
        Stock maxStock = market.mostValuableStock();

        // Assert
        assertThat(maxStock).isEqualTo(maxStock);
    }

    @Test
    @DisplayName("max value is first")
    void test3() {
        // Arrange
        Stock expectedMax;
        Market market = new Market();

        expectedMax = new Stock(0, 400, "Microsoft");

        market.add(expectedMax);
        market.add(new Stock(1, 300, "Firefox"));
        market.add(new Stock(2, 200, "Google"));

        // Act
        Stock maxStock = market.mostValuableStock();

        // Assert
        assertThat(maxStock).isEqualTo(expectedMax);
    }

    @Test
    @DisplayName("delete max from list and add new greater max")
    void test4() {
        // Arrange
        Stock expectedMax;

        Market market = new Market();

        expectedMax = new Stock(0, 400, "Microsoft");

        market.add(expectedMax);
        market.add(new Stock(1, 300, "Firefox"));
        market.add(new Stock(2, 200, "Google"));

        market.remove(new Stock(1, 300, "Firefox"));
        market.add(expectedMax);

        // Act
        Stock maxStock = market.mostValuableStock();

        // Assert
        assertThat(maxStock).isEqualTo(expectedMax);
    }

    @Test
    @DisplayName("empty list")
    void test5() {
        // Arrange
        Market market = new Market();
        // Act
        Stock maxStock = market.mostValuableStock();
        // Assert
        assertThat(maxStock).isNull();
    }
}
