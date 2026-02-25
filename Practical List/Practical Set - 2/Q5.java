/*
 * Question 5: Design a BankAccount class with accountNumber, accountHolder, and balance.
 * Create an array of 5 BankAccount objects and implement a static method to search 
 * for an account by account number.
 */

import java.util.Scanner;

class BankAccount {
    private String accountId;
    private String accountHolderName;
    private double balance;
    
    public void assignValues(String id, String name, double bal) {
        this.accountId = id;
        this.accountHolderName = name;
        this.balance = bal;
    }
    
    public void displayValues() {
        System.out.printf("Account ID: %s%n", accountId);
        System.out.printf("Account Holder: %s%n", accountHolderName);
        System.out.printf("Balance: Rs. %.2f%n", balance);
    }
    
    public String getAccountId() {
        return accountId;
    }
    
    public static BankAccount searchAccount(BankAccount[] accounts, String accountId) {
        for (BankAccount account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        return null;
    }
}

class Q5 {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[5];
        
        // Create and initialize accounts
        accounts[0] = new BankAccount();
        accounts[0].assignValues("ACC001", "Alice Johnson", 50000);
        
        accounts[1] = new BankAccount();
        accounts[1].assignValues("ACC002", "Bob Smith", 75000);
        
        accounts[2] = new BankAccount();
        accounts[2].assignValues("ACC003", "Charlie Brown", 100000);
        
        accounts[3] = new BankAccount();
        accounts[3].assignValues("ACC004", "Diana Prince", 60000);
        
        accounts[4] = new BankAccount();
        accounts[4].assignValues("ACC005", "Eve Wilson", 85000);
        
        System.out.println("========== All Accounts ==========\n");
        for (BankAccount account : accounts) {
            account.displayValues();
            System.out.println();
        }
        
        System.out.println("========== Search Account ==========");
        System.out.print("\nEnter account ID to search: ACC003");
        String searchId = "ACC003";
        
        BankAccount foundAccount = BankAccount.searchAccount(accounts, searchId);
        
        if (foundAccount != null) {
            System.out.println("\n===== Account Found =====");
            foundAccount.displayValues();
        } else {
            System.out.println("\nAccount not found!");
        }
    }
}

/*
 * Output:
 * 
 * Sample Output 1:
 * ========== Bank Account Search ==========
 * 
 * Enter account number to search: ACC003
 * 
 * ===== Account Found =====
 * Account Number: ACC003
 * Account Holder: Charlie Brown
 * Balance: Rs. 100000.00
 * 
 * Sample Output 2:
 * ========== Bank Account Search ==========
 * 
 * Enter account number to search: ACC001
 * 
 * ===== Account Found =====
 * Account Number: ACC001
 * Account Holder: Alice Johnson
 * Balance: Rs. 50000.00
 * 
 * Sample Output 3:
 * ========== Bank Account Search ==========
 * 
 * Enter account number to search: ACC999
 * 
 * Account not found!
 */
