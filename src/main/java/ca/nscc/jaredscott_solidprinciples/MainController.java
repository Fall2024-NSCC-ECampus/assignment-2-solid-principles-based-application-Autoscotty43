package ca.nscc.jaredscott_solidprinciples;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    private ComboBox<Product> productComboBox;

    @FXML
    private RadioButton deliveryRadioButton;

    @FXML
    private RadioButton pickupRadioButton;

    @FXML
    private TextField addressField;

    @FXML
    private Button orderButton;

    @FXML
    private Label orderStatus;

    @FXML
    private Label addressLabel;

    private final List<Product> productList = new ArrayList<>();

    @FXML
    public void initialize() {
        // Create Jell-o Products
        productList.add(new Product("Blue Raspberry", 89.99, "Delicious blue raspberry flavored Jell-o"));
        productList.add(new Product("Cherry", 89.99, "Classic cherry flavored Jell-o"));
        productList.add(new Product("Lime", 89.99, "Refreshing lime flavored Jell-o"));
        productList.add(new Product("Orange Soda", 89.99, "Tasty orange soda flavored Jell-o"));

        // Populate the ComboBox
        productComboBox.getItems().addAll(productList);

        // Set default option for delivery
        deliveryRadioButton.setSelected(true);

        // Create ToggleGroup to group the radio buttons
        ToggleGroup deliveryOptions = new ToggleGroup();
        deliveryRadioButton.setToggleGroup(deliveryOptions);
        pickupRadioButton.setToggleGroup(deliveryOptions);

        // Handle order button click
        orderButton.setOnAction(e -> handleOrder());

        // Add listeners for radio button selection changes
        deliveryRadioButton.setOnAction(e -> updateAddressField());
        pickupRadioButton.setOnAction(e -> updateAddressField());

        // Initialize the address field based on default selection
        updateAddressField();
    }

    private void updateAddressField() {
        if (deliveryRadioButton.isSelected()) {
            addressLabel.setText("Delivery Address:");
            addressField.setPromptText("Enter delivery address");
            addressField.setText("");
        } else {
            addressLabel.setText("Pickup Address:");
            addressField.setPromptText("Pickup address: 123 Jell-o Lane, Nova Scotia");
            addressField.setText("123 Jell-o Lane, Nova Scotia");
        }
    }

    private void handleOrder() {
        Product selectedProduct = productComboBox.getValue();
        String deliveryAddress = addressField.getText().trim();

        if (selectedProduct != null) {
            Order order = new Order(deliveryAddress);
            order.addProduct(selectedProduct);

            // Set delivery address if chosen delivery
            if (deliveryRadioButton.isSelected() && !deliveryAddress.isEmpty()) {
                order.setDeliveryAddress(deliveryAddress);
            } else if (pickupRadioButton.isSelected()) {
                order.setDeliveryAddress("123 Jell-o Lane, Nova Scotia");
            }

            // Show order confirmation
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Placed");
            alert.setHeaderText("Order Details");
            alert.setContentText(order.toString());
            alert.showAndWait();

            // Navigate to the payment page
            navigateToPaymentPage();
        } else {
            orderStatus.setText("Please select a product.");
        }
    }

    private void navigateToPaymentPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("payment.fxml")); // Update the path if necessary
            Scene paymentScene = new Scene(loader.load());

            // Get the current stage and set the new scene
            Stage currentStage = (Stage) orderButton.getScene().getWindow();
            currentStage.setScene(paymentScene);
            currentStage.setTitle("Process Payment"); // Set the title for the new page
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to load payment page.");
            alert.setTitle("Error");
            alert.showAndWait();
        }
    }
}