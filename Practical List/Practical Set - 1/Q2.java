/*
 * Question 2: Write a Java program that accepts a five-digit integer from the keyboard.
 * Your program should then create a new number by adding one to each digit of the input number.
 * For example, if the input is 12391, the output should be 23402 (note: 9+1=10, so it becomes 0 with a carry)
 */

import java.util.Scanner;

class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a five-digit number: ");
        String number = scanner.nextLine();
        
        if (number.length() != 5 || !number.matches("\\d{5}")) {
            System.out.println("Please enter a valid five-digit number!");
            scanner.close();
            return;
        }
        
        int[] digits = new int[5];
        int carry = 1;
        
        // Convert string to array and add 1 to each digit with carry handling
        for (int i = 4; i >= 0; i--) {
            int digit = Character.getNumericValue(number.charAt(i));
            digit = digit + carry;
            if (digit == 10) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] = digit;
                carry = 0;
            }
        }
        
        System.out.print("Original number: " + number);
        System.out.print("\nNew number with +1 to each digit: ");
        for (int digit : digits) {
            System.out.print(digit);
        }
        System.out.println();
        
        scanner.close();
    }
}

/*
 * Output:
 * 
 * Sample Output 1:
 * Enter a five-digit number: 12391
 * Original number: 12391
 * New number with +1 to each digit: 23402
 * 
 * Sample Output 3:
 * Enter a five-digit number: 54789
 * Original number: 54789
 * New number with +1 to each digit: 65890
 */
