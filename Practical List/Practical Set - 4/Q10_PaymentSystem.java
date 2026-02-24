/*
 * Practical Set-4: Q10
 * Write a Java program to demonstrate method overriding in an online payment system.
 * Create a superclass Payment with a method processPayment(int amount).
 * In the main method, create objects of both Payment and CreditCardPayment classes
 * and call the processPayment() method using each object to show method overriding.
 */

import java.util.Scanner;

// Superclass
class Payment {
    protected int amount;
    protected String transactionID;
    
    public Payment() {
        this.transactionID = generateTransactionID();
    }
    
    // Generate unique transaction ID
    protected String generateTransactionID() {
        return "TXN" + System.currentTimeMillis() % 1000000;
    }
    
    // Method to process payment
    public void processPayment(int amount) {
        System.out.println("\n===== Payment Processing (Generic) =====");
        System.out.printf("Amount: Rs. %d%n", amount);
        System.out.printf("Transaction ID: %s%n", transactionID);
        System.out.println("Payment Status: Processing...");
        System.out.println("Payment Method: Generic Payment");
    }
}

// Subclass - Credit Card Payment
class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    
    public CreditCardPayment(String number, String name, String expiry) {
        super();
        this.cardNumber = maskCardNumber(number);
        this.cardHolderName = name;
        this.expiryDate = expiry;
    }
    
    // Mask card number for security
    private String maskCardNumber(String number) {
        return "****-****-****-" + number.substring(number.length() - 4);
    }
    
    // Override processPayment method
    @Override
    public void processPayment(int amount) {
        System.out.println("\n===== Credit Card Payment Processing =====");
        System.out.printf("Amount: Rs. %d%n", amount);
        System.out.printf("Card Number: %s%n", cardNumber);
        System.out.printf("Card Holder: %s%n", cardHolderName);
        System.out.printf("Expiry Date: %s%n", expiryDate);
        System.out.printf("Transaction ID: %s%n", transactionID);
        System.out.println("Payment Status: ✓ SUCCESSFUL");
        System.out.println("Payment Method: Credit Card");
    }
}

// Subclass - Debit Card Payment
class DebitCardPayment extends Payment {
    private String bankName;
    private String accountNumber;
    
    public DebitCardPayment(String bank, String account) {
        super();
        this.bankName = bank;
        this.accountNumber = "****" + account.substring(account.length() - 4);
    }
    
    // Override processPayment method
    @Override
    public void processPayment(int amount) {
        System.out.println("\n===== Debit Card Payment Processing =====");
        System.out.printf("Amount: Rs. %d%n", amount);
        System.out.printf("Bank Name: %s%n", bankName);
        System.out.printf("Account Number: %s%n", accountNumber);
        System.out.printf("Transaction ID: %s%n", transactionID);
        System.out.println("Payment Status: ✓ SUCCESSFUL");
        System.out.println("Payment Method: Debit Card");
    }
}

// Subclass - UPI Payment
class UPIPayment extends Payment {
    private String upiID;
    
    public UPIPayment(String upi) {
        super();
        this.upiID = upi;
    }
    
    // Override processPayment method
    @Override
    public void processPayment(int amount) {
        System.out.println("\n===== UPI Payment Processing =====");
        System.out.printf("Amount: Rs. %d%n", amount);
        System.out.printf("UPI ID: %s%n", upiID);
        System.out.printf("Transaction ID: %s%n", transactionID);
        System.out.println("Payment Status: ✓ SUCCESSFUL");
        System.out.println("Payment Method: UPI");
    }
}

class Q10_PaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========== Online Payment System ==========\n");
        System.out.print("Enter amount to pay: Rs. ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        
        // Generic Payment
        Payment payment = new Payment();
        payment.processPayment(amount);
        
        // Credit Card Payment
        CreditCardPayment ccPayment = new CreditCardPayment("1234567890123456", "Alice Smith", "12/25");
        ccPayment.processPayment(amount);
        
        // Debit Card Payment
        DebitCardPayment dcPayment = new DebitCardPayment("ICICI Bank", "9876543210");
        dcPayment.processPayment(amount);
        
        // UPI Payment
        UPIPayment upiPayment = new UPIPayment("alice@upi");
        upiPayment.processPayment(amount);
        
        // Demonstrating polymorphism
        System.out.println("\n===== Polymorphism Demonstration =====");
        Payment[] payments = {payment, ccPayment, dcPayment, upiPayment};
        
        System.out.printf("\nProcessing all payments of Rs. %d:\n", amount);
        for (int i = 0; i < payments.length; i++) {
            System.out.printf("\n--- Payment Method %d ---", (i + 1));
            payments[i].processPayment(amount);
        }
        
        scanner.close();
    }
}

/*
 * Output:
 * ========== Online Payment System ==========
 * 
 * Enter amount to pay: Rs. 5000
 * 
 * ===== Payment Processing (Generic) =====
 * Amount: Rs. 5000
 * Transaction ID: TXN234567
 * Payment Status: Processing...
 * Payment Method: Generic Payment
 */
