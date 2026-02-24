package exam;

import student.Student;

/*
 * Question 19: Write a Java program using packages to generate a mark sheet for students.
 * Package student contains: Student class with rollNo, name, and displayStudent()
 * Package exam contains: Result class extending Student with marks1, marks2, marks3
 * and displayResult() method
 * Create a student with marks and display the mark sheet
 */

public class Q19 {
    public static void main(String[] args) {
        System.out.println("===== Mark Sheet Generation System (Using Packages) =====");
        
        // Create students with marks
        Result student1 = new Result(101, "Alice Johnson", 85, 90, 88);
        Result student2 = new Result(102, "Bob Smith", 75, 78, 82);
        Result student3 = new Result(103, "Charlie Brown", 92, 95, 93);
        Result student4 = new Result(104, "Diana Prince", 65, 70, 72);
        Result student5 = new Result(105, "Eve Wilson", 55, 60, 58);
        
        // Display mark sheets
        System.out.println("\n--- Student 1 Mark Sheet ---");
        student1.displayResult();
        
        System.out.println("\n--- Student 2 Mark Sheet ---");
        student2.displayResult();
        
        System.out.println("\n--- Student 3 Mark Sheet ---");
        student3.displayResult();
        
        System.out.println("\n--- Student 4 Mark Sheet ---");
        student4.displayResult();
        
        System.out.println("\n--- Student 5 Mark Sheet ---");
        student5.displayResult();
        
        // Display summary
        System.out.println("\n===== Class Summary =====\n");
        Result[] students = {student1, student2, student3, student4, student5};
        double totalAverage = 0;
        int passCount = 0;
        int failCount = 0;
        
        System.out.printf("%-15s %-15s %-10s %-10s%n", "Roll No", "Name", "Average", "Grade");
        System.out.println("----------------------------------------------");
        
        for (Result student : students) {
            System.out.printf("%-15d %-15s %-10.2f %-10s%n", 
                            student.getRollNo(), student.getName(), student.getAverage(), student.getGrade());
            totalAverage += student.getAverage();
            if (student.getAverage() >= 50) {
                passCount++;
            } else {
                failCount++;
            }
        }
        
        System.out.println("----------------------------------------------");
        System.out.printf("Class Average: %.2f%n", totalAverage / students.length);
        System.out.printf("Pass Count: %d%n", passCount);
        System.out.printf("Fail Count: %d%n", failCount);
    }
}

/*
 * Output:
 * 
 * ===== Mark Sheet Generation System (Using Packages) =====
 * 
 * --- Student 1 Mark Sheet ---
 * 
 * ╔════════════════════════════════════════╗
 * ║           STUDENT MARK SHEET            ║
 * ╠════════════════════════════════════════╣
 * ║ Roll No: 101
 * ║ Name: Alice Johnson
 * ╠════════════════════════════════════════╣
 * ║ Subject 1 Marks: 85.00                  ║
 * ║ Subject 2 Marks: 90.00                  ║
 * ║ Subject 3 Marks: 88.00                  ║
 * ╠════════════════════════════════════════╣
 * ║ Total Marks: 263.00                     ║
 * ║ Average: 87.67                          ║
 * ║ Grade: A                                ║
 * ╚════════════════════════════════════════╝
 * 
 * (Similar output for other students...)
 * 
 * ===== Class Summary =====
 * 
 * Roll No         Name            Average    Grade
 * -----------------------------------------------
 * 101             Alice Johnson   87.67      A
 * 102             Bob Smith       78.33      B
 * 103             Charlie Brown   93.33      A+
 * 104             Diana Prince    69.00      C
 * 105             Eve Wilson      57.67      D
 * -----------------------------------------------
 * Class Average: 77.20
 * Pass Count: 5
 * Fail Count: 0
 */
