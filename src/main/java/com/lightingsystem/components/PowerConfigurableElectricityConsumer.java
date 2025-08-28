package com.lightingsystem.components;

public interface PowerConfigurableElectricityConsumer {
    double getPower();
    void setPower(double power);
    boolean isTurnedOn();
    void  toggle();
}