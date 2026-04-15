import java.util.Scanner;

class VotingApp {
    public void checkEligibility(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above to vote");
        }
        System.out.println("Person is eligible to vote.");
    }
}

public class Q21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VotingApp votingApp = new VotingApp();

        int[] agesToTest = {16, 20, 18, 17};

        for (int age : agesToTest) {
            try {
                System.out.println("Testing age: " + age);
                votingApp.checkEligibility(age);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            } finally {
                System.out.println("Validation process completed");
            }
            System.out.println("-----------------------------------");
        }
        scanner.close();
    }
}