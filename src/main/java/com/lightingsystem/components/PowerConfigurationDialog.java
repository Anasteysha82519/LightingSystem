package com.lightingsystem.components;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class PowerConfigurationDialog {
    private final Dialog<Double> dialog;
    private final Slider powerSlider;
    private final Label valueLabel;
    private final PowerConfigurableElectricityConsumer consumer;
    private final VBox content;

    public PowerConfigurationDialog(PowerConfigurableElectricityConsumer consumer) {
        double power = consumer.getPower();

        this.dialog = new Dialog<>();
        this.powerSlider = new Slider(10, 100, power);
        this.valueLabel = new Label(formatPower(power));
        this.consumer = consumer;
        this.content = new VBox(10, powerSlider, valueLabel);

        init();
    }

    private void init() {
        dialog.setTitle("Настройка мощности");
        dialog.setHeaderText("Установите мощность (Вт)");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        dialog.getDialogPane().setContent(content);
        dialog.setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK) {
                return (double) (Math.round(powerSlider.getValue() / 5) * 5);
            }
            return null;
        });

        powerSlider.setPrefWidth(250);
        powerSlider.setPrefHeight(40);
        powerSlider.setShowTickMarks(true);
        powerSlider.setShowTickLabels(true);
        powerSlider.setMajorTickUnit(5);
        powerSlider.setMinorTickCount(0);
        powerSlider.setBlockIncrement(5);
        powerSlider.setSnapToTicks(true);
        powerSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            double roundedValue = (Math.round(newVal.doubleValue() / 5) * 5);
            valueLabel.setText(formatPower(roundedValue));
        });
    }

    private String formatPower(double power) {
        return "Текущая мощность: " + power + " Вт";
    }

    public void showAndConfigure() {
        dialog.showAndWait().ifPresent(consumer::setPower);
    }
}