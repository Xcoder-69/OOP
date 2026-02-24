/*
 * Practical Set-3: Q9
 * Write a Java program to validate passwords using the following rules:
 * 1. Minimum length of 8 characters
 * 2. Should contain only letters and digits
 * 3. Should contain at least 2 digits
 */

import java.util.Scanner;

class PasswordValidator {
    
    // Method to validate password
    public static boolean isValidPassword(String password) {
        // Rule 1: Minimum 8 characters
        if (password.length() < 8) {
            System.out.println("✗ Password must be at least 8 characters long");
            return false;
        }
        
        // Rule 2: Only letters and digits
        if (!password.matches("[a-zA-Z0-9]+")) {
            System.out.println("✗ Password should contain only letters and digits");
            return false;
        }
        
        // Rule 3: At least 2 digits
        int digitCount = 0;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }
        
        if (digitCount < 2) {
            System.out.println("✗ Password must contain at least 2 digits");
            return false;
        }
        
        System.out.println("✓ Password is valid");
        return true;
    }
}

class Q9_PasswordValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========== Password Validator ==========");
        System.out.println("\nPassword Requirements:");
        System.out.println("1. Minimum 8 characters");
        System.out.println("2. Only letters and digits");
        System.out.println("3. At least 2 digits\n");
        
        // Test Case 1: Valid password
        System.out.println("Test 1: Password = 'Secure123'");
        PasswordValidator.isValidPassword("Secure123");
        
        // Test Case 2: Less than 8 characters
        System.out.println("\nTest 2: Password = 'Pass1'");
        PasswordValidator.isValidPassword("Pass1");
        
        // Test Case 3: Contains special characters
        System.out.println("\nTest 3: Password = 'Secure@123'");
        PasswordValidator.isValidPassword("Secure@123");
        
        // Test Case 4: Less than 2 digits
        System.out.println("\nTest 4: Password = 'Password1'");
        PasswordValidator.isValidPassword("Password1");
        
        // Test Case 5: Valid password
        System.out.println("\nTest 5: Password = 'MyPass456'");
        PasswordValidator.isValidPassword("MyPass456");
        
        // Interactive mode
        System.out.println("\n========== Interactive Mode ==========");
        System.out.print("Enter password to validate: ");
        String password = scanner.nextLine();
        
        System.out.print("Validation Result: ");
        PasswordValidator.isValidPassword(password);
        
        scanner.close();
    }
}

/*
 * Output:
 * ========== Password Validator ==========
 * 
 * Password Requirements:
 * 1. Minimum 8 characters
 * 2. Only letters and digits
 * 3. At least 2 digits
 * 
 * Test 1: Password = 'Secure123'
 * ✓ Password is valid
 * 
 * Test 2: Password = 'Pass1'
 * ✗ Password must be at least 8 characters long
 * 
 * Test 3: Password = 'Secure@123'
 * ✗ Password should contain only letters and digits
 * 
 * Test 4: Password = 'Password1'
 * ✗ Password must contain at least 2 digits
 * 
 * Test 5: Password = 'MyPass456'
 * ✓ Password is valid
 * 
 * ========== Interactive Mode ==========
 * Enter password to validate: Test1234
 * Validation Result: ✓ Password is valid
 */
