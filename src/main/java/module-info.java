module lightingsystem {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.lightingsystem to javafx.fxml;
    exports com.lightingsystem;
    exports com.lightingsystem.controller;
    opens com.lightingsystem.controller to javafx.fxml;
}