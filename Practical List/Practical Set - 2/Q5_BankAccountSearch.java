/*
 * Practical Set-2: Q5
 * Write a Java program to create a BankAccount class with attributes like accountNumber, 
 * accountHolder, and balance. Create an array of BankAccount objects and implement a 
 * static method to search for an account by account number.
 */

import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    
    // Constructor
    public BankAccount(String number, String holder, double bal) {
        this.accountNumber = number;
        this.accountHolder = holder;
        this.balance = bal;
    }
    
    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // Display account details
    public void displayDetails() {
        System.out.printf("Account Number: %s%n", accountNumber);
        System.out.printf("Account Holder: %s%n", accountHolder);
        System.out.printf("Balance: Rs. %.2f%n", balance);
    }
    
    // Static method to search account
    public static BankAccount searchAccount(BankAccount[] accounts, String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}

class Q5_BankAccountSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create array of bank accounts
        BankAccount[] accounts = new BankAccount[5];
        accounts[0] = new BankAccount("ACC001", "Alice Johnson", 50000);
        accounts[1] = new BankAccount("ACC002", "Bob Smith", 75000);
        accounts[2] = new BankAccount("ACC003", "Charlie Brown", 100000);
        accounts[3] = new BankAccount("ACC004", "Diana Prince", 60000);
        accounts[4] = new BankAccount("ACC005", "Eve Wilson", 85000);
        
        System.out.println("========== Bank Account Search ==========\n");
        
        System.out.print("Enter account number to search: ");
        String searchNumber = scanner.nextLine();
        
        BankAccount foundAccount = BankAccount.searchAccount(accounts, searchNumber);
        
        if (foundAccount != null) {
            System.out.println("\n===== Account Found =====");
            foundAccount.displayDetails();
        } else {
            System.out.println("\nAccount not found!");
        }
        
        scanner.close();
    }
}

/*
 * Output:
 * ========== Bank Account Search ==========
 * 
 * Enter account number to search: ACC003
 * 
 * ===== Account Found =====
 * Account Number: ACC003
 * Account Holder: Charlie Brown
 * Balance: Rs. 100000.00
 */
