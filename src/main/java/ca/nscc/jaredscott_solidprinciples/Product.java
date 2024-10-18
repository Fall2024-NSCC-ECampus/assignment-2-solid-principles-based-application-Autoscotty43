package ca.nscc.jaredscott_solidprinciples;

public class Product {
    private final String name;
    private final double price;
    private final String description;

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ": $" + price + "\nDescription: " + description;
    }
}
