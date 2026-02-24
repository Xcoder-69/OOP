/*
 * Question 16: Given an interface Classify with a method String getDivision(double average).
 * Implement this getDivision method in a class Result such that it returns "First Division"
 * if the average is 60 or more.
 */

// Interface Classify
interface Classify {
    String getDivision(double average);
}

// Class Result implementing the Classify interface
class Result implements Classify {
    private String studentName;
    private double average;
    
    // Constructor
    public Result(String name, double avg) {
        this.studentName = name;
        this.average = avg;
    }
    
    // Implementation of getDivision method
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
    
    // Method to display result details
    public void displayResult() {
        System.out.printf("Student Name: %s%n", studentName);
        System.out.printf("Average Score: %.2f%n", average);
        System.out.printf("Division: %s%n", getDivision(average));
        System.out.println("----------------------------------");
    }
}

class Q16 {
    public static void main(String[] args) {
        System.out.println("===== Student Result Classification =====\n");
        
        // Create Result objects with different averages
        Result result1 = new Result("Alice Smith", 85.5);
        Result result2 = new Result("Bob Johnson", 72.0);
        Result result3 = new Result("Charlie Brown", 65.0);
        Result result4 = new Result("Diana Prince", 55.5);
        Result result5 = new Result("Eve Wilson", 40.0);
        Result result6 = new Result("Frank Davis", 28.5);
        
        // Display results
        System.out.println("Student 1:");
        result1.displayResult();
        System.out.println();
        
        System.out.println("Student 2:");
        result2.displayResult();
        System.out.println();
        
        System.out.println("Student 3:");
        result3.displayResult();
        System.out.println();
        
        System.out.println("Student 4:");
        result4.displayResult();
        System.out.println();
        
        System.out.println("Student 5:");
        result5.displayResult();
        System.out.println();
        
        System.out.println("Student 6:");
        result6.displayResult();
        System.out.println();
        
        // Demonstrate interface polymorphism
        System.out.println("===== Interface Polymorphism Demonstration =====\n");
        Classify[] classifyArray = new Classify[6];
        classifyArray[0] = result1;
        classifyArray[1] = result2;
        classifyArray[2] = result3;
        classifyArray[3] = result4;
        classifyArray[4] = result5;
        classifyArray[5] = result6;
        
        double[] averages = {85.5, 72.0, 65.0, 55.5, 40.0, 28.5};
        
        System.out.println("Classification using interface reference:\n");
        for (int i = 0; i < classifyArray.length; i++) {
            String division = classifyArray[i].getDivision(averages[i]);
            System.out.printf("Average: %.2f -> Division: %s%n", averages[i], division);
        }
    }
}

/*
 * Output:
 * 
 * ===== Student Result Classification =====
 * 
 * Student 1:
 * Student Name: Alice Smith
 * Average Score: 85.50
 * Division: Distinction
 * ----------------------------------
 * 
 * Student 2:
 * Student Name: Bob Johnson
 * Average Score: 72.00
 * Division: First Division
 * ----------------------------------
 * 
 * Student 3:
 * Student Name: Charlie Brown
 * Average Score: 65.00
 * Division: First Division
 * ----------------------------------
 * 
 * Student 4:
 * Student Name: Diana Prince
 * Average Score: 55.50
 * Division: Second Division
 * ----------------------------------
 * 
 * Student 5:
 * Student Name: Eve Wilson
 * Average Score: 40.00
 * Division: Third Division
 * ----------------------------------
 * 
 * Student 6:
 * Student Name: Frank Davis
 * Average Score: 28.50
 * Division: Fail
 * ----------------------------------
 * 
 * ===== Interface Polymorphism Demonstration =====
 * 
 * Classification using interface reference:
 * 
 * Average: 85.50 -> Division: Distinction
 * Average: 72.00 -> Division: First Division
 * Average: 65.00 -> Division: First Division
 * Average: 55.50 -> Division: Second Division
 * Average: 40.00 -> Division: Third Division
 * Average: 28.50 -> Division: Fail
 */
