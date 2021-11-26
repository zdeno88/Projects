package cz.engeto;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MeteoStation{
    final String PATH_FROM ="B2BTUR01_07_2019.csv";
    List<MeteoData> meteoDataList=new ArrayList<>();
    public void loadFromFile(){
        try (Scanner scanner=new Scanner(new File(PATH_FROM))){
            int counter=0;
            String nextLine="";
            String []data=new String[10];
            while (scanner.hasNextLine()){
                counter++;
                nextLine= scanner.nextLine();
                if(counter!=1){
                    data=nextLine.split(",");
                    meteoDataList.add(new MeteoData(LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]))
                            , data[3], data[4], data[5], data[6], data[7], data[8], data[9]));
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Vstupni slozka nenalezena");
        }
    }
    public String welcoming(){
        return "--------------------------------------------------------------------------------\n" +
                "Welcome to the application for Meteorological Data Analysis.\n" +
                "--------------------------------------------------------------------------------";
    }
    public String getAvrTemperature(){
        double temperature=0;
        for (MeteoData temp: meteoDataList) {
            temperature+=temp.getAvrTemperature();
        }
        return "Average temperature for the reporting period: "+(double)Math.round(temperature/ meteoDataList.size()*10)/10+"°C";
    }
    public String getMaxTemp(){
        MeteoData meteoData= meteoDataList.get(0);
        return "Maximum temperature for the reporting period: "+meteoData.getDate()+" was "+meteoData.getMaxTemperature()+"°C";
    }
    public String getMinTemp(){
        MeteoData meteoData= meteoDataList.get(0);
        return "Minimum temperature for the reporting period: "+meteoData.getDate()+" was "+meteoData.getMinTemperature()+"°C";
    }
    public String getWindyDays(){
        double number;
        int counter=0;
        for (MeteoData obj:meteoDataList) {
            number=obj.getWindSpead();
            if (number>4.2)
                counter++;
        }
        return "Number of windy days: "+counter;
    }
    public String getCalmDays(){
        double number;
        int counter=0;
        for (MeteoData obj:meteoDataList) {
            number=obj.getWindSpead();
            if (number<=1.8)
                counter++;
        }
        return "Number of calm days : "+counter;
    }
    public String getRaining(){
        double number;
        double counter10 = 0;
        double counter20= 0;
        double rest= 0;
        for (MeteoData obj:meteoDataList) {
            number=obj.getRain();
            try {
                if (10>=obj.getDate().getDayOfMonth()) counter10+=number;
                else if (20>=obj.getDate().getDayOfMonth()) counter20+=number;
                else rest+=number;
            }
            catch (Exception e){

            }

        }
        return "Precipitation summary in month decades: "+(double)Math.round(counter10*10)/10+"mm - "+counter20+"mm - "+rest+"mm";
    }
    public String getRangeTemp(){
        StringBuilder result=new StringBuilder();
        String axisX="   | 00--------10--------20--------30--------40\n";
        int max,min;
        result.append(axisX);
        int counter=0;
        for (MeteoData obj:meteoDataList) {
            counter++;
            min= (int) Math.round(obj.getMinTemperature());
            max=(int)Math.round(obj.getMaxTemperature());
            if (counter<10)result.append("0"+counter+" | ");
            else result.append(counter+" |   ");
            for (int i=0;i<axisX.length();i++){
                if (i<min)result.append(" ");
                else if(min<=i&&i<=max)result.append("*");
                else result.append(" ");
            }
            result.append("\n");
        }
        return result.append(axisX).toString();
    }
}
