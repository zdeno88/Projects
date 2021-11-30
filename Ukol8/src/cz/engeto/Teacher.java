package cz.engeto;

public class Teacher extends Person implements GetInfo{
    public Teacher(String name, String surname) {
        super(name, surname);
    }
    @Override
    public String printIngo() {
        return surname+", "+name;
    }
}
