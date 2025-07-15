package com.lightingsystem.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        if (welcomeText.getText().isEmpty()) {
            welcomeText.setText("Welcome to JavaFX Application!");
        } else {
            welcomeText.setText("");
        }
    }
}