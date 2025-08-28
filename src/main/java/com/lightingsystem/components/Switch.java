package com.lightingsystem.components;

import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import com.lightingsystem.util.GraphicsUtils;

public class Switch extends Group {
    private final SVGPath switchImage;
    private final DropShadow hoverEffect;
    private boolean turnedOn;
    private final Lamp[] lamps;
    private final String svgOn;
    private final String svgOff;

    public Switch(double x, double y, Lamp[] lamps) {
        this.svgOn = "M32.3678,34.1333H1.7655C0.7651,34.1333,0,33.3682,0,32.3678V1.7655C0,0.7651,0.7651,0,1.7655,0h30.6023" +
                "C33.3682,0,34.1333,0.7651,34.1333,1.7655v30.6023C34.1333,33.3682,33.3682,34.1333,32.3678,34.1333" +
                "M11.7701,17.0667h10.5931V6.4736H11.7701V17.0667z" +
                "M11.7701,27.6598h10.5931V17.0667H11.7701V27.6598z" +
                "M17.0667,24.7173c-0.3531,0-0.5885-0.2354-0.5885-0.5885v-3.5311c0-0.3531,0.2354-0.5885,0.5885-0.5885" +
                "c0.3531,0,0.5885,0.2354,0.5885,0.5885v3.5311C17.6552,24.4819,17.4198,24.7173,17.0667,24.7173" +
                "M4.1195,2.9425c0-0.6473-0.5297-1.177-1.177-1.177s-1.177,0.5297-1.177,1.177" +
                "s0.5297,1.177,1.177,1.177S4.1195,3.5898,4.1195,2.9425" +
                "M4.1195,31.1908c0-0.6473-0.5297-1.177-1.177-1.177s-1.177,0.5297-1.177,1.177" +
                "s0.5297,1.177,1.177,1.177S4.1195,31.8381,4.1195,31.1908" +
                "M32.3678,2.9425c0-0.6473-0.5297-1.177-1.177-1.177s-1.177,0.5297-1.177,1.177" +
                "s0.5297,1.177,1.177,1.177S32.3678,3.5898,32.3678,2.9425" +
                "M32.3678,31.1908c0-0.6473-0.5297-1.177-1.177-1.177s-1.177,0.5297-1.177,1.177" +
                "s0.5297,1.177,1.177,1.177S32.3678,31.8381,32.3678,31.1908";

        this.svgOff = "M32.3678,34.1333H1.7655C0.7651,34.1333,0,33.3682,0,32.3678V1.7655C0,0.7651,0.7651,0,1.7655,0h30.6023" +
                "C33.3682,0,34.1333,0.7651,34.1333,1.7655v30.6023C34.1333,33.3682,33.3682,34.1333,32.3678,34.1333" +
                "M11.7701,17.0667h10.5931V6.4736H11.7701V17.0667z" +
                "M11.7701,27.6598h10.5931V17.0667H11.7701V27.6598z" +
                "M18.8322,11.7701c0-1.0004-0.7651-1.7655-1.7655-1.7655s-1.7655,0.7651-1.7655,1.7655" +
                "c0,1.0004,0.7651,1.7655,1.7655,1.7655S18.8322,12.7705,18.8322,11.7701" +
                "M4.1195,2.9425c0-0.6473-0.5297-1.177-1.177-1.177s-1.177,0.5297-1.177,1.177" +
                "s0.5297,1.177,1.177,1.177S4.1195,3.5898,4.1195,2.9425" +
                "M4.1195,31.1908c0-0.6473-0.5297-1.177-1.177-1.177s-1.177,0.5297-1.177,1.177" +
                "s0.5297,1.177,1.177,1.177S4.1195,31.8381,4.1195,31.1908" +
                "M32.3678,2.9425c0-0.6473-0.5297-1.177-1.177-1.177s-1.177,0.5297-1.177,1.177" +
                "s0.5297,1.177,1.177,1.177S32.3678,3.5898,32.3678,2.9425" +
                "M32.3678,31.1908c0-0.6473-0.5297-1.177-1.177-1.177s-1.177,0.5297-1.177,1.177" +
                "s0.5297,1.177,1.177,1.177S32.3678,31.8381,32.3678,31.1908";

        this.switchImage = createSwitchImage();
        this.hoverEffect = new DropShadow(10d, Color.web("#ffcc00"));
        this.turnedOn = false;
        this.lamps = lamps;
        init(x, y);
    }

    private SVGPath createSwitchImage() {
        return GraphicsUtils.newSvgPath(svgOff, Color.web("#00ffbb"), Color.web("#009999"), 2.0);
    }

    private void init(double x, double y) {
        setTranslateX(x);
        setTranslateY(y);

        getChildren().add(switchImage);

        setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                toggleAllLamps();
            }
        });

        setOnMouseEntered(e -> {
            switchImage.setFill(Color.web("#00ffbb"));
            setEffect(hoverEffect);
        });

        setOnMouseExited(e -> {
            switchImage.setFill(Color.web("#00ffbb"));
            setEffect(null);
        });
    }

    private void toggleAllLamps() {
        turnedOn = !turnedOn;

        switchImage.setContent(turnedOn ? svgOn : svgOff);
        switchImage.setFill(Color.web("#00ffbb"));

        for (Lamp lamp : lamps) {
            if (lamp.isTurnedOn() != turnedOn) {
                lamp.toggle();
            }
        }
    }
}