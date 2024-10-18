package ca.nscc.jaredscott_solidprinciples;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentController {

    @FXML
    private TextField cardNumberField;

    @FXML
    private TextField expiryField;

    @FXML
    private TextField cvvField;

    // Handle the payment submission
    @FXML
    public void handleSubmitPayment() {
        String cardNumber = cardNumberField.getText().trim();
        String expiryDate = expiryField.getText().trim();
        String cvv = cvvField.getText().trim();

        // Basic validation
        if (cardNumber.isEmpty() || expiryDate.isEmpty() || cvv.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill in all fields.");
            alert.setTitle("Warning");
            alert.showAndWait();
        } else {
            // Process the payment (implement as needed)
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Payment submitted successfully!");
            alert.setTitle("Payment Confirmation");
            alert.showAndWait();

            // Navigate to the order details page
            navigateToOrderDetails("Your order has been successfully placed!");
        }
    }

    private void navigateToOrderDetails(String orderDetails) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("order_details.fxml")); // Update the path if necessary
            Scene orderDetailsScene = new Scene(loader.load());

            OrderDetailsController orderDetailsController = loader.getController();
            orderDetailsController.setOrderDetails(orderDetails);

            // Get the current stage and set the new scene
            Stage currentStage = (Stage) cardNumberField.getScene().getWindow();
            currentStage.setScene(orderDetailsScene);
            currentStage.setTitle("Order Details"); // Set the title for the order details page
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to load order details page.");
            alert.setTitle("Error");
            alert.showAndWait();
        }
    }
}
