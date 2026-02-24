/*
 * Question 14: Define a base class BankAccount with common attributes like accountNumber,
 * accountHolderName, and balance. Then, define two subclasses: SavingAccount and
 * FixedDepositAccount, which inherit from BankAccount. Implement basic operations like
 * openAccount(), deposit(), checkBalance(), and withdraw() in BankAccount.
 * The SavingAccount should include a calculateInterest() method specific to savings accounts,
 * and FixedDepositAccount should have a maturityAmount() method considering fixed deposit terms.
 */

import java.util.Scanner;

// Base class
class BankAccount {
    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;
    
    // Constructor
    public BankAccount() {
        this.accountNumber = "";
        this.accountHolderName = "";
        this.balance = 0.0;
    }
    
    // Method to open account
    public void openAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        System.out.printf("Account opened successfully!%n");
        System.out.printf("Account Number: %s%n", accountNumber);
        System.out.printf("Account Holder: %s%n", accountHolderName);
        System.out.printf("Initial Balance: $%.2f%n%n", balance);
    }
    
    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited: $%.2f%n", amount);
            System.out.printf("New Balance: $%.2f%n%n", balance);
        } else {
            System.out.println("Deposit amount must be positive.\n");
        }
    }
    
    // Method to check balance
    public void checkBalance() {
        System.out.printf("Account Holder: %s%n", accountHolderName);
        System.out.printf("Account Number: %s%n", accountNumber);
        System.out.printf("Current Balance: $%.2f%n%n", balance);
    }
    
    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrawn: $%.2f%n", amount);
            System.out.printf("Remaining Balance: $%.2f%n%n", balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance for withdrawal.\n");
        } else {
            System.out.println("Withdrawal amount must be positive.\n");
        }
    }
}

// Subclass for Saving Account
class SavingAccount extends BankAccount {
    private double interestRate;
    
    // Constructor
    public SavingAccount() {
        super();
        this.interestRate = 4.0; // Default 4% interest rate
    }
    
    // Method to calculate interest specific to savings account
    public double calculateInterest() {
        return (balance * interestRate) / 100;
    }
    
    // Method to display interest details
    public void displayInterestDetails() {
        double interest = calculateInterest();
        System.out.printf("===== Savings Account Interest Details =====%n");
        System.out.printf("Account Holder: %s%n", accountHolderName);
        System.out.printf("Current Balance: $%.2f%n", balance);
        System.out.printf("Interest Rate: %.2f%%%n", interestRate);
        System.out.printf("Interest Earned: $%.2f%n", interest);
        System.out.printf("Balance after interest: $%.2f%n", balance + interest);
        System.out.printf("===========================================%n%n");
    }
    
    // Method to set interest rate
    public void setInterestRate(double rate) {
        this.interestRate = rate;
    }
}

// Subclass for Fixed Deposit Account
class FixedDepositAccount extends BankAccount {
    private double ratePerAnnum;
    private int depositTermYears;
    
    // Constructor
    public FixedDepositAccount() {
        super();
        this.ratePerAnnum = 7.5; // Default 7.5% per annum
        this.depositTermYears = 1;
    }
    
    // Method to calculate maturity amount
    public double maturityAmount() {
        // Simple Interest: A = P(1 + rt/100)
        // where P = Principal, r = rate, t = time in years
        return balance * (1 + (ratePerAnnum * depositTermYears) / 100);
    }
    
    // Method to display maturity details
    public void displayMaturityDetails() {
        double maturity = maturityAmount();
        double interest = maturity - balance;
        System.out.printf("===== Fixed Deposit Account Maturity Details =====%n");
        System.out.printf("Account Holder: %s%n", accountHolderName);
        System.out.printf("Deposit Amount: $%.2f%n", balance);
        System.out.printf("Rate per Annum: %.2f%%%n", ratePerAnnum);
        System.out.printf("Deposit Term: %d year(s)%n", depositTermYears);
        System.out.printf("Interest Earned: $%.2f%n", interest);
        System.out.printf("Maturity Amount: $%.2f%n", maturity);
        System.out.printf("================================================%n%n");
    }
    
