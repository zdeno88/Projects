package cz.engeto.projekt2;

import java.util.HashMap;
import java.util.Map;

public class VATData {
    private String last_updated;
    private String disclaimer;
    private Map<String,Object>rates=new HashMap<>();

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

    public Map<String, Object> getRates() {
        return rates;
    }

    public void setRates(Map<String, Object> rates) {
        this.rates = rates;
    }
}
