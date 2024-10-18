package ca.nscc.jaredscott_solidprinciples;

public class DeliveryDetails {
    private final String trackingNumber;
    private final String status;
    private final String deliveryAddress;

    public DeliveryDetails(String trackingNumber, String status, String deliveryAddress) {
        this.trackingNumber = trackingNumber;
        this.status = status;
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString() {
        return "Tracking Number: " + trackingNumber + ", Status: " + status + ", Address: " + deliveryAddress;
    }
}