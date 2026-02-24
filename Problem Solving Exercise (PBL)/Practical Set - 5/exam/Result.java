package exam;

import student.Student;

/*
 * Result class extending Student class
 * Has data members: marks1, marks2, marks3
 * Method displayResult() prints the student's mark sheet including total and average marks
 */

public class Result extends Student {
    private double marks1;
    private double marks2;
    private double marks3;
    
    // Constructor
    public Result(int rollNo, String name, double m1, double m2, double m3) {
        super(rollNo, name);
        this.marks1 = m1;
        this.marks2 = m2;
        this.marks3 = m3;
    }
    
    // Method to calculate total marks
    public double getTotal() {
        return marks1 + marks2 + marks3;
    }
    
    // Method to calculate average marks
    public double getAverage() {
        return getTotal() / 3;
    }
    
    // Method to get grade based on average
    public String getGrade() {
        double avg = getAverage();
        if (avg >= 90) {
            return "A+";
        } else if (avg >= 80) {
            return "A";
        } else if (avg >= 70) {
            return "B";
        } else if (avg >= 60) {
            return "C";
        } else if (avg >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
    
    // Getter methods
    public int getRollNo() {
        return rollNo;
    }
    
    public String getName() {
        return name;
    }
    
    // Method to display result/mark sheet
    public void displayResult() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║           STUDENT MARK SHEET            ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.printf("║ Roll No: %-30d    ║%n", rollNo);
        System.out.printf("║ Name: %-35s║%n", name);
        System.out.println("╠════════════════════════════════════════╣");
        System.out.printf("║ Subject 1 Marks: %-20.2f    ║%n", marks1);
        System.out.printf("║ Subject 2 Marks: %-20.2f    ║%n", marks2);
        System.out.printf("║ Subject 3 Marks: %-20.2f    ║%n", marks3);
        System.out.println("╠════════════════════════════════════════╣");
        System.out.printf("║ Total Marks: %-24.2f      ║%n", getTotal());
        System.out.printf("║ Average: %-28.2f        ║%n", getAverage());
        System.out.printf("║ Grade: %-30s    ║%n", getGrade());
        System.out.println("╚════════════════════════════════════════╝");
    }
}
