package edu.hw2;

import edu.hw2.Task2.Rectangle;
import edu.hw2.Task2.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2SquareRectangleTest {
    static Arguments[] rectangles() {
        return new Arguments[] {
            Arguments.of(new Rectangle()),
            Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        rect = rect.setWidth(20).setHeight(10);
        assertThat(rect.area()).isEqualTo(200.0);

        Rectangle sqr = new Square();
        sqr = sqr.setWidth(20);
        assertThat(sqr.area()).isEqualTo(400.0);

    }

    @Test
    @DisplayName("Площадь квадрата, Default constructor")
    void squareAreaDefaultW() {
        Rectangle sqr = new Square();
        sqr = sqr.setWidth(20);
        assertThat(sqr.area()).isEqualTo(400.0);
    }
    @Test
    @DisplayName("Площадь квадрата, Default constructor")
    void squareAreaDefaultH() {
        Rectangle sqr = new Square();
        sqr = sqr.setHeight(20);
        assertThat(sqr.area()).isEqualTo(400.0);
    }

    @Test
    @DisplayName("Площадь квадрата, Parametrized constructor")
    void squareAreaParameters() {
        Rectangle sqr = new Square(30);
        assertThat(sqr.area()).isEqualTo(900);
    }
}
