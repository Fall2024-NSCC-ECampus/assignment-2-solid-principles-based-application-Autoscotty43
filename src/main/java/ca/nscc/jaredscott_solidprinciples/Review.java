package ca.nscc.jaredscott_solidprinciples;

public class Review {
    private final String productName;
    private final String reviewText;
    private final int rating;

    public Review(String productName, String reviewText, int rating) {
        this.productName = productName;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review for " + productName + ": " + reviewText + " (Rating: " + rating + " stars)";
    }
}