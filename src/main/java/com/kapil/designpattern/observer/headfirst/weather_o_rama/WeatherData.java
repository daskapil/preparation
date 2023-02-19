package com.kapil.designpattern.observer.headfirst.weather_o_rama;

public class WeatherData {
    private float temperature;
    private float humidity;
    private float pressure;

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void measurementChanged(){

    }
}
