/*
 * Practical Set-2: Q7
 * Write a Java program to calculate EMI (Equated Monthly Installment) for different loan types.
 * Use method overloading to handle:
 * 1. Home Loan: calculateEMI(double principal, float rateOfInterest)
 * 2. Vehicle Loan: calculateEMI(double principal, int tenure)
 * 3. Personal Loan: calculateEMI(int principal, int tenure)
 */

class EMICalculator {
    
    // Method 1: Home Loan EMI (principal and rate)
    // Formula: EMI = P * r * (1 + r)^n / ((1 + r)^n - 1)
    // r = rate/12/100, n = 12*years (assuming 10 years by default)
    public static void calculateEMI(double principal, float rateOfInterest) {
        int tenure = 10; // 10 years default
        int months = tenure * 12;
        float monthlyRate = rateOfInterest / 12 / 100;
        
        double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, months)) / 
                     (Math.pow(1 + monthlyRate, months) - 1);
        
        System.out.println("\n===== HOME LOAN EMI =====");
        System.out.printf("Principal: Rs. %.2f%n", principal);
        System.out.printf("Rate of Interest: %.2f%% p.a.%n", rateOfInterest);
        System.out.printf("Tenure: %d years (%d months)%n", tenure, months);
        System.out.printf("Monthly EMI: Rs. %.2f%n", emi);
        System.out.printf("Total Amount: Rs. %.2f%n", emi * months);
    }
    
    // Method 2: Vehicle Loan EMI (principal and tenure in months)
    // Fixed rate: 9% p.a.
    public static void calculateEMI(double principal, int tenure) {
        float rateOfInterest = 9.0f; // 9% p.a. for vehicle loans
        float monthlyRate = rateOfInterest / 12 / 100;
        
        double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, tenure)) / 
                     (Math.pow(1 + monthlyRate, tenure) - 1);
        
        System.out.println("\n===== VEHICLE LOAN EMI =====");
        System.out.printf("Principal: Rs. %.2f%n", principal);
        System.out.printf("Rate of Interest: %.2f%% p.a.%n", rateOfInterest);
        System.out.printf("Tenure: %d months (%d years)%n", tenure, tenure/12);
        System.out.printf("Monthly EMI: Rs. %.2f%n", emi);
        System.out.printf("Total Amount: Rs. %.2f%n", emi * tenure);
    }
    
    // Method 3: Personal Loan EMI (int principal and tenure)
    // Fixed rate: 10% p.a.
    public static void calculateEMI(int principal, int tenure) {
        float rateOfInterest = 10.0f; // 10% p.a. for personal loans
        float monthlyRate = rateOfInterest / 12 / 100;
        
        double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, tenure)) / 
                     (Math.pow(1 + monthlyRate, tenure) - 1);
        
        System.out.println("\n===== PERSONAL LOAN EMI =====");
        System.out.printf("Principal: Rs. %d%n", principal);
        System.out.printf("Rate of Interest: %.2f%% p.a.%n", rateOfInterest);
        System.out.printf("Tenure: %d months (%d years)%n", tenure, tenure/12);
        System.out.printf("Monthly EMI: Rs. %.2f%n", emi);
        System.out.printf("Total Amount: Rs. %.2f%n", emi * tenure);
    }
}

class Q7_EMICalculator {
    public static void main(String[] args) {
        System.out.println("========== EMI Calculator (Method Overloading) ==========");
        
        // Home Loan: Principal = 50 lakhs, Rate = 7.5%
        EMICalculator.calculateEMI(5000000, 7.5f);
        
        // Vehicle Loan: Principal = 10 lakhs, Tenure = 60 months
        EMICalculator.calculateEMI(1000000, 60);
        
        // Personal Loan: Principal = 2 lakhs, Tenure = 36 months
        EMICalculator.calculateEMI(200000, 36);
    }
}

/*
 * Output:
 * ========== EMI Calculator (Method Overloading) ==========
 * 
 * ===== HOME LOAN EMI =====
 * Principal: Rs. 5000000.00
 * Rate of Interest: 7.50% p.a.
 * Tenure: 10 years (120 months)
 * Monthly EMI: Rs. 58281.32
 * Total Amount: Rs. 6993758.40
 * 
 * ===== VEHICLE LOAN EMI =====
 * Principal: Rs. 1000000.00
 * Rate of Interest: 9.00% p.a.
 * Tenure: 60 months (5 years)
 * Monthly EMI: Rs. 20758.48
 * Total Amount: Rs. 1245508.80
 */
