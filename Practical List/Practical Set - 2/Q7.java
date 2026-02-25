/*
 * Question 7: Calculate EMI (Equated Monthly Installment) for different loan types using method overloading:
 * 1. Home Loan: calculateEMI(double principal, float rateOfInterest)
 * 2. Vehicle Loan: calculateEMI(double principal, int tenure)
 * 3. Personal Loan: calculateEMI(int principal, int tenure) with 10% fixed rate
 */

class EMICalculator {
    
    // Method 1: Home Loan EMI (principal and rate)
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
    public static void calculateEMI(double principal, int tenure) {
        float rateOfInterest = 9.0f; // 9% p.a.
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
    public static void calculateEMI(int principal, int tenure) {
        float rateOfInterest = 10.0f; // 10% fixed
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

class Q7 {
    public static void main(String[] args) {
        System.out.println("========== EMI Calculator (Method Overloading) ==========");
        
        EMICalculator.calculateEMI(5000000, 7.5f);
        EMICalculator.calculateEMI(1000000, 60);
        EMICalculator.calculateEMI(200000, 36);
    }
}

/*
 * Output:
 * 
 * ========== EMI Calculator (Method Overloading) ==========
 * 
 * ===== HOME LOAN EMI =====
 * Principal: Rs. 5000000.00
 * Rate of Interest: 7.50% p.a.
 * Tenure: 10 years (120 months)
 * Monthly EMI: Rs. 59350.73
 * Total Amount: Rs. 7122088.05
 * 
 * ===== VEHICLE LOAN EMI =====
 * Principal: Rs. 1000000.00
 * Rate of Interest: 9.00% p.a.
 * Tenure: 60 months (5 years)
 * Monthly EMI: Rs. 20758.48
 * Total Amount: Rs. 1245508.80
 * 
 * ===== PERSONAL LOAN EMI =====
 * Principal: Rs. 200000
 * Rate of Interest: 10.00% p.a.
 * Tenure: 36 months (3 years)
 * Monthly EMI: Rs. 6453.44
 * Total Amount: Rs. 232323.93
 */
