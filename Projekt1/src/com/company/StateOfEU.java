package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StateOfEU {

    List<State>listOfSate=new ArrayList();
    final String PATH_NAME_FROM="State.txt";
    File fileFrom=new File(PATH_NAME_FROM);
    final String REGET="\t";
    static int lineNumber;
    final String PATH_NAME_TO="vat-over-20.txt";
    File fileTo=new File(PATH_NAME_TO);
    String numberForSearching;

    public void loadingFromFile()throws StateException{
        try (Scanner scanner=new Scanner(fileFrom)){
            while (scanner.hasNextLine()){
                String testCharacter= scanner.nextLine();
                for (int i=0;i<testCharacter.length();i++){
                    if (testCharacter.charAt(i)==','){
                        testCharacter=testCharacter.replace(",",".");

                    }
                }
                String []nextLine=testCharacter.split(REGET);
                lineNumber++;
                if (nextLine.length!=5){
                    throw new StateException("Chyba pri cteni na radku: "+lineNumber);
                }
                listOfSate.add(new State(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4]));
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Vstupni slozka nenalezena");
        }
    }
    public void writingToFile(){
        try (BufferedWriter bw=new BufferedWriter(new FileWriter(fileTo))){
            bw.write(getStateOfEUInfoTask5());
        }
        catch (IOException e) {
            System.out.println("Slozka k zapisu nenalezena");
        }
    }
    public String getStateOfEUInfo(){
        StringBuilder result=new StringBuilder();
        System.out.println();
        for (State state:listOfSate) {
            result.append(state.getStateInfoFormat1());
        }
        return result.toString();
    }
    public String getrStateOfEUInfo(){
        StringBuilder result=new StringBuilder();
        System.out.println();
        for (State state:listOfSate) {
            result.append(state.getStateInfoFormat1());
        }
        return result.toString();
    }
    public String getParticularStateOfEUInfo(){
        StringBuilder result=new StringBuilder();
        System.out.println();
        for (State state:listOfSate) {
            if (!state.isSpecialRateOfDPH()&&state.getDph()>20)
            result.append(state.getStateInfoFormat1());
        }
        return result.toString();
    }
    public String getStateOfEUInfoTask5(){
        StringBuilder result=new StringBuilder();
        StringBuilder result1=new StringBuilder();
        String result2;
        System.out.println();
        for (State state:listOfSate) {
            if (!state.isSpecialRateOfDPH()&&state.getDph()>20) {
                result.append(state.getStateInfoFormat2());
            }
            else{
                result1.append(state.getCodeOfState()).append(", ");
            }

        }
        result2="====================\nSazba VAT 20 % nebo nižší nebo používají speciální sazbu: ";
        return result.append(result2).append(result1).toString();
    }
    public void setNumberForSearching(String numberForSearching) {
        this.numberForSearching = numberForSearching;
    }
    public String getStateOfEUInfoTask7(){
        StringBuilder result=new StringBuilder();
        StringBuilder result1=new StringBuilder();
        String result2;
        System.out.println();
        for (State state:listOfSate) {
            if (numberForSearching.equals("")) {
                if (!state.isSpecialRateOfDPH() && state.getDph() > 20) {
                    result.append(state.getStateInfoFormat2());
                } else {
                    result1.append(state.getCodeOfState()).append(", ");
                }
            }
            else {
                if (!state.isSpecialRateOfDPH() && state.getDph() > Integer.parseInt(numberForSearching)) {
                    result.append(state.getStateInfoFormat2());
                } else {
                    result1.append(state.getCodeOfState()).append(", ");
                }
            }
        }
        if (numberForSearching.equals("")) {
            result2 = "====================\nSazba VAT 20 % nebo nižší nebo používají speciální sazbu: ";
            return result.append(result2).append(result1).toString();
        }
        result2 = "====================\nSazba VAT " + numberForSearching + " % nebo nižší nebo používají speciální sazbu: ";
        return result.append(result2).append(result1).toString();
    }
    public void writingToFileTask7(){
        String pathNameTask7;
        if (numberForSearching.equals("")){
            pathNameTask7="C:\\Users\\skaryd\\Documents\\Engeto\\Projekt\\Projekt1\\vat-over-20.txt";
        }
        else pathNameTask7="C:\\Users\\skaryd\\Documents\\Engeto\\Projekt\\Projekt1\\vat-over-"+numberForSearching+".txt";
        File fileTo=new File(pathNameTask7);
        try (BufferedWriter bw=new BufferedWriter(new FileWriter(fileTo))){
            bw.write(getStateOfEUInfoTask7());
        }
        catch (IOException e) {
            System.out.println("Slozka k zapisu nenalezena");
        }
    }
}
