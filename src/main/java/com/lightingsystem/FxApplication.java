package com.lightingsystem;

import com.lightingsystem.components.Lamp;
import com.lightingsystem.components.LampFactory;
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

import static com.lightingsystem.util.GraphicsUtils.newSvgPath;
import static com.lightingsystem.util.GraphicsUtils.newText;

public class FxApplication extends Application {
    @Override
    public void start(Stage stage) {
        var pane = new Pane();
        pane.getChildren().addAll(createApartmentOutline());
        pane.getChildren().addAll(createRoomNames());
        pane.getChildren().addAll(createLamps());

        var scene = new Scene(pane, 800, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private SVGPath[] createApartmentOutline() {

        return new SVGPath[]{
                newSvgPath("M20 40 h710 v490 h-710 z",
                        Color.web("#666666"),
                        Color.BLACK,
                        2d),
                newSvgPath("M40 60 h140 v25 h10 v-25 "
                                + "h150 v-20 h60 v20 h100 v25 h10 v-25 "
                                + "h200 v450 h-200 v-375 h-10 v25 h-75 v10 "
                                + "h75 v340 h-200 v-340 h75 v-10 h-85 v80 "
                                + "h-25 v10 h25 v260 h-250 v-260 h175 v-10 "
                                + "h-25 v-10 h-10 v10 h-140 v-70 h140 v10 "
                                + "h10 v-45 h-10 v25 h-140 v-100",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M120 510 h75 v20 h-75 v-20 "
                                + "M120 515 h75 v10 h-75 v-10 "
                                + "M130 515 h55 v10 h-55 v-10",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M195 510 h50 v20 h-50 v-20",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M80 530 v70 h200 v-70 h5 v75 h-210 v-75",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M350 510 h100 v20 h-100 v-20 "
                                + "M350 515 h100 v10 h-100 v-10 "
                                + "M360 515 h80 v10 h-80 v-10",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M560 510 h100 v20 h-100 v-20 "
                                + "M560 515 h100 v10 h-100 v-10 "
                                + "M570 515 h80 v10 h-80 v-10",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M400 55 h-60 v50 A70.71 70.71 0 0 0 400 55",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M185 85 v50 h50 A70.71 70.71 0 0 0 185 85",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M185 180 v50 h50 A70.71 70.71 0 0 0 185 180",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M215 245 h50 v50 A70.71 70.71 0 0 1 215 245",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M375 165 h50 v50 A70.71 70.71 0 0 1 375 165",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M505 85 v50 h50 A70.71 70.71 0 0 0 505 85",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
                newSvgPath("M195 510 h50 v-50 A70.71 70.71 0 0 0 195 510",
                        Color.WHITE,
                        Color.BLACK,
                        2d),
        };
    }

    private Text[] createRoomNames() {
        Font labelFont = Font.font("Helvetica", FontWeight.LIGHT, FontPosture.ITALIC, 12);
        Color labelColor = Color.web("#999966");
        return new Text[] {
                newText(45, 75, "Ванная", labelFont, labelColor),
                newText(45, 185, "Туалет", labelFont, labelColor),
                newText(45, 265, "Кухня", labelFont, labelColor),
                newText(195, 75, "Прихожая", labelFont, labelColor),
                newText(515, 75, "Спальня", labelFont, labelColor),
                newText(305, 185, "Гостиная", labelFont, labelColor),
        };
    }

    private Lamp[] createLamps() {
        return new Lamp[]{
                LampFactory.createBedsideLamp(545, 493),
                LampFactory.createBedsideLamp(673, 493),
                LampFactory.createTableLamp(690, 80),
                LampFactory.createCeilingLamp(610, 190),
                LampFactory.createCeilingLamp(610, 390),
                LampFactory.createCeilingLamp(400, 280),
                LampFactory.createCeilingLamp(400, 400),
                LampFactory.createBathroomLamp(110, 110),
                LampFactory.createBathroomLamp(110, 205),
                LampFactory.createHallwayLamp(400, 105),
                LampFactory.createHallwayLamp(240, 155),
                LampFactory.createWallLamp(487, 200),
                LampFactory.createFloorLamp(325, 475),
                LampFactory.createKitchenLamp(110, 310),
                LampFactory.createKitchenLamp(225, 440)
        };
    }

    public static void main(String[] args) {
        launch();
    }
}