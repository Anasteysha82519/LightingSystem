package com.lightingsystem.components;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Glow;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import javafx.util.Duration;

import java.util.Optional;

public final class Lamp extends Group {
    private final SVGPath lampImage;
    private final Glow glowEffect;
    private final Circle lightEffect;
    private final DropShadow hoverEffect;
    private boolean turnedOn;
    private double power = 60.0;

    public Lamp(double x, double y, SVGPath lampImage) {
        this.lampImage = lampImage;
        this.glowEffect = new Glow(0d);
        this.lightEffect = new Circle(0d, 0d, 80d);
        this.hoverEffect = new DropShadow(10d, Color.web("#ffcc00"));
        this.turnedOn = false;
        init(x, y);
    }

    private void init(double x, double y) {
        setTranslateX(x);
        setTranslateY(y);

        lampImage.setEffect(glowEffect);

        lightEffect.setFill(
                new RadialGradient(
                        0, 0, 0, 0, 80d,
                        false, CycleMethod.NO_CYCLE,
                        new Stop(0, Color.web("#ffffcc", 0.3)),
                        new Stop(1, Color.web("#ffffcc", 0.0))
                )
        );
        lightEffect.setVisible(false);

        getChildren().addAll(lampImage, lightEffect);

        setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                showPowerDialog();
            } else if (e.getButton() == MouseButton.PRIMARY) {
                toggle();
            }
        });

        setOnMouseEntered(e -> {
            if (!turnedOn) {
                lampImage.setFill(Color.web("#7777bb"));
                setEffect(hoverEffect);
            }
        });

        setOnMouseExited(e -> {
            if (!turnedOn) {
                lampImage.setFill(Color.web("#00cccc"));
                setEffect(null);
            }
        });
    }

    public void toggle() {
        turnedOn = !turnedOn;

        var fillTransition = new FillTransition(
                Duration.millis(200),
                lampImage,
                null,
                turnedOn ? Color.web("#ffcc00") : Color.web("#00cccc")
        );

        var glowTimeline = new Timeline();
        if (turnedOn) {
            glowTimeline.getKeyFrames().addAll(
                    new KeyFrame(
                            Duration.ZERO,
                            new KeyValue(
                                    glowEffect.levelProperty(),
                                    2.0
                            )
                    ),
                    new KeyFrame(
                            Duration.millis(110),
                            new KeyValue(
                                    glowEffect.levelProperty(),
                                    0.2 * (power / 100.0),
                                    Interpolator.EASE_OUT
                            )
                    ),
                    new KeyFrame(
                            Duration.millis(290),
                            new KeyValue(
                                    glowEffect.levelProperty(),
                                    0.8 * (power / 100.0),
                                    Interpolator.EASE_IN
                            )
                    )
            );
        } else {
            glowTimeline.getKeyFrames().addAll(
                    new KeyFrame(
                            Duration.ZERO,
                            new KeyValue(
                                    glowEffect.levelProperty(),
                                    0.8
                            )
                    ),
                    new KeyFrame(
                            Duration.millis(400),
                            new KeyValue(
                                    glowEffect.levelProperty(),
                                    0.0,
                                    Interpolator.EASE_OUT
                            )
                    )
            );
        }

        var lightFade = new FadeTransition(
                Duration.millis(500),
                lightEffect
        );
        lightFade.setFromValue(turnedOn ? 0.0 : 0.3);
        lightFade.setToValue(turnedOn ? 0.3 : 0.0);

        var lightScale = new ScaleTransition(
                Duration.millis(500),
                lightEffect
        );
        lightScale.setFromX(turnedOn ? 0.0 : 0.1);
        lightScale.setFromY(turnedOn ? 0.0 : 0.1);
        lightScale.setToX(turnedOn ? 0.1 : 0.0);
        lightScale.setToY(turnedOn ? 0.1 : 0.0);
        lightScale.setInterpolator(turnedOn ? Interpolator.EASE_OUT : Interpolator.EASE_IN);


        var parallelTransition = new ParallelTransition(
                fillTransition,
                glowTimeline,
                lightFade,
                lightScale
        );

        if (turnedOn) {
            lightEffect.setVisible(true);
        } else {
            lightFade.setOnFinished(e ->
                    lightEffect.setVisible(false)
            );
        }

        parallelTransition.play();
    }

    public void showPowerDialog() {
        Dialog<Double> dialog = new Dialog<>();
        dialog.setTitle("Настройка мощности");
        dialog.setHeaderText("Установите мощность лампы (Вт)");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        Slider powerSlider = new Slider(10, 100, power);
        powerSlider.setPrefWidth(250);
        powerSlider.setPrefHeight(40);
        powerSlider.setShowTickMarks(true);
        powerSlider.setShowTickLabels(true);
        powerSlider.setMajorTickUnit(5);
        powerSlider.setMinorTickCount(0);
        powerSlider.setBlockIncrement(1);
        powerSlider.setSnapToTicks(true);

        Label valueLabel = new Label("Текущая мощность: " + (int)power + " Вт");

        powerSlider.valueProperty().addListener((obs, oldVal, newVal) ->
                valueLabel.setText("Текущая мощность: " + newVal + " Вт")
        );

        VBox content = new VBox(10, powerSlider, valueLabel);
        dialog.getDialogPane().setContent(content);

        dialog.setResultConverter(
                buttonType -> {
                    if (buttonType == ButtonType.OK) {
                        return powerSlider.getValue();
                    }
                    return null;
                }
        );

        Optional<Double> result = dialog.showAndWait();
        result.ifPresent(
                newPower -> {
                    setPower(newPower);
                    System.out.println("New power: " + newPower + " W");
                }
        );
    }

    public void setPower(double power) {
        this.power = power;
        updateGlowEffect();
    }

    private  void updateGlowEffect() {
        double glowLevel = 0.8 * (power / 100.0);
        glowEffect.setLevel(glowLevel);
    }
}