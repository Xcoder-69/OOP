/*
 * Question 3: Write a Java program that accepts two numbers as command-line arguments.
 * Convert these arguments to appropriate numeric types (e.g., int or double),
 * perform a simple calculation (e.g., sum or product), and print the result to the console.
 */

class Q3 {
    public static void main(String[] args) {
        System.out.println("========== Command-Line Calculator ==========");
        
        if (args.length != 2) {
            System.out.println("Usage: java Q3 <number1> <number2>");
            return;
        }
        
        try {
            double num1 = Double.parseDouble(args[0]);
            double num2 = Double.parseDouble(args[1]);
            
            System.out.printf("Number 1: %.2f%n", num1);
            System.out.printf("Number 2: %.2f%n", num2);
            System.out.println("\n===== Results =====");
            
            System.out.printf("Addition: %.2f%n", num1 + num2);
            System.out.printf("Subtraction: %.2f%n", num1 - num2);
            System.out.printf("Multiplication: %.2f%n", num1 * num2);
            
            if (num2 != 0) {
                System.out.printf("Division: %.2f%n", num1 / num2);
            } else {
                System.out.println("Division: Cannot divide by zero");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid numbers!");
        }
    }
}

/*
 * Output:
 * 
 * Command: java Q3 50 10
 * ========== Command-Line Calculator ==========
 * Number 1: 50.00
 * Number 2: 10.00
 * 
 * ===== Results =====
 * Addition: 60.00
 * Subtraction: 40.00
 * Multiplication: 500.00
 * Division: 5.00
 * 
 * Command: java Q3 100 25
 * ========== Command-Line Calculator ==========
 * Number 1: 100.00
 * Number 2: 25.00
 * 
 * ===== Results =====
 * Addition: 125.00
 * Subtraction: 75.00
 * Multiplication: 2500.00
 * Division: 4.00
 */
