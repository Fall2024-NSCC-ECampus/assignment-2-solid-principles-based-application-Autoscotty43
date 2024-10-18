package ca.nscc.jaredscott_solidprinciples;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String deliveryAddress;
    private final List<Product> products;

    public Order(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder();
        orderDetails.append("Delivery Address: ").append(deliveryAddress).append("\n");
        orderDetails.append("Products in Order:\n");
        for (Product product : products) {
            orderDetails.append(product.toString()).append("\n");
        }
        orderDetails.append("Total Price: $").append(calculateTotal());
        return orderDetails.toString();
    }
}
