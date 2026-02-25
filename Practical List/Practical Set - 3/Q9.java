/*
 * Question 9: Write a password validator with the following requirements:
 * 1. Minimum length of 8 characters
 * 2. Should contain only letters and digits
 * 3. Should contain at least 2 digits
 * Display validation result for each requirement.
 */

import java.util.Scanner;

class PasswordValidator {
    
    public static boolean isValidPassword(String password) {
        System.out.println("\n--- Validating Password ---");
        boolean isValid = true;
        
        // Rule 1: Minimum 8 characters
        if (password.length() < 8) {
            System.out.println("✗ Password must be at least 8 characters long");
            isValid = false;
        } else {
            System.out.println("✓ Length is valid (8+ characters)");
        }
        
        // Rule 2: Only letters and digits
        if (!password.matches("[a-zA-Z0-9]+")) {
            System.out.println("✗ Password should contain only letters and digits");
            isValid = false;
        } else {
            System.out.println("✓ Contains only letters and digits");
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
            isValid = false;
        } else {
            System.out.printf("✓ Contains %d digits%n", digitCount);
        }
        
        if (isValid) {
            System.out.println("\n✓ Password is VALID");
        } else {
            System.out.println("\n✗ Password is INVALID");
        }
        
        return isValid;
    }
}

class Q9 {
    public static void main(String[] args) {
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
    }
}

/*
 * Output:
 * 
 * ========== Password Validator ==========
 * 
 * Password Requirements:
 * 1. Minimum 8 characters
 * 2. Only letters and digits
 * 3. At least 2 digits
 * 
 * Test 1: Password = 'Secure123'
 * 
 * --- Validating Password ---
 * ✓ Length is valid (8+ characters)
 * ✓ Contains only letters and digits
 * ✓ Contains 3 digits
 * 
 * ✓ Password is VALID
 * 
 * Test 2: Password = 'Pass1'
 * 
 * --- Validating Password ---
 * ✗ Password must be at least 8 characters long
 * ✓ Contains only letters and digits
 * ✗ Password must contain at least 2 digits
 * 
 * ✗ Password is INVALID
 * 
 * Test 3: Password = 'Secure@123'
 * 
 * --- Validating Password ---
 * ✓ Length is valid (8+ characters)
 * ✗ Password should contain only letters and digits
 * ✓ Contains 3 digits
 * 
 * ✗ Password is INVALID
 */
