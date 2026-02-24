/*
 * Question 5: Write a program that takes the lengths of three sides of a triangle as input.
 * Calculate and print the area of the triangle. Ensure that the program validates
 * if the given side lengths can actually form a triangle
 * (sum of any two sides must be greater than the third side)
 * before calculating the area (use Heron's formula: Area = sqrt(s*(s-a)*(s-b)*(s-c))
 * where s = (a+b+c)/2).
 */

import java.util.Scanner;

class Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== Triangle Area Calculator =====");
        System.out.print("Enter side a: ");
        double a = scanner.nextDouble();
        
        System.out.print("Enter side b: ");
        double b = scanner.nextDouble();
        
        System.out.print("Enter side c: ");
        double c = scanner.nextDouble();
        
        // Validate input
        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("Error: All sides must be positive values.");
        } else if (!isValidTriangle(a, b, c)) {
            System.out.println("Error: The given side lengths cannot form a valid triangle.");
            System.out.printf("Reason: The sum of any two sides must be greater than the third side.%n");
            System.out.printf("a + b > c? %.2f + %.2f > %.2f? %b%n", a, b, c, (a + b > c));
            System.out.printf("b + c > a? %.2f + %.2f > %.2f? %b%n", b, c, a, (b + c > a));
            System.out.printf("a + c > b? %.2f + %.2f > %.2f? %b%n", a, c, b, (a + c > b));
        } else {
            // Calculate area using Heron's formula
            double s = (a + b + c) / 2;
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            
            System.out.printf("\nTriangle is valid.%n");
            System.out.printf("Semi-perimeter (s) = (%.2f + %.2f + %.2f) / 2 = %.2f%n", a, b, c, s);
            System.out.printf("Area = sqrt(%.2f * (%.2f - %.2f) * (%.2f - %.2f) * (%.2f - %.2f))%n", 
                            s, s, a, s, b, s, c);
            System.out.printf("Area = sqrt(%.2f * %.2f * %.2f * %.2f)%n", 
                            s, (s - a), (s - b), (s - c));
            System.out.printf("\nArea of the triangle: %.2f square units%n", area);
        }
        
        scanner.close();
    }
    
    // Method to check if three sides can form a valid triangle
    static boolean isValidTriangle(double a, double b, double c) {
        return (a + b > c) && (b + c > a) && (a + c > b);
    }
}

/*
 * Output:
 * 
 * Sample Run 1 (Valid Triangle):
 * ===== Triangle Area Calculator =====
 * Enter side a: 3
 * Enter side b: 4
 * Enter side c: 5
 * 
 * Triangle is valid.
 * Semi-perimeter (s) = (3.00 + 4.00 + 5.00) / 2 = 6.00
 * Area = sqrt(6.00 * (6.00 - 3.00) * (6.00 - 4.00) * (6.00 - 5.00))
 * Area = sqrt(6.00 * 3.00 * 2.00 * 1.00)
 * 
 * Area of the triangle: 6.00 square units
 * 
 * 
 * Sample Run 2 (Invalid Triangle):
 * ===== Triangle Area Calculator =====
 * Enter side a: 1
 * Enter side b: 2
 * Enter side c: 5
 * 
 * Error: The given side lengths cannot form a valid triangle.
 * Reason: The sum of any two sides must be greater than the third side.
 * a + b > c? 1.00 + 2.00 > 5.00? false
 * b + c > a? 2.00 + 5.00 > 1.00? true
 * a + c > b? 1.00 + 5.00 > 2.00? true
 * 
 * 
 * Sample Run 3 (Valid Triangle):
 * ===== Triangle Area Calculator =====
 * Enter side a: 6
 * Enter side b: 8
 * Enter side c: 10
 * 
 * Triangle is valid.
 * Semi-perimeter (s) = (6.00 + 8.00 + 10.00) / 2 = 12.00
 * Area = sqrt(12.00 * (12.00 - 6.00) * (12.00 - 8.00) * (12.00 - 10.00))
 * Area = sqrt(12.00 * 6.00 * 4.00 * 2.00)
 * 
 * Area of the triangle: 24.00 square units
 */
