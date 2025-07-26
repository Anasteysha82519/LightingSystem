package com.lightingsystem.components;

import javafx.scene.Group;
import javafx.scene.effect.Glow;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;

public final class Lamp extends Group {
    private final SVGPath lampImage;
    private final Glow glowEffect;
    private final Circle lightEffect;
    private final DropShadow hoverEffect;
    private boolean turnedOn;

    public Lamp(double x, double y, SVGPath lampImage) {
        this.lampImage = lampImage;
        this.glowEffect = new Glow(0.7);
        this.hoverEffect = new DropShadow(10, Color.GRAY);
        this.hoverEffect.setInput(glowEffect);

        this.lightEffect = new Circle();
        this.lightEffect.setRadius(50);
        this.lightEffect.setFill(Color.rgb(255, 255, 0, 0.3));
        this.lightEffect.setVisible(false);

        this.getChildren().addAll(lampImage, lightEffect);


        setTranslateX(x);
        setTranslateY(y);
        setTurnedOn(false);

        initEventHandlers();
    }

    private void initEventHandlers() {
        this.setOnMouseEntered(event -> {
            if (!turnedOn) {
                lampImage.setEffect(hoverEffect);
            }
        });

        this.setOnMouseExited(event -> {
            if (!turnedOn) {
                lampImage.setEffect(null);
            }
        });

        this.setOnMouseClicked(event -> setTurnedOn(!turnedOn));
    }

    public void setTurnedOn(boolean turnedOn) {
        this.turnedOn = turnedOn;
        if (turnedOn) {
            lampImage.setEffect(glowEffect);
            lightEffect.setVisible(true);
        } else {
            lampImage.setEffect(null);
            lightEffect.setVisible(false);
        }
    }
}