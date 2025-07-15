module com.beginsecure.lightingsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.beginsecure.lightingsystem to javafx.fxml;
    exports com.beginsecure.lightingsystem;
}