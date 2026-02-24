/*
 * Question 17: Write Java code for an interface named Exam which declares a single
 * abstract method boolean isPassed(int mark). This method should take an integer mark as an argument.
 * Write Java code for another interface named Classify which declares a single abstract method
 * String getDivision(double average). This method should take a double average as an argument.
 * Create a class named Result that implements both the Exam and Classify interfaces.
 * Provide concrete implementations for isPassed() and getDivision() methods.
 * In your main method, create an instance of Result, set some marks and average,
 * and demonstrate the use of both interface methods.
 */

// First interface - Exam
interface Exam {
    boolean isPassed(int mark);
}

// Second interface - Classify
interface Classify17 {
    String getDivision(double average);
}

// Class implementing both interfaces
class Result17 implements Exam, Classify17 {
    public String studentName;
    public int marks;
    public double average;
    private static final int PASSING_MARKS = 40;
    
    // Constructor
    public Result17(String name, int marks, double average) {
        this.studentName = name;
        this.marks = marks;
        this.average = average;
    }
    
    // Implementation of isPassed() method from Exam interface
    @Override
    public boolean isPassed(int mark) {
        return mark >= PASSING_MARKS;
    }
    
    // Implementation of getDivision() method from Classify interface
    @Override
    public String getDivision(double average) {
        if (average >= 75) {
            return "Distinction";
        } else if (average >= 60) {
            return "First Division";
        } else if (average >= 45) {
            return "Second Division";
        } else if (average >= 35) {
            return "Third Division";
        } else {
            return "Fail";
        }
    }
    
    // Method to display complete result
    public void displayCompleteResult() {
        System.out.printf("%-20s: %s%n", "Student Name", studentName);
        System.out.printf("%-20s: %d%n", "Marks Obtained", marks);
        System.out.printf("%-20s: %.2f%n", "Average Score", average);
        System.out.printf("%-20s: %s%n", "Pass/Fail Status", isPassed(marks) ? "PASSED" : "FAILED");
        System.out.printf("%-20s: %s%n", "Division", getDivision(average));
        System.out.println("--------------------------------------------");
    }
}

class Q17 {
    public static void main(String[] args) {
        System.out.println("===== Multiple Interface Implementation =====\n");
        
        // Create Result objects with different marks and averages
        Result17 result1 = new Result17("Alice Johnson", 85, 88.5);
        Result17 result2 = new Result17("Bob Smith", 72, 75.0);
        Result17 result3 = new Result17("Charlie Brown", 62, 65.5);
        Result17 result4 = new Result17("Diana Prince", 45, 50.0);
        Result17 result5 = new Result17("Eve Wilson", 35, 40.5);
        Result17 result6 = new Result17("Frank Davis", 25, 28.0);
        
        // Display results using interface methods
        System.out.println("--- Student 1 ---");
        result1.displayCompleteResult();
        System.out.println();
        
        System.out.println("--- Student 2 ---");
        result2.displayCompleteResult();
        System.out.println();
        
        System.out.println("--- Student 3 ---");
        result3.displayCompleteResult();
        System.out.println();
        
        System.out.println("--- Student 4 ---");
        result4.displayCompleteResult();
        System.out.println();
        
        System.out.println("--- Student 5 ---");
        result5.displayCompleteResult();
        System.out.println();
        
        System.out.println("--- Student 6 ---");
        result6.displayCompleteResult();
        System.out.println();
        
        // Demonstrate interface polymorphism
        System.out.println("===== Interface Polymorphism Demonstration =====\n");
        
        Result17[] results = {result1, result2, result3, result4, result5, result6};
        
        System.out.println("Using Exam Interface (isPassed):");
        System.out.println("---------------------------------");
        for (Result17 result : results) {
            System.out.printf("%s - Marks: %d - %s%n", 
                            result.studentName, 
                            result.marks, 
                            result.isPassed(result.marks) ? "PASSED" : "FAILED");
        }
        
        System.out.println("\nUsing Classify Interface (getDivision):");
        System.out.println("----------------------------------------");
        for (Result17 result : results) {
            System.out.printf("%s - Average: %.2f - Division: %s%n", 
                            result.studentName, 
                            result.average, 
                            result.getDivision(result.average));
        }
        
        // Test interface references directly
        System.out.println("\n===== Testing Interface References Directly =====\n");
        
        Exam examTest = result1;
        Classify17 classifyTest = result1;
        
        System.out.printf("Using Exam interface reference: %b%n", examTest.isPassed(85));
        System.out.printf("Using Classify interface reference: %s%n", classifyTest.getDivision(88.5));
    }
}

/*
 * Output:
 * 
 * ===== Multiple Interface Implementation =====
 * 
 * --- Student 1 ---
 * Student Name      : Alice Johnson
 * Marks Obtained    : 85
 * Average Score     : 88.50
 * Pass/Fail Status  : PASSED
 * Division          : Distinction
 * --------------------------------------------
 * 
 * --- Student 2 ---
 * Student Name      : Bob Smith
 * Marks Obtained    : 72
 * Average Score     : 75.00
 * Pass/Fail Status  : PASSED
 * Division          : First Division
 * --------------------------------------------
 * 
 * --- Student 3 ---
 * Student Name      : Charlie Brown
 * Marks Obtained    : 62
 * Average Score     : 65.50
 * Pass/Fail Status  : PASSED
 * Division          : First Division
 * --------------------------------------------
 * 
 * --- Student 4 ---
 * Student Name      : Diana Prince
 * Marks Obtained    : 45
 * Average Score     : 50.00
 * Pass/Fail Status  : PASSED
 * Division          : Second Division
 * --------------------------------------------
 * 
 * --- Student 5 ---
 * Student Name      : Eve Wilson
 * Marks Obtained    : 35
 * Average Score     : 40.50
 * Pass/Fail Status  : FAILED
 * Division          : Third Division
 * --------------------------------------------
 * 
 * --- Student 6 ---
 * Student Name      : Frank Davis
 * Marks Obtained    : 25
 * Average Score     : 28.00
 * Pass/Fail Status  : FAILED
 * Division          : Fail
 * --------------------------------------------
 * 
 * ===== Interface Polymorphism Demonstration =====
 * 
 * Using Exam Interface (isPassed):
 * ---------------------------------
 * Alice Johnson - Marks: 85 - PASSED
 * Bob Smith - Marks: 72 - PASSED
 * Charlie Brown - Marks: 62 - PASSED
 * Diana Prince - Marks: 45 - PASSED
 * Eve Wilson - Marks: 35 - FAILED
 * Frank Davis - Marks: 25 - FAILED
 * 
 * Using Classify Interface (getDivision):
 * ----------------------------------------
 * Alice Johnson - Average: 88.50 - Division: Distinction
 * Bob Smith - Average: 75.00 - Division: First Division
 * Charlie Brown - Average: 65.50 - Division: First Division
 * Diana Prince - Average: 50.00 - Division: Second Division
 * Eve Wilson - Average: 40.50 - Division: Third Division
 * Frank Davis - Average: 28.00 - Division: Fail
 * 
 * ===== Testing Interface References Directly =====
 * 
 * Using Exam interface reference: true
 * Using Classify interface reference: Distinction
 */
