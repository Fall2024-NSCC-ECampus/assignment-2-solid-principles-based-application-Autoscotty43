package ca.nscc.jaredscott_solidprinciples;

public class NonDeliveryDetails {
    private final String reason;

    public NonDeliveryDetails(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Non-Delivery Reason: " + reason;
    }
}
