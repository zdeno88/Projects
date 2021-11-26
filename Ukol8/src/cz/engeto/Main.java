package cz.engeto;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Student student1=new Student("Petr","Svoboda", LocalDate.of(2011,1,15));
        Student student2=new Student("Milan","Riha", LocalDate.of(2010,10,25));
        Student student3=new Student("Jindrich","Novy", LocalDate.of(2012,6,30));
        Teacher teacher1=new Teacher("Jan","Novak");
        SchoolClass schoolClass1=new SchoolClass(4,'C',teacher1);
        schoolClass1.addStudents(student1);
        schoolClass1.addStudents(student2);
        schoolClass1.addStudents(student3);
        System.out.println(schoolClass1.getIngo());
        System.out.println(schoolClass1.getMoreInfo());
        schoolClass1.printToFile();
    }
}
