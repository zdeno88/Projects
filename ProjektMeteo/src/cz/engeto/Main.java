package cz.engeto;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        MeteoStation meteoStation=new MeteoStation();
        meteoStation.loadFromFile();
        System.out.println(meteoStation.welcoming());
        System.out.println("We have "+meteoStation.meteoDataList.size()+" meteorological daily records to analyze.");
        System.out.println(meteoStation.getAvrTemperature());
        Collections.sort(meteoStation.meteoDataList);
        System.out.println(meteoStation.getMaxTemp());
        Collections.sort(meteoStation.meteoDataList,new TempComparator());
        System.out.println(meteoStation.getMinTemp());
        System.out.println(meteoStation.getWindyDays());
        System.out.println(meteoStation.getCalmDays());
        System.out.println(meteoStation.getRaining());
        System.out.println("--------------------------------------------------------------------------------");
        Collections.sort(meteoStation.meteoDataList,new DateComparator());
        System.out.println(meteoStation.getRangeTemp());
        System.out.println("--------------------------------------------------------------------------------");


    }
}
