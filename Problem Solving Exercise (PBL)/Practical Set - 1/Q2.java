/*
 * Question 2: Write a Java program to solve a system of two linear equations with two variables
 * (e.g., ax + by = e and cx + dy = f). Prompt the user to enter the coefficients a, b, c, d, e, f.
 * Calculate and display the values of x and y using Cramer's rule.
 * Include error handling for cases where the denominator is zero.
 * Cramer's rule: D = ad - bc, Dx = ed - bf, Dy = af - ce, x = Dx/D, y = Dy/D
 */

import java.util.Scanner;

class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user to enter coefficients
        System.out.println("Solve system of linear equations: ax + by = e and cx + dy = f");
        System.out.println();
        
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();
        
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();
        
        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();
        
        System.out.print("Enter coefficient d: ");
        double d = scanner.nextDouble();
        
        System.out.print("Enter constant e: ");
        double e = scanner.nextDouble();
        
        System.out.print("Enter constant f: ");
        double f = scanner.nextDouble();
        
        // Calculate determinant D = ad - bc
        double D = (a * d) - (b * c);
        
        // Error handling for zero denominator
        if (D == 0) {
            System.out.println("\nError: The system has no unique solution (D = 0).");
            System.out.println("The equations are either parallel or identical.");
        } else {
            // Calculate Dx = ed - bf
            double Dx = (e * d) - (b * f);
            
            // Calculate Dy = af - ce
            double Dy = (a * f) - (c * e);
            
            // Calculate x = Dx/D and y = Dy/D
            double x = Dx / D;
            double y = Dy / D;
            
            // Display results formatted to 2 decimal places
            System.out.println("\nSolution:");
            System.out.printf("D = %.2f%n", D);
            System.out.printf("Dx = %.2f%n", Dx);
            System.out.printf("Dy = %.2f%n", Dy);
            System.out.printf("x = %.2f%n", x);
            System.out.printf("y = %.2f%n", y);
            
            // Verify the solution
            double check1 = (a * x) + (b * y);
            double check2 = (c * x) + (d * y);
            System.out.println("\nVerification:");
            System.out.printf("%.2fx + %.2fy = %.2f (should be %.2f)%n", a, b, check1, e);
            System.out.printf("%.2fx + %.2fy = %.2f (should be %.2f)%n", c, d, check2, f);
        }
        
        scanner.close();
    }
}

/*
 * Output:
 * 
 * Sample Run 1:
 * Solve system of linear equations: ax + by = e and cx + dy = f
 * 
 * Enter coefficient a: 2
 * Enter coefficient b: 3
 * Enter coefficient c: 1
 * Enter coefficient d: 4
 * Enter constant e: 8
 * Enter constant f: 7
 * 
 * Solution:
 * D = 5.00
 * Dx = 11.00
 * Dy = 6.00
 * x = 2.20
 * y = 1.20
 * 
 * Verification:
 * 2.00x + 3.00y = 8.00 (should be 8.00)
 * 1.00x + 4.00y = 7.00 (should be 7.00)
 * 
 * 
 * Sample Run 2 (No unique solution):
 * Solve system of linear equations: ax + by = e and cx + dy = f
 * 
 * Enter coefficient a: 2
 * Enter coefficient b: 4
 * Enter coefficient c: 1
 * Enter coefficient d: 2
 * Enter constant e: 8
 * Enter constant f: 4
 * 
 * Error: The system has no unique solution (D = 0).
 * The equations are either parallel or identical.
 * 
 * 
 * Sample Run 3:
 * Solve system of linear equations: ax + by = e and cx + dy = f
 * 
 * Enter coefficient a: 3
 * Enter coefficient b: 2
 * Enter coefficient c: 1
 * Enter coefficient d: 5
 * Enter constant e: 9
 * Enter constant f: 8
 * 
 * Solution:
 * D = 13.00
 * Dx = 29.00
 * Dy = 15.00
 * x = 2.23
 * y = 1.15
 * 
 * Verification:
 * 3.00x + 2.00y = 9.00 (should be 9.00)
 * 1.00x + 5.00y = 8.00 (should be 8.00)
 */
