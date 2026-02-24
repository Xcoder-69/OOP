class Q3_Calculator {
    public static void main(String[] args) {
        System.out.println("========== Command-Line Calculator ==========");
        
        if (args.length != 2) {
            System.out.println("Usage: java Q3_Calculator <number1> <number2>");
            return;
        }
        
        try {
            double num1 = Double.parseDouble(args[0]);
            double num2 = Double.parseDouble(args[1]);
            
            System.out.printf("Number 1: %.2f%n", num1);
            System.out.printf("Number 2: %.2f%n", num2);
            System.out.println("\n===== Arithmetic Operations =====");
            
            System.out.printf("Sum: %.2f%n", num1 + num2);
            System.out.printf("Difference: %.2f%n", num1 - num2);
            System.out.printf("Product: %.2f%n", num1 * num2);
            
            if (num2 != 0) {
                System.out.printf("Quotient: %.2f%n", num1 / num2);
            } else {
                System.out.println("Quotient: Cannot divide by zero");
            }
            
            System.out.println("==================================");
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid numbers!");
        }
    }
}
