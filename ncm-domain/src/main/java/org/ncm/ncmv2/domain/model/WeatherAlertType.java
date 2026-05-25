package org.ncm.ncmv2.domain.model;

public enum WeatherAlertType {
    TORNADO("Tornado Warning"),
    SV_THDR("Severe Thunderstorm Warning"),
    F_FLOOD("Flash Flood Warning");

    private final String text;

    WeatherAlertType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}