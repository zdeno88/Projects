package cz.engeto.projekt2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class VATData {
    @JsonProperty("last_updated")
    private String last_updated;
    @JsonProperty("disclaimer")
    private String disclaimer;
    @JsonProperty("rates")
    private Map<String,State>rates=new HashMap<>();

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public Map<String, State> getRates() {
        return rates;
    }

    public void setRates(Map<String, State> rates) {
        this.rates = rates;
    }
}
