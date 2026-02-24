/*
 * Question 1: Develop a Java program that prompts the user to enter a distance in meters.
 * Your program should then convert this distance to feet (1 meter = 3.28084 feet) 
 * and display the result formatted to two decimal places.
 */

import java.util.Scanner;

class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user to enter distance in meters
        System.out.print("Enter distance in meters: ");
        double meters = scanner.nextDouble();
        
        // Conversion factor: 1 meter = 3.28084 feet
        double feet = meters * 3.28084;
        
        // Display result formatted to two decimal places
        System.out.printf("%.2f meters = %.2f feet%n", meters, feet);
        
        scanner.close();
    }
}

/*
 * Output:
 * 
 * Sample Output:
 * Enter distance in meters: 10
 * 10.00 meters = 32.81 feet
 * 
 * Sample Output:
 * Enter distance in meters: 5.5
 * 5.50 meters = 18.04 feet
 * 
 * Sample Output:
 * Enter distance in meters: 100
 * 100.00 meters = 328.08 feet
 */
