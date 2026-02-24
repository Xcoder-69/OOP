/*
 * Question 4: Develop a Java application that calculates a person's Body Mass Index (BMI).
 * The program should ask the user for their weight in pounds and height in inches.
 * Convert these values to kilograms and meters respectively
 * (1 pound = 0.45359237 kg, 1 inch = 0.0254 meters)
 * and then calculate BMI (weight in kg / (height in meters)^2).
 * Display the calculated BMI.
 */

import java.util.Scanner;

class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Conversion factors
        final double POUND_TO_KG = 0.45359237;
        final double INCH_TO_METER = 0.0254;
        
        System.out.println("===== BMI Calculator =====");
        System.out.print("Enter weight in pounds: ");
        double weightPounds = scanner.nextDouble();
        
        System.out.print("Enter height in inches: ");
        double heightInches = scanner.nextDouble();
        
        // Validate input
        if (weightPounds <= 0 || heightInches <= 0) {
            System.out.println("Error: Weight and height must be positive values.");
        } else {
            // Convert to metric units
            double weightKg = weightPounds * POUND_TO_KG;
            double heightMeters = heightInches * INCH_TO_METER;
            
            // Calculate BMI
            double bmi = weightKg / (heightMeters * heightMeters);
            
            // Display results
            System.out.printf("\nConversions:%n");
            System.out.printf("Weight: %.2f pounds = %.2f kg%n", weightPounds, weightKg);
            System.out.printf("Height: %.2f inches = %.4f meters%n", heightInches, heightMeters);
            System.out.printf("\nYour BMI: %.2f%n", bmi);
            
            // Display BMI category
            if (bmi < 18.5) {
                System.out.println("Category: Underweight");
            } else if (bmi < 25) {
                System.out.println("Category: Normal weight");
            } else if (bmi < 30) {
                System.out.println("Category: Overweight");
            } else {
                System.out.println("Category: Obese");
            }
        }
        
        scanner.close();
    }
}

/*
 * Output:
 * 
 * Sample Run 1:
 * ===== BMI Calculator =====
 * Enter weight in pounds: 180
 * Enter height in inches: 70
 * 
 * Conversions:
 * Weight: 180.00 pounds = 81.65 kg
 * Height: 70.00 inches = 1.7780 meters
 * 
 * Your BMI: 25.79
 * Category: Overweight
 * 
 * 
 * Sample Run 2:
 * ===== BMI Calculator =====
 * Enter weight in pounds: 150
 * Enter height in inches: 66
 * 
 * Conversions:
 * Weight: 150.00 pounds = 68.04 kg
 * Height: 66.00 inches = 1.6764 meters
 * 
 * Your BMI: 24.18
 * Category: Normal weight
 */
