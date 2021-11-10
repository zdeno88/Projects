package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        final String PATH_NAME="C:\\Users\\skaryd\\Documents\\Engeto\\Projekt\\Projekt1\\vat-over-25.txt";
        File file=new File(PATH_NAME);
        StateOfEU stateOfEU=new StateOfEU();
        try {
            stateOfEU.loadingFromFile();
        } catch (StateException e) {
            e.printStackTrace();
        }
//        System.out.println("Vystup2: \n"+stateOfEU.getrStateOfEUInfo());
//        System.out.println("Vystup3: \n"+stateOfEU.getParticularStateOfEUInfo());
//        Collections.sort(stateOfEU.listOfSate);
//        System.out.println("Vystup4: \n"+stateOfEU.getParticularStateOfEUInfo());
        System.out.println("Vystup5: \n"+stateOfEU.getStateOfEUInfoTask5());

        try (BufferedWriter bw=new BufferedWriter(new FileWriter(file))){
            bw.write(stateOfEU.getStateOfEUInfoTask5());
        }
        catch (IOException e) {
            System.out.println("Slozka k zapisu nenalezena");;
        }
    }
}
