package edu.hw3.Task6;

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
}
