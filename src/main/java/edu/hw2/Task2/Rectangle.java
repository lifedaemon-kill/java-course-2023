package edu.hw2.Task2;

public class Rectangle {
    protected int width;
    protected int height;

    public Rectangle() {
    }

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle setWidth(int width) {
        return new Rectangle(width, this.height);
    }

    public Rectangle setHeight(int height) {
        return new Rectangle(this.width, height);
    }

    public double area() {
        return this.width * this.height;
    }
}
