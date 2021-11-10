package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StateOfEU {

    List<State>listOfSate=new ArrayList();
    final String PATH_NAME="C:\\Users\\skaryd\\Documents\\Engeto\\Projekt\\Projekt1\\State.txt";
    final String REGET="\t";
    File file=new File(PATH_NAME);
    static int lineNumber;

    public void loadingFromFile()throws StateException{
        try (Scanner scanner=new Scanner(file)){
            while (scanner.hasNextLine()){
                String []nextLine=scanner.nextLine().split(REGET);
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
            if (!state.isSpecialRate()&&state.getDph()>20)
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
            if (!state.isSpecialRate()&&state.getDph()>20) {
                result.append(state.getStateInfoFormat2());
            }
            else{
                result1.append(state.getCodeOfState()).append(", ");
            }

        }
        result2="====================\nSazba VAT 20 % nebo nižší nebo používají speciální sazbu: ";
        return result.append(result2).append(result1).toString();
    }
}
