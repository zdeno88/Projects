package cz.engeto;

import java.util.Comparator;

public class DateComparator implements Comparator<MeteoData> {
    @Override
    public int compare(MeteoData o1, MeteoData o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}
