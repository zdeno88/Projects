package cz.engeto;

import java.time.LocalDate;

public class MeteoData implements Comparable<MeteoData>{
    private LocalDate date;
    private double avrTemperature;
    private double maxTemperature;
    private double minTemperature;
    private double pressure;
    private double windSpead;
    private double wet;
    private double rain;

    public MeteoData(LocalDate date, String avrTemperature, String maxTemperature,
                     String minTemperature, String pressure, String windSpead, String wet, String rain) {
        this.date = date;
        this.avrTemperature = Double.parseDouble(avrTemperature);
        this.maxTemperature = Double.parseDouble(maxTemperature);
        this.minTemperature = Double.parseDouble(minTemperature);
        this.pressure = Double.parseDouble(pressure);
        this.windSpead = Double.parseDouble(windSpead);
        this.wet = Double.parseDouble(wet);
        this.rain = Double.parseDouble(rain);
    }

    public LocalDate getDate() {
        return date;
    }
    public double getAvrTemperature() {
        return avrTemperature;
    }
    public double getMaxTemperature() {
        return maxTemperature;
    }
    public double getMinTemperature() {
        return minTemperature;
    }
    public double getPressure() {
        return pressure;
    }
    public double getWindSpead() {
        return windSpead;
    }
    public double getWet() {
        return wet;
    }
    public double getRain() {
        return rain;
    }
    @Override
    public int compareTo(MeteoData o) {
        Double first=getMaxTemperature();
        Double second=o.getMaxTemperature();
        return second.compareTo(first);
    }
}
