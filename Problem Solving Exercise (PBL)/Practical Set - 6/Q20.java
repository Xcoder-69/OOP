import java.util.Scanner;

public class Q20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the numerator: ");
            String numeratorStr = scanner.nextLine();
            int numerator = Integer.parseInt(numeratorStr);

            System.out.print("Enter the denominator: ");
            String denominatorStr = scanner.nextLine();
            int denominator = Integer.parseInt(denominatorStr);

            int result = numerator / denominator;
            System.out.println("Result of division: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please enter integers only.");
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            System.out.println("Exception handling demo completed.");
            scanner.close();
        }
    }
}