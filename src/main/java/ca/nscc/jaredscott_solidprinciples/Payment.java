package ca.nscc.jaredscott_solidprinciples;

public class Payment {
    private final double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public boolean processPayment() {
        // Simulate payment processing logic with a random failure
        boolean success = Math.random() > 0.2; // 80% success rate
        System.out.println("Processing payment of $" + amount);
        return success; // Simulate success or failure
    }

    public boolean issueRefund() {
        System.out.println("Issuing refund for $" + amount);
        return true; // Simulate successful refund
    }
}
