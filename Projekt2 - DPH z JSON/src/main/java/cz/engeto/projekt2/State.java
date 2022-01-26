package cz.engeto.projekt2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class State implements Comparable<State> {

    @JsonProperty("_comment")
    private String _comment;
    @JsonProperty("iso_duplicate")
    private String iso_duplicate;
    @JsonProperty("iso_duplicate_of")
    private String iso_duplicate_of;
    @JsonProperty("country")
    private String country;
    @JsonProperty("standard_rate")
    private double standard_rate;
    @JsonProperty("reduced_rate")
    private String reduced_rate;
    @JsonProperty("reduced_rate_alt")
    private String reduced_rate_alt;
    @JsonProperty("super_reduced_rate")
    private String super_reduced_rate;
    @JsonProperty("parking_rate")
    private String parking_rate;

    @Override
    public String toString() {
        return getCountry() + ":\t" + getStandard_rate() + "%";
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getStandard_rate() {
        return standard_rate;
    }

    public void setStandard_rate(double standard_rate) {
        this.standard_rate = standard_rate;
    }

    @Override
    public int compareTo(State second) {
        Double firstStandartRate = getStandard_rate();
        Double secondStandartRate = second.getStandard_rate();
        return firstStandartRate.compareTo(secondStandartRate);
    }
}
