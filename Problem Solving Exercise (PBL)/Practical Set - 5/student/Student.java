package student;

/*
 * Student class in package 'student'
 * Data members: rollNo, name
 * Constructor to initialize student details
 * Method displayStudent() to display student information
 */

public class Student {
    protected int rollNo;
    protected String name;
    
    // Constructor to initialize student details
    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }
    
    // Method to display student information
    public void displayStudent() {
        System.out.printf("Roll No: %d%n", rollNo);
        System.out.printf("Name: %s%n", name);
    }
}
