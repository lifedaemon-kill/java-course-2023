package edu.hw2;

final class Task1Calculator {
    private Task1Calculator() {
    }

    public sealed interface Expr {
        double evaluate();

        record Constant(double value) implements Expr {
            @Override
            public double evaluate() {
                return value();
            }
        }

        record Negate(Expr object) implements Expr {
            @Override
            public double evaluate() {
                return -object.evaluate();
            }
        }

        record Exponent(Expr object, double power) implements Expr {
            @Override
            public double evaluate() {
                return Math.pow(object.evaluate(), power);
            }
        }

        record Addition(Expr object1, Expr object2) implements Expr {
            @Override
            public double evaluate() {
                return object1.evaluate() + object2.evaluate();
            }
        }

        record Multiplication(Expr object1, Expr object2) implements Expr {
            @Override
            public double evaluate() {
                return object1.evaluate() * object2.evaluate();
            }
        }
    }
}
