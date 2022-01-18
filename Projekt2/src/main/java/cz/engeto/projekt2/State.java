package cz.engeto.projekt2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class State {
    @JsonProperty("_comment")
    private String _comment;
    @JsonProperty("iso_duplicate")
    private String iso_duplicate;

    @JsonProperty("country")
    private String country;
    @JsonProperty("standard_rate")
    private String standard_rate;
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
        return "State{" +
                "country='" + country + '\'' +
                ", standard_rate=" + standard_rate +
                ", reduced_rate=" + reduced_rate +
                ", reduced_rate_alt=" + reduced_rate_alt +
                ", super_reduced_rate=" + super_reduced_rate +
                ", parking_rate=" + parking_rate +
                '}';
    }

}
