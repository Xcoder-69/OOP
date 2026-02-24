import java.util.Scanner;

class Q2_FiveDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========== Five-Digit Increment ==========");
        System.out.print("Enter a five-digit number: ");
        String number = scanner.nextLine();
        
        if (number.length() != 5 || !number.matches("\\d{5}")) {
            System.out.println("Please enter a valid five-digit number!");
            scanner.close();
            return;
        }
        
        int[] digits = new int[5];
        for (int i = 0; i < 5; i++) {
            digits[i] = Character.getNumericValue(number.charAt(i));
        }
        
        // Increment each digit
        for (int i = 0; i < 5; i++) {
            digits[i] = (digits[i] + 1) % 10;
        }
        
        System.out.print("\nIncremented number: ");
        for (int digit : digits) {
            System.out.print(digit);
        }
        System.out.println();
        
        scanner.close();
    }
}
