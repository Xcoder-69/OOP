/*
 * Practical Set-2: Q6
 * Write a Java program to implement a billing system using method overloading.
 * Create a class with multiple generateBill() methods for different discount scenarios:
 * 1. Regular bill (no discount)
 * 2. Privileged customer (fixed discount in Rs.)
 * 3. Festive season (percentage-based discount)
 */

class BillingSystem {
    private String customerName;
    private double baseAmount;
    
    public BillingSystem(String name, double amount) {
        this.customerName = name;
        this.baseAmount = amount;
    }
    
    // Method 1: Regular bill (no discount)
    public void generateBill() {
        System.out.println("\n===== Regular Bill =====");
        System.out.printf("Customer: %s%n", customerName);
        System.out.printf("Base Amount: Rs. %.2f%n", baseAmount);
        System.out.printf("Discount: None%n");
        System.out.printf("Final Amount: Rs. %.2f%n", baseAmount);
    }
    
    // Method 2: Privileged customer (fixed discount in Rs.)
    public void generateBill(double fixedDiscount) {
        double finalAmount = baseAmount - fixedDiscount;
        System.out.println("\n===== Privileged Customer Bill =====");
        System.out.printf("Customer: %s%n", customerName);
        System.out.printf("Base Amount: Rs. %.2f%n", baseAmount);
        System.out.printf("Fixed Discount: Rs. %.2f%n", fixedDiscount);
        System.out.printf("Final Amount: Rs. %.2f%n", finalAmount);
    }
    
    // Method 3: Festive season (percentage-based discount)
    public void generateBill(double percentageDiscount, boolean isFestival) {
        if (isFestival) {
            double discountAmount = (baseAmount * percentageDiscount) / 100;
            double finalAmount = baseAmount - discountAmount;
            System.out.println("\n===== Festive Season Bill =====");
            System.out.printf("Customer: %s%n", customerName);
            System.out.printf("Base Amount: Rs. %.2f%n", baseAmount);
            System.out.printf("Discount (%%.1f%%): Rs. %.2f%n", percentageDiscount, discountAmount);
            System.out.printf("Final Amount: Rs. %.2f%n", finalAmount);
        }
    }
}

class Q6_BillingSystem {
    public static void main(String[] args) {
        System.out.println("========== Billing System (Method Overloading) ==========");
        
        // Example 1: Regular billing
        BillingSystem bill1 = new BillingSystem("John Doe", 5000);
        bill1.generateBill();
        
        // Example 2: Privileged customer with fixed discount
        BillingSystem bill2 = new BillingSystem("Jane Smith", 8000);
        bill2.generateBill(500);
        
        // Example 3: Festive season with percentage discount
        BillingSystem bill3 = new BillingSystem("Charlie Brown", 10000);
        bill3.generateBill(15, true);
        
        // Example 4: Another festive season bill
        BillingSystem bill4 = new BillingSystem("Diana Prince", 12000);
        bill4.generateBill(20, true);
    }
}

/*
 * Output:
 * ========== Billing System (Method Overloading) ==========
 * 
 * ===== Regular Bill =====
 * Customer: John Doe
 * Base Amount: Rs. 5000.00
 * Discount: None
 * Final Amount: Rs. 5000.00
 * 
 * ===== Privileged Customer Bill =====
 * Customer: Jane Smith
 * Base Amount: Rs. 8000.00
 * Fixed Discount: Rs. 500.00
 * Final Amount: Rs. 7500.00
 * 
 * ===== Festive Season Bill =====
 * Customer: Charlie Brown
 * Base Amount: Rs. 10000.00
 * Discount (15.0%): Rs. 1500.00
 * Final Amount: Rs. 8500.00
 */
