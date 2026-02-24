/*
 * Question 11: Write a Java program to model a college admission system using inner classes.
 * Create an outer class named College that stores the collegeName as a data member and initializes it
 * through a constructor. Within the College class, define a non-static inner class named Admission
 * that contains student-specific details such as the studentName and course they are enrolling in.
 * The inner class should have methods to accept and display student information, and it should also
 * be able to access and display the collegeName stored in the outer class. 
 * In the main method, create an object of the College class by passing the collegeName,
 * and then use this object to create an instance of the inner Admission class.
 * Invoke appropriate methods to input the student's name and course, and then display the complete
 * admission details, including the college name.
 */

import java.util.Scanner;

class College {
    // Data member of outer class
    private String collegeName;
    
    // Constructor of outer class
    public College(String collegeName) {
        this.collegeName = collegeName;
    }
    
    // Non-static inner class
    class Admission {
        // Data members of inner class
        private String studentName;
        private String course;
        
        // Constructor of inner class
        public Admission() {
            this.studentName = "";
            this.course = "";
        }
        
        // Method to accept student information
        public void acceptStudentData() {
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Enter student name: ");
            this.studentName = scanner.nextLine();
            
            System.out.print("Enter course name: ");
            this.course = scanner.nextLine();
        }
        
        // Method to display student information
        public void displayAdmissionDetails() {
            System.out.println("\n====== Admission Details ======");
            System.out.printf("College Name: %s%n", collegeName);  // Accessing outer class member
            System.out.printf("Student Name: %s%n", studentName);
            System.out.printf("Course: %s%n", course);
            System.out.println("================================\n");
        }
    }
}

class Q11 {
    public static void main(String[] args) {
        System.out.println("===== College Admission System =====\n");
        
        // Create an object of the College class
        College college1 = new College("XYZ University");
        College college2 = new College("ABC Institute of Technology");
        
        // Create instances of the inner Admission class
        College.Admission admission1 = college1.new Admission();
        College.Admission admission2 = college2.new Admission();
        
        // Accept student data for first admission
        System.out.println("--- Student Admission 1 ---");
        admission1.acceptStudentData();
        
        // Accept student data for second admission
        System.out.println("\n--- Student Admission 2 ---");
        admission2.acceptStudentData();
        
        // Display admission details
        System.out.println("\n===== Admission Details =====");
        admission1.displayAdmissionDetails();
        admission2.displayAdmissionDetails();
    }
}

/*
 * Output:
 * 
 * ===== College Admission System =====
 * 
 * --- Student Admission 1 ---
 * Enter student name: John Sharma
 * Enter course name: Computer Science
 * 
 * --- Student Admission 2 ---
 * Enter student name: Priya Patel
 * Enter course name: Mechanical Engineering
 * 
 * ===== Admission Details =====
 * 
 * ====== Admission Details ======
 * College Name: XYZ University
 * Student Name: John Sharma
 * Course: Computer Science
 * ================================
 * 
 * ====== Admission Details ======
 * College Name: ABC Institute of Technology
 * Student Name: Priya Patel
 * Course: Mechanical Engineering
 * ================================
 */
