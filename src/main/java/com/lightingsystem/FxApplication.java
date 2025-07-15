package com.lightingsystem;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        var fxmlLoader = new FXMLLoader(FxApplication.class.getResource("view/hello-view.fxml"));
        var scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}