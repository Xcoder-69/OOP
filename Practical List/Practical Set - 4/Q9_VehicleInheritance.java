/*
 * Practical Set-4: Q9
 * Create a base class named Vehicle that contains common attributes such as vehicleNumber, 
 * brand, and fuelType. Derive subclasses Car and Bike with their specific attributes.
 * Override displayDetails() in each subclass to include their specific details.
 */

// Base class
class Vehicle {
    protected String vehicleNumber;
    protected String brand;
    protected String fuelType;
    
    // Constructor
    public Vehicle(String number, String brand, String fuel) {
        this.vehicleNumber = number;
        this.brand = brand;
        this.fuelType = fuel;
    }
    
    // Display details
    public void displayDetails() {
        System.out.printf("Vehicle Number: %s%n", vehicleNumber);
        System.out.printf("Brand: %s%n", brand);
        System.out.printf("Fuel Type: %s%n", fuelType);
    }
}

// Car subclass
class Car extends Vehicle {
    private int numberOfSeats;
    private boolean ACAvailable;
    
    // Constructor
    public Car(String number, String brand, String fuel, int seats, boolean ac) {
        super(number, brand, fuel);
        this.numberOfSeats = seats;
        this.ACAvailable = ac;
    }
    
    // Override displayDetails
    @Override
    public void displayDetails() {
        System.out.println("===== CAR DETAILS =====");
        super.displayDetails();
        System.out.printf("Number of Seats: %d%n", numberOfSeats);
        System.out.printf("AC Available: %s%n", ACAvailable ? "Yes" : "No");
        System.out.println("=======================");
    }
}

// Bike subclass
class Bike extends Vehicle {
    private String bikeType; // sport, cruiser, touring, etc.
    
    // Constructor
    public Bike(String number, String brand, String fuel, String type) {
        super(number, brand, fuel);
        this.bikeType = type;
    }
    
    // Override displayDetails
    @Override
    public void displayDetails() {
        System.out.println("===== BIKE DETAILS =====");
        super.displayDetails();
        System.out.printf("Bike Type: %s%n", bikeType);
        System.out.println("=======================");
    }
}

class Q9_VehicleInheritance {
    public static void main(String[] args) {
        System.out.println("===== Vehicle Management System =====\n");
        
        // Create Car objects
        Car car1 = new Car("DL01AB1234", "Toyota", "Petrol", 5, true);
        Car car2 = new Car("DL02CD5678", "Hyundai", "Diesel", 7, true);
        
        // Create Bike objects
        Bike bike1 = new Bike("DL03EF9999", "Hero", "Petrol", "Sport");
        Bike bike2 = new Bike("DL04GH1111", "Harley", "Petrol", "Cruiser");
        
        // Display details
        System.out.println("--- Car 1 ---");
        car1.displayDetails();
        System.out.println();
        
        System.out.println("--- Car 2 ---");
        car2.displayDetails();
        System.out.println();
        
        System.out.println("--- Bike 1 ---");
        bike1.displayDetails();
        System.out.println();
        
        System.out.println("--- Bike 2 ---");
        bike2.displayDetails();
        System.out.println();
        
        // Polymorphism demonstration
        System.out.println("===== Polymorphism Demonstration =====\n");
        Vehicle[] vehicles = {car1, bike1, car2, bike2};
        
        for (int i = 0; i < vehicles.length; i++) {
            System.out.printf("Vehicle %d:%n", (i + 1));
            vehicles[i].displayDetails();
            System.out.println();
        }
    }
}

/*
 * Output:
 * ===== Vehicle Management System =====
 * 
 * --- Car 1 ---
 * ===== CAR DETAILS =====
 * Vehicle Number: DL01AB1234
 * Brand: Toyota
 * Fuel Type: Petrol
 * Number of Seats: 5
 * AC Available: Yes
 * =======================
 */
