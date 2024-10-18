package ca.nscc.jaredscott_solidprinciples;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class OrderDetailsController {

    @FXML
    private Label orderSummary;

    @FXML
    private Label paymentStatus;

    private String orderDetails;

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
        displayOrderDetails();
    }

    private void displayOrderDetails() {
        orderSummary.setText(orderDetails);
        paymentStatus.setText("Payment was successful!");
    }

}
