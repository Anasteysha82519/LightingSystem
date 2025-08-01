package com.lightingsystem.components;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.effect.Glow;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import javafx.util.Duration;

public final class Lamp extends Group {
    private final SVGPath lampImage;
    private final Glow glowEffect;
    private final Circle lightEffect;
    private final DropShadow hoverEffect;
    private boolean turnedOn;

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

        setOnMouseClicked(e -> toggle());

        setOnMouseEntered(e -> {
            if (!turnedOn) {
                lampImage.setFill(Color.web("#e499ff"));
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
                                    0.0
                            )
                    ),
                    new KeyFrame(
                            Duration.millis(100),
                            new KeyValue(
                                    glowEffect.levelProperty(),
                                    1.8,
                                    Interpolator.EASE_OUT
                            )
                    ),
                    new KeyFrame(
                            Duration.millis(400),
                            new KeyValue(
                                    glowEffect.levelProperty(),
                                    0.8,
                                    Interpolator.EASE_IN
                            )
                    )
            );
        }
        else {
            glowTimeline.getKeyFrames().add(
                    new KeyFrame(
                            Duration.millis(400),
                            new KeyValue(
                                    glowEffect.levelProperty(),
                                    0.0,
                                    Interpolator.EASE_IN
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
        lightFade.setInterpolator(Interpolator.EASE_BOTH);


        var lightScale = new ScaleTransition(
                Duration.millis(500),
                lightEffect
        );
        lightScale.setFromX(turnedOn ? 0.5 : 1.0);
        lightScale.setFromY(turnedOn ? 0.5 : 1.0);
        lightScale.setToX(turnedOn ? 1.0 : 0.5);
        lightScale.setToY(turnedOn ? 1.0 : 0.5);
        lightScale.setInterpolator(Interpolator.EASE_BOTH);


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
}