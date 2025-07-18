package com.lightingsystem;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FxApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        var pane = new Pane();

        SVGPath outer = new SVGPath();
        outer.setContent("M20 40 h710 v490 h-710 z");
        outer.setFill(Color.web("#666666"));
        outer.setStroke(Color.BLACK);
        outer.setStrokeWidth(2);
        pane.getChildren().add(outer);

        SVGPath wall = new SVGPath();
        wall.setContent(
                "M40 60 h140 v25 h10 v-25 "
                        + "h150 v-20 h60 v20 h100 v25 h10 v-25 "
                        + "h200 v450 h-200 v-375 h-10 v25 h-75 v10 "
                        + "h75 v340 h-200 v-340 h75 v-10 h-85 v80 "
                        + "h-25 v10 h25 v260 h-250 v-260 h175 v-10 "
                        + "h-25 v-10 h-10 v10 h-140 v-70 h140 v10 "
                        + "h10 v-45 h-10 v25 h-140 v-100"
        );
        wall.setFill(Color.WHITE);
        wall.setStroke(Color.BLACK);
        wall.setStrokeWidth(2);
        pane.getChildren().add(wall);

        Font labelFont = Font.font("Helvetica", FontWeight.LIGHT, FontPosture.ITALIC, 12);
        Color labelColor = Color.web("#999966");

        Text t1 = new Text(45, 75,  "Ванная");
        t1.setFont(labelFont);
        t1.setFill(labelColor);
        pane.getChildren().add(t1);

        Text t2 = new Text(45, 185, "Туалет");
        t2.setFont(labelFont);
        t2.setFill(labelColor);
        pane.getChildren().add(t2);

        Text t3 = new Text(45, 265, "Кухня");
        t3.setFont(labelFont);
        t3.setFill(labelColor);
        pane.getChildren().add(t3);

        Text t4 = new Text(195, 75, "Прихожая");
        t4.setFont(labelFont);
        t4.setFill(labelColor);
        pane.getChildren().add(t4);

        Text t5 = new Text(515, 75, "Спальня");
        t5.setFont(labelFont);
        t5.setFill(labelColor);
        pane.getChildren().add(t5);

        Text t6 = new Text(305, 185, "Гостиная");
        t6.setFont(labelFont);
        t6.setFill(labelColor);
        pane.getChildren().add(t6);

        SVGPath window1 = new SVGPath();
        window1.setContent(
                "M120 510 h75 v20 h-75 v-20 "
                        + "M120 515 h75 v10 h-75 v-10 "
                        + "M130 515 h55 v10 h-55 v-10"
        );
        window1.setFill(Color.WHITE);
        window1.setStroke(Color.BLACK);
        window1.setStrokeWidth(2);
        pane.getChildren().add(window1);

        SVGPath door = new SVGPath();
        door.setContent("M195 510 h50 v20 h-50 v-20");
        door.setFill(Color.WHITE);
        door.setStroke(Color.BLACK);
        door.setStrokeWidth(2);
        pane.getChildren().add(door);

        SVGPath porch = new SVGPath();
        porch.setContent("M80 530 v70 h200 v-70 h5 v75 h-210 v-75");
        porch.setFill(Color.WHITE);
        porch.setStroke(Color.BLACK);
        porch.setStrokeWidth(2);
        pane.getChildren().add(porch);

        SVGPath window2 = new SVGPath();
        window2.setContent(
                "M350 510 h100 v20 h-100 v-20 "
                        + "M350 515 h100 v10 h-100 v-10 "
                        + "M360 515 h80 v10 h-80 v-10"
        );
        window2.setFill(Color.WHITE);
        window2.setStroke(Color.BLACK);
        window2.setStrokeWidth(2);
        pane.getChildren().add(window2);

        SVGPath window3 = new SVGPath();
        window3.setContent(
                "M560 510 h100 v20 h-100 v-20 "
                        + "M560 515 h100 v10 h-100 v-10 "
                        + "M570 515 h80 v10 h-80 v-10"
        );
        window3.setFill(Color.WHITE);
        window3.setStroke(Color.BLACK);
        window3.setStrokeWidth(2);
        pane.getChildren().add(window3);

        SVGPath door1 = new SVGPath();
        door1.setContent("M400 55 h-60 v50 A70.71 70.71 0 0 0 400 55");
        door1.setFill(Color.WHITE);
        door1.setStroke(Color.BLACK);
        door1.setStrokeWidth(2);
        pane.getChildren().add(door1);

        SVGPath door2 = new SVGPath();
        door2.setContent("M185 85 v50 h50 A70.71 70.71 0 0 0 185 85");
        door2.setFill(Color.WHITE);
        door2.setStroke(Color.BLACK);
        door2.setStrokeWidth(2);
        pane.getChildren().add(door2);

        SVGPath door3 = new SVGPath();
        door3.setContent("M185 180 v50 h50 A70.71 70.71 0 0 0 185 180");
        door3.setFill(Color.WHITE);
        door3.setStroke(Color.BLACK);
        door3.setStrokeWidth(2);
        pane.getChildren().add(door3);

        SVGPath door4 = new SVGPath();
        door4.setContent("M215 245 h50 v50 A70.71 70.71 0 0 1 215 245");
        door4.setFill(Color.WHITE);
        door4.setStroke(Color.BLACK);
        door4.setStrokeWidth(2);
        pane.getChildren().add(door4);

        SVGPath door5 = new SVGPath();
        door5.setContent("M375 165 h50 v50 A70.71 70.71 0 0 1 375 165");
        door5.setFill(Color.WHITE);
        door5.setStroke(Color.BLACK);
        door5.setStrokeWidth(2);
        pane.getChildren().add(door5);

        SVGPath door6 = new SVGPath();
        door6.setContent("M505 85 v50 h50 A70.71 70.71 0 0 0 505 85");
        door6.setFill(Color.WHITE);
        door6.setStroke(Color.BLACK);
        door6.setStrokeWidth(2);
        pane.getChildren().add(door6);

        SVGPath door7 = new SVGPath();
        door7.setContent("M195 510 h50 v-50 A70.71 70.71 0 0 0 195 510");
        door7.setFill(Color.WHITE);
        door7.setStroke(Color.BLACK);
        door7.setStrokeWidth(2);
        pane.getChildren().add(door7);

        var scene = new Scene(pane, 800, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}