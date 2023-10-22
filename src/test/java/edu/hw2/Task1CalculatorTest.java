package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw2.Task1Calculator.Expr.*;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1CalculatorTest {

    @Test
    @DisplayName("Тест с курса")
    void test1() {
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));

        System.out.println(res + " = " + res.evaluate());
        assertThat(res.evaluate()).isEqualTo(37);
    }
}
