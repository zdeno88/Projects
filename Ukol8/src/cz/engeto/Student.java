package cz.engeto;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Student extends Person implements GetInfo {
    private static int counter = 0;
    private final LocalDate dateOfBirhtday;
    private final String IDnumber;
    StringBuilder result = new StringBuilder();
    private static final DecimalFormat decimalFormat = new DecimalFormat("0000");

    public Student(String name, String surname, LocalDate dateOfBirhtday) {
        super(name, surname);
        this.dateOfBirhtday = dateOfBirhtday;
        String id = "ID";
        IDnumber = result.append(id).append(decimalFormat.format(setNumber())).toString();
    }

    public int setNumber() {
        return ++counter;
    }

    @Override
    public String printIngo() {
        return "# " + IDnumber + " - " + name + " " + surname + " (" + dateOfBirhtday.getYear() + ")";
    }
}
