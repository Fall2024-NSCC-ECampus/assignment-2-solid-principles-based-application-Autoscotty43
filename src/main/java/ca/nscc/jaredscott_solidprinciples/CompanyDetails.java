package ca.nscc.jaredscott_solidprinciples;

public class CompanyDetails {
    private final String name;
    private final String address;

    public CompanyDetails(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return name + " located at " + address;
    }
}
