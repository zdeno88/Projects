package cz.engeto.projekt2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class VATData {
    @JsonProperty("last_updated")
    private String last_updated;
    @JsonProperty("disclaimer")
    private String disclaimer;
    @JsonProperty("rates")
    private Map<String, State> rates = new HashMap<>();
    final String PATH_NAME_TO = "State.txt";
    List<State> stateList = new ArrayList<>();
    File fileTo = new File(PATH_NAME_TO);

    public void loadingStateList() {
        for (State o : getRates().values()) {
            stateList.add(o);
        }
        stateList.sort(State::compareTo);
    }

    public String printingFirstLowest() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("První tři s nejnižší sazbou DPH:\n");
        for (int i = 0; i < 3; i++) {
            stringBuilder.append(stateList.get(i) + "\n");
        }
        return stringBuilder.toString();
    }

    public String printingFirstHighest() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("První tři s nejvyšší sazbou DPH:\n");
        Collections.reverse(stateList);
        for (int i = 0; i < 3; i++) {
            stringBuilder.append(stateList.get(i) + "\n");
        }
        return stringBuilder.toString();
    }

    public void writtingToFile() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATH_NAME_TO))) {
            bw.write(printingFirstLowest());
            bw.write("\n");
            bw.write(printingFirstHighest());
        } catch (FileNotFoundException ex) {
            System.out.println("Slozka k zapisu nenalezena");
        }
    }

    public String findingAccordingCode() {

        Scanner scanner = new Scanner(System.in);
        String memory;
        do {
            System.out.println("Vyhledávač daní dle kódu země:");
            memory = scanner.nextLine().toUpperCase(Locale.ROOT);
        }
        while (!getRates().containsKey(memory));
        return getRates().get(memory).toString();
    }

    public Map<String, State> getRates() {
        return rates;
    }

    public void setRates(Map<String, State> rates) {
        this.rates = rates;
    }
}
