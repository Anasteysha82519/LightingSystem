module lightingsystem {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.lightingsystem to javafx.fxml;
    exports com.lightingsystem;
}