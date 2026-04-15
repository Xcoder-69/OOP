/*
 * Question 26: Write a program that will count the number of characters, words, and lines in a file.
 * Words are separated by whitespace characters. The file name should be passed as a command-line argument.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q26 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Q26 <filename>");
            return;
        }

        String fileName = args[0];
        int charCount = 0;
        int wordCount = 0;
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();

                // Count words
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        System.out.println("File: " + fileName);
        System.out.println("Number of characters: " + charCount);
        System.out.println("Number of words: " + wordCount);
        System.out.println("Number of lines: " + lineCount);
    }
}

/*
 * To run this program, you need to create a text file first. Let's assume you create a file named 'sample.txt'
 * in the same directory as Q26.java with the following content:
 *
 * This is a sample file.
 * It has multiple lines.
 * And some words.
 *
 * Compile the program:
 * javac Q26.java
 *
 * Run the program with the filename as a command-line argument:
 * java Q26 sample.txt
 *
 * Expected Output (for the sample.txt above):
 * File: sample.txt
 * Number of characters: 56  (excluding newline characters at the end of each line, but including spaces)
 * Number of words: 12
 * Number of lines: 3
 *
 * Note: The character count in the output will include spaces within lines.
 */