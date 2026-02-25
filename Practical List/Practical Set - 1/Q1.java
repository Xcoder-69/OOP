/*
 * Question 1: Simulate a simple ATM or cashier. Given an integer amount to be dispensed (e.g., 787),
 * calculate and display the minimum number of currency notes of denominations 100, 50, 10, 5, 2, and 1
 * that would be given to the user.
 */

import java.util.Scanner;

class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter amount to be dispensed: ");
        int amount = scanner.nextInt();
        
        System.out.println("\n===== Currency Notes Required =====");
        
        // Array of denominations
        int[] denominations = {100, 50, 10, 5, 2, 1};
        
        // Calculate and display notes for each denomination
        for (int denom : denominations) {
            int count = amount / denom;
            if (count > 0) {
                System.out.printf("Notes of %d: %d%n", denom, count);
                amount = amount % denom;
            }
        }
        
        System.out.println("=====================================");
        scanner.close();
    }
}

/*
 * Output:
 * 
 * Sample Output:
 * Enter amount to be dispensed: 787
 * 
 * ===== Currency Notes Required =====
 * Notes of 100: 7
 * Notes of 50: 1
 * Notes of 10: 3
 * Notes of 5: 1
 * Notes of 2: 1
 * =====================================
 */
