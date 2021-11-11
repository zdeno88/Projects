package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StateOfEU stateOfEU=new StateOfEU();
        try {
            stateOfEU.loadingFromFile();
        } catch (StateException e) {
            e.printStackTrace();
        }
        /* Vystup2 */
        System.out.println("Vystup2: \n"+stateOfEU.getrStateOfEUInfo());
//        /* Vystup3 */
//        System.out.println("Vystup3: \n"+stateOfEU.getParticularStateOfEUInfo());
//        /* Vystup4 */
//        Collections.sort(stateOfEU.listOfSate);
//        System.out.println("Vystup4: \n"+stateOfEU.getParticularStateOfEUInfo());
//        /* Vystup5 */
//        System.out.println("Vystup5: \n"+stateOfEU.getStateOfEUInfoTask5());
//        stateOfEU.writingToFile();
//        /* Vystup7 */
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("Zadej vysi sazby DPH pro filtrovani: ");
//        stateOfEU.setNumberForSearching(scanner.nextLine());
//        System.out.println("Vystup7: \n"+stateOfEU.getStateOfEUInfoTask7());
//        stateOfEU.writingToFileTask7();

    }
}
