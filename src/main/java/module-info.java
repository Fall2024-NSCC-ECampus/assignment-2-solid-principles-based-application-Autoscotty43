module ca.nscc.jaredscott_solidprinciples {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens ca.nscc.jaredscott_solidprinciples to javafx.fxml;
    exports ca.nscc.jaredscott_solidprinciples;
}