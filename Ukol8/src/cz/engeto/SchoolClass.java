package cz.engeto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class SchoolClass implements GetInfo{
    int numberOfClass;
    char letterOfClass;
    Teacher teacher;
    List<Student> studentList=new ArrayList<>();
    final String FILE_NAME ="SchoolClass.txt";
    public SchoolClass(int numberOfClass, char letterOfClass, Teacher teacher) {
        this.numberOfClass = numberOfClass;
        this.letterOfClass = letterOfClass;
        this.teacher = teacher;
    }
    public void addStudents(Student student){
        studentList.add(student);
    }
    @Override
    public String getIngo() {
        StringBuilder result=new StringBuilder();
        result.append("####################################\n").
                append("Třída: ").append(getNumberOfClass()).append(".").append(getLetterOfClass()).append(" (ročník: ").append(getNumberOfClass()).append(")\n").
                append("Třídní učitel: ").append(teacher.getIngo()).append("\n").
                append("Počet studentů: ").append(studentList.size());

        return result.toString();
    }
    public String getMoreInfo(){
        StringBuilder result=new StringBuilder();
        int number=0;
        result.append("####################################\n");
        for (Student student:studentList) {
            ++number;
            result.append("# ").append(number).append(" ").append(student.getIngo()).append("\n");

        }
        return result.toString();
    }
    public int getNumberOfClass() {
        return numberOfClass;
    }
    public char getLetterOfClass() {
        return letterOfClass;
    }
    public void printToFile(){
        try (BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(new File(FILE_NAME)))){
            bufferedWriter.write(getIngo());
            bufferedWriter.write("\n");
            bufferedWriter.write(getMoreInfo());
        }
        catch (Exception ex){
            System.out.println("Slozka nenalezena");
        }
    }
}