    // Method to set deposit term and rate
    public void setTermAndRate(int years, double rate) {
        this.depositTermYears = years;
        this.ratePerAnnum = rate;
    }
}

class Q14 {
    public static void main(String[] args) {
        System.out.println("===== Bank Account Management System =====\n");
        
        // Create a Saving Account
        System.out.println("--- Saving Account ---\n");
        SavingAccount savingAccount = new SavingAccount();
        savingAccount.openAccount("SA001", "Alice Johnson", 10000);
        savingAccount.deposit(5000);
        savingAccount.checkBalance();
        savingAccount.withdraw(2000);
        savingAccount.displayInterestDetails();
        
        // Create a Fixed Deposit Account
        System.out.println("--- Fixed Deposit Account ---\n");
        FixedDepositAccount fdAccount = new FixedDepositAccount();
        fdAccount.openAccount("FD001", "Bob Smith", 50000);
        fdAccount.setTermAndRate(3, 8.5);
        fdAccount.checkBalance();
        fdAccount.displayMaturityDetails();
        
        // Another Saving Account
        System.out.println("--- Another Saving Account ---\n");
        SavingAccount savingAccount2 = new SavingAccount();
        savingAccount2.openAccount("SA002", "Charlie Brown", 25000);
        savingAccount2.setInterestRate(5.5);
        savingAccount2.deposit(10000);
        savingAccount2.displayInterestDetails();
        
        // Another Fixed Deposit Account
        System.out.println("--- Another Fixed Deposit Account ---\n");
        FixedDepositAccount fdAccount2 = new FixedDepositAccount();
        fdAccount2.openAccount("FD002", "Diana Prince", 100000);
        fdAccount2.setTermAndRate(5, 9.0);
        fdAccount2.displayMaturityDetails();
    }
}

/*
 * Output:
 * 
 * ===== Bank Account Management System =====
 * 
 * --- Saving Account ---
 * 
 * Account opened successfully!
 * Account Number: SA001
 * Account Holder: Alice Johnson
 * Initial Balance: $10000.00
 * 
 * Deposited: $5000.00
 * New Balance: $15000.00
 * 
 * Account Holder: Alice Johnson
 * Account Number: SA001
 * Current Balance: $15000.00
 * 
 * Withdrawn: $2000.00
 * Remaining Balance: $13000.00
 * 
 * ===== Savings Account Interest Details =====
 * Account Holder: Alice Johnson
 * Current Balance: $13000.00
 * Interest Rate: 4.00%
 * Interest Earned: $520.00
 * Balance after interest: $13520.00
 * ==========================================
 * 
 * --- Fixed Deposit Account ---
 * 
 * Account opened successfully!
 * Account Number: FD001
 * Account Holder: Bob Smith
 * Initial Balance: $50000.00
 * 
 * Account Holder: Bob Smith
 * Account Number: FD001
 * Current Balance: $50000.00
 * 
 * ===== Fixed Deposit Account Maturity Details =====
 * Account Holder: Bob Smith
 * Deposit Amount: $50000.00
 * Rate per Annum: 8.50%
 * Deposit Term: 3 year(s)
 * Interest Earned: $12750.00
 * Maturity Amount: $62750.00
 * ================================================
 * 
 * --- Another Saving Account ---
 * 
 * Account opened successfully!
 * Account Number: SA002
 * Account Holder: Charlie Brown
 * Initial Balance: $25000.00
 * 
 * Deposited: $10000.00
 * New Balance: $35000.00
 * 
 * ===== Savings Account Interest Details =====
 * Account Holder: Charlie Brown
 * Current Balance: $35000.00
 * Interest Rate: 5.50%
 * Interest Earned: $1925.00
 * Balance after interest: $36925.00
 * ==========================================
 * 
 * --- Another Fixed Deposit Account ---
 * 
 * Account opened successfully!
 * Account Number: FD002
 * Account Holder: Diana Prince
 * Initial Balance: $100000.00
 * 
 * ===== Fixed Deposit Account Maturity Details =====
 * Account Holder: Diana Prince
 * Deposit Amount: $100000.00
 * Rate per Annum: 9.00%
 * Deposit Term: 5 year(s)
 * Interest Earned: $45000.00
 * Maturity Amount: $145000.00
 * ================================================
 */
