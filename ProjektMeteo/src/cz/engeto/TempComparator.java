package cz.engeto;

import java.util.Comparator;

public class TempComparator implements Comparator<MeteoData> {
    @Override
    public int compare(MeteoData o1, MeteoData o2) {
        Double fir=o1.getMinTemperature();
        Double sec=o2.getMinTemperature();
        return fir.compareTo(sec);
    }
}
