/*
 * Question 3: Write a Java program that prompts the user to enter a single letter (character).
 * Determine whether the entered character is a vowel (a, e, i, o, u, case-insensitive)
 * or a consonant, and display the result.
 */

import java.util.Scanner;

class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a single letter (character): ");
        String input = scanner.nextLine().trim();
        
        // Validate input
        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            System.out.println("Error: Please enter a single letter.");
        } else {
            char ch = Character.toLowerCase(input.charAt(0));
            
            // Check if vowel or consonant
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                System.out.println("The character '" + input.charAt(0) + "' is a VOWEL.");
            } else {
                System.out.println("The character '" + input.charAt(0) + "' is a CONSONANT.");
            }
        }
        
        scanner.close();
    }
}

/*
 * Output:
 * 
 * Sample Run 1:
 * Enter a single letter (character): a
 * The character 'a' is a VOWEL.
 * 
 * Sample Run 2:
 * Enter a single letter (character): B
 * The character 'B' is a CONSONANT.
 * 
 * Sample Run 3:
 * Enter a single letter (character): E
 * The character 'E' is a VOWEL.
 * 
 * Sample Run 4:
 * Enter a single letter (character): z
 * The character 'z' is a CONSONANT.
 */
