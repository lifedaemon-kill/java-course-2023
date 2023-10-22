package edu.hw2;

final class Task2SquareRectangle {
    private Task2SquareRectangle() {
    }

    public static class Rectangle {
        protected int width;
        protected int height;

        Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        Rectangle() {
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

    public static class Square extends Rectangle {
        Square(int edge) {
            super(edge, edge);
        }

        Square() {
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
}
