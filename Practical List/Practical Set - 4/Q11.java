/*
 * Question 11: Demonstrate method overriding in an online payment system.
 * Create a superclass Payment with processPayment() method.
 * Create subclasses for different payment methods: CreditCard, DebitCard, UPI.
 * Show polymorphism by processing payments through each method.
 */

import java.util.Scanner;

class Payment {
    protected int amount;
    protected String transactionID;
    
    public Payment() {
        this.transactionID = generateTransactionID();
    }
    
    protected String generateTransactionID() {
        return "TXN" + System.currentTimeMillis() % 1000000;
    }
    
    public void processPayment(int amount) {
        System.out.println("\n===== Payment Processing (Generic) =====");
        System.out.printf("Amount: Rs. %d%n", amount);
        System.out.printf("Transaction ID: %s%n", transactionID);
        System.out.println("Payment Status: Processing...");
        System.out.println("Payment Method: Generic Payment");
    }
}

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
    
    private String maskCardNumber(String number) {
        return "****-****-****-" + number.substring(number.length() - 4);
    }
    
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

class DebitCardPayment extends Payment {
    private String bankName;
    private String accountNumber;
    
    public DebitCardPayment(String bank, String account) {
        super();
        this.bankName = bank;
        this.accountNumber = "****" + account.substring(account.length() - 4);
    }
    
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

class UPIPayment extends Payment {
    private String upiID;
    
    public UPIPayment(String upi) {
        super();
        this.upiID = upi;
    }
    
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

class Q11 {
    public static void main(String[] args) {
        System.out.println("========== Online Payment System ==========\n");
        
        int amount = 5000;
        
        Payment payment = new Payment();
        payment.processPayment(amount);
        
        CreditCardPayment ccPayment = new CreditCardPayment("1234567890123456", "Alice Smith", "12/25");
        ccPayment.processPayment(amount);
        
        DebitCardPayment dcPayment = new DebitCardPayment("ICICI Bank", "9876543210");
        dcPayment.processPayment(amount);
        
        UPIPayment upiPayment = new UPIPayment("alice@upi");
        upiPayment.processPayment(amount);
        
        System.out.println("\n===== Polymorphism Demonstration =====");
        Payment[] payments = {payment, ccPayment, dcPayment, upiPayment};
        
        System.out.printf("\nProcessing all payments of Rs. %d:\n", amount);
        for (int i = 0; i < payments.length; i++) {
            System.out.printf("\n--- Payment Method %d ---", (i + 1));
            payments[i].processPayment(amount);
        }
    }
}

/*
 * Output:
 * 
 * ========== Online Payment System ==========
 * 
 * 
 * ===== Payment Processing (Generic) =====
 * Amount: Rs. 5000
 * Transaction ID: TXN234567
 * Payment Status: Processing...
 * Payment Method: Generic Payment
 * 
 * ===== Credit Card Payment Processing =====
 * Amount: Rs. 5000
 * Card Number: ****-****-****-3456
 * Card Holder: Alice Smith
 * Expiry Date: 12/25
 * Transaction ID: TXN234568
 * Payment Status: ✓ SUCCESSFUL
 * Payment Method: Credit Card
 * 
 * ===== Debit Card Payment Processing =====
 * Amount: Rs. 5000
 * Bank Name: ICICI Bank
 * Account Number: ****3210
 * Transaction ID: TXN234569
 * Payment Status: ✓ SUCCESSFUL
 * Payment Method: Debit Card
 * 
 * ===== UPI Payment Processing =====
 * Amount: Rs. 5000
 * UPI ID: alice@upi
 * Transaction ID: TXN234570
 * Payment Status: ✓ SUCCESSFUL
 * Payment Method: UPI
 */
