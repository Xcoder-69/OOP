/*
 * Question 10: Design a Java class named BankAccount with account holder name and balance.
 * Use a static variable for interest rate (same for all accounts).
 * Include methods to calculate and display the interest earned.
 * Also include a static method to update the interest rate.
 */

class BankAccount {
    // Instance variables
    private String accountHolderName;
    private double balance;
    
    // Static variable for interest rate (shared by all accounts)
    private static double interestRate = 5.0; // Default 5% interest rate
    
    // Constructor
    public BankAccount(String name, double balance) {
        this.accountHolderName = name;
        this.balance = balance;
    }
    
    // Method to calculate interest earned
    public double calculateInterest() {
        return (balance * interestRate) / 100;
    }
    
    // Method to display account details and interest
    public void displayAccountInfo() {
        double interest = calculateInterest();
        System.out.println("------------------------------------");
        System.out.printf("Account Holder: %s%n", accountHolderName);
        System.out.printf("Current Balance: $%.2f%n", balance);
        System.out.printf("Interest Rate: %.2f%%%n", interestRate);
        System.out.printf("Interest Earned: $%.2f%n", interest);
        System.out.printf("Balance after interest: $%.2f%n", balance + interest);
        System.out.println("------------------------------------");
    }
    
    // Static method to update interest rate
    public static void setInterestRate(double rate) {
        interestRate = rate;
        System.out.printf("Interest rate updated to %.2f%%%n%n", interestRate);
    }
    
    // Static method to get current interest rate
    public static double getInterestRate() {
        return interestRate;
    }
    
    // Method to deposit amount
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("$%.2f deposited. New balance: $%.2f%n", amount, balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
    
    // Method to withdraw amount
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("$%.2f withdrawn. New balance: $%.2f%n", amount, balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }
}

class Q10 {
    public static void main(String[] args) {
        System.out.println("===== Bank Account Management System =====\n");
        
        // Create bank accounts
        BankAccount acc1 = new BankAccount("Alice Smith", 5000);
        BankAccount acc2 = new BankAccount("Bob Johnson", 8000);
        BankAccount acc3 = new BankAccount("Charlie Brown", 12000);
        
        // Display initial account information
        System.out.println("Initial Account Information (Interest Rate: " + 
                          BankAccount.getInterestRate() + "%):\n");
        acc1.displayAccountInfo();
        acc2.displayAccountInfo();
        acc3.displayAccountInfo();
        
        // Perform some transactions
        System.out.println("===== Transactions =====\n");
        acc1.deposit(1000);
        acc2.withdraw(2000);
        acc3.deposit(5000);
        System.out.println();
        
        // Update interest rate (static variable affects all accounts)
        System.out.println("===== Updating Interest Rate =====\n");
        BankAccount.setInterestRate(7.5);
        
        // Display updated account information
        System.out.println("Updated Account Information (Interest Rate: " + 
                          BankAccount.getInterestRate() + "%):\n");
        acc1.displayAccountInfo();
        acc2.displayAccountInfo();
        acc3.displayAccountInfo();
    }
}

/*
 * Output:
 * 
 * ===== Bank Account Management System =====
 * 
 * Initial Account Information (Interest Rate: 5.0%):
 * 
 * ------------------------------------
 * Account Holder: Alice Smith
 * Current Balance: $5000.00
 * Interest Rate: 5.00%
 * Interest Earned: $250.00
 * Balance after interest: $5250.00
 * ------------------------------------
 * 
 * ------------------------------------
 * Account Holder: Bob Johnson
 * Current Balance: $8000.00
 * Interest Rate: 5.00%
 * Interest Earned: $400.00
 * Balance after interest: $8400.00
 * ------------------------------------
 * 
 * ------------------------------------
 * Account Holder: Charlie Brown
 * Current Balance: $12000.00
 * Interest Rate: 5.00%
 * Interest Earned: $600.00
 * Balance after interest: $12600.00
 * ------------------------------------
 * 
 * ===== Transactions =====
 * 
 * $1000.00 deposited. New balance: $6000.00
 * $2000.00 withdrawn. New balance: $6000.00
 * $5000.00 deposited. New balance: $17000.00
 * 
 * ===== Updating Interest Rate =====
 * 
 * Interest rate updated to 7.50%
 * 
 * Updated Account Information (Interest Rate: 7.5%):
 * 
 * ------------------------------------
 * Account Holder: Alice Smith
 * Current Balance: $6000.00
 * Interest Rate: 7.50%
 * Interest Earned: $450.00
 * Balance after interest: $6450.00
 * ------------------------------------
 * 
 * ------------------------------------
 * Account Holder: Bob Johnson
 * Current Balance: $6000.00
 * Interest Rate: 7.50%
 * Interest Earned: $450.00
 * Balance after interest: $6450.00
 * ------------------------------------
 * 
 * ------------------------------------
 * Account Holder: Charlie Brown
 * Current Balance: $17000.00
 * Interest Rate: 7.50%
 * Interest Earned: $1275.00
 * Balance after interest: $18275.00
 * ------------------------------------
 */
