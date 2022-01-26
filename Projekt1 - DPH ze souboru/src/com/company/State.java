package com.company;

public class State implements Comparable<State>{
    private String codeOfState;
    private String nameOfState;
    private double dph;
    private double vat;
    private boolean specialRateOfDPH;

    public State(String codeOfState, String nameOfState, String dph, String vat, String specialRate) {
        try {
            this.codeOfState = codeOfState;
            this.nameOfState = nameOfState;
            this.dph = Double.parseDouble(dph);
            this.vat = Double.parseDouble(vat);
            this.specialRateOfDPH = Boolean.parseBoolean(specialRate);
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
            return getNameOfState()+" ("+getCodeOfState()+"):\t\t\t\t"+(int)getDph()+" % ("+getVat()+" %)\n";
        else if (getNameOfState().length()<11)
        return getNameOfState()+" ("+getCodeOfState()+"):\t\t\t"+(int)getDph()+" % ("+getVat()+" %)\n";
        else if (getNameOfState().length()==11)
            return getNameOfState()+" ("+getCodeOfState()+"):\t\t"+(int)getDph()+" % ("+getVat()+" %)\n";
        else
            return getNameOfState()+" ("+getCodeOfState()+"):\t"+(int)getDph()+" % ("+getVat()+" %)\n";
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

    public double getDph() {
        return dph;
    }
    public void setDph(int dph) {
        this.dph = dph;
    }

    public double getVat() {
        return vat;
    }
    public void setVat(int vat) {
        this.vat = vat;
    }

    public boolean isSpecialRateOfDPH() {
        return specialRateOfDPH;
    }
    public void setSpecialRateOfDPH(boolean specialRateOfDPH) {
        this.specialRateOfDPH = specialRateOfDPH;
    }

    @Override
    public int compareTo(State second) {
        Double firstDPH=dph;
        Double secondDPH=second.dph;
        return secondDPH.compareTo(firstDPH);
    }
}
