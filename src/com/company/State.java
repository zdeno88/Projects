package com.company;

import java.util.Comparator;

public class State implements Comparable<State>{
    private String codeOfState;
    private String nameOfState;
    private int dph;
    private int vat;
    private boolean specialRate;

    public State(String codeOfState, String nameOfState, String dph, String vat, String specialRate) {
        try {
            this.codeOfState = codeOfState;
            this.nameOfState = nameOfState;
            this.dph = Integer.parseInt(dph);
            this.vat = Integer.parseInt(vat);
            this.specialRate = Boolean.parseBoolean(specialRate);
        }
        catch (NumberFormatException e){
            System.out.println("Spatne zadany format cisla na radku: "+StateOfEU.lineNumber);
        }
    }
    public String getStateInfoFormat1(){
        return getNameOfState()+" ("+getCodeOfState()+"):\t"+(int)getDph()+" %\n";
    }
    public String getStateInfoFormat2(){
        if (getNameOfState().length()<6)
            return getNameOfState()+" ("+getCodeOfState()+"):\t\t\t\t"+getDph()+" % ("+getVat()+" %)\n";
        else if (getNameOfState().length()<11)
        return getNameOfState()+" ("+getCodeOfState()+"):\t\t\t"+getDph()+" % ("+getVat()+" %)\n";
        else if (getNameOfState().length()==11)
            return getNameOfState()+" ("+getCodeOfState()+"):\t\t"+getDph()+" % ("+getVat()+" %)\n";
        else
            return getNameOfState()+" ("+getCodeOfState()+"):\t"+getDph()+" % ("+getVat()+" %)\n";
    }

    public String getCodeOfState() {
        return codeOfState;
    }
    public void setCodeOfState(String codeOfState) {
        this.codeOfState = codeOfState;
    }

    public String getNameOfState() {
        return nameOfState;
    }
    public void setNameOfState(String nameOfState) {
        this.nameOfState = nameOfState;
    }

    public int getDph() {
        return dph;
    }
    public void setDph(int dph) {
        this.dph = dph;
    }

    public int getVat() {
        return vat;
    }
    public void setVat(int vat) {
        this.vat = vat;
    }

    public boolean isSpecialRate() {
        return specialRate;
    }
    public void setSpecialRate(boolean specialRate) {
        this.specialRate = specialRate;
    }

    @Override
    public int compareTo(State second) {
        Integer firstDPH=dph;
        Integer secondDPH=second.dph;
        return secondDPH.compareTo(firstDPH);
    }
}
