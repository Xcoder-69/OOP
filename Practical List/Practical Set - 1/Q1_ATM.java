import java.util.Scanner;

class Q1_ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========== ATM Cash Dispenser ==========");
        System.out.print("Enter amount to withdraw: Rs. ");
        int amount = scanner.nextInt();
        
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            scanner.close();
            return;
        }
        
        int[] denominations = {100, 50, 10, 5, 2, 1};
        
        System.out.println("\n===== Minimum Notes Required =====");
        
        for (int i = 0; i < denominations.length; i++) {
            int noteCount = amount / denominations[i];
            amount = amount % denominations[i];
            
            if (noteCount > 0) {
                System.out.printf("Rs. %d notes: %d%n", denominations[i], noteCount);
            }
        }
        
        System.out.println("===================================");
        scanner.close();
    }
}
