package ca.nscc.jaredscott_solidprinciples;

public class HubRate {
    private final String hubName;
    private final double rate;

    public HubRate(String hubName, double rate) {
        this.hubName = hubName;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return hubName + " charges a hub rate of $" + rate;
    }
}
