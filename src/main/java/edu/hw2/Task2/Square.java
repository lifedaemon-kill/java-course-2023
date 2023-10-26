package edu.hw2.Task2;

public class Square extends Rectangle {
    public Square(int edge) {
        super(edge, edge);
    }

    public Square() {
    }

    @Override
    public Rectangle setWidth(int width) {
        return new Rectangle(width, width);
    }

    @Override
    public Rectangle setHeight(int height) {
        return new Rectangle(height, height);
    }
}
