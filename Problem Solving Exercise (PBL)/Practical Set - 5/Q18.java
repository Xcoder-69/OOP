/*
 * Question 18: Write a Java program to create an abstract class Vehicle with:
 * - An abstract method fuelType() that returns the type of fuel used
 * - An abstract method noOfWheels() that returns the number of wheels
 * Create two subclasses:
 * - Car that uses Petrol/Diesel and has 4 wheels
 * - Bike that uses Petrol and has 2 wheels
 */

// Abstract class Vehicle
abstract class Vehicle {
    protected String vehicleName;
    protected String color;
    
    // Constructor
    public Vehicle(String name, String color) {
        this.vehicleName = name;
        this.color = color;
    }
    
    // Abstract method to return fuel type
    abstract String fuelType();
    
    // Abstract method to return number of wheels
    abstract int noOfWheels();
    
    // Concrete method
    public void displayVehicleInfo() {
        System.out.printf("Vehicle Name: %s%n", vehicleName);
        System.out.printf("Color: %s%n", color);
    }
}

// Subclass Car
class Car extends Vehicle {
    private String fuelUsed; // Petrol or Diesel
    
    // Constructor
    public Car(String name, String color, String fuel) {
        super(name, color);
        this.fuelUsed = fuel;
    }
    
    // Implementation of fuelType()
    @Override
    String fuelType() {
        return fuelUsed;
    }
    
    // Implementation of noOfWheels()
    @Override
    int noOfWheels() {
        return 4;
    }
    
    // Method to display car details
    public void displayCarDetails() {
        System.out.println("\n====== CAR DETAILS ======");
        displayVehicleInfo();
        System.out.printf("Fuel Type: %s%n", fuelType());
        System.out.printf("Number of Wheels: %d%n", noOfWheels());
        System.out.println("========================");
    }
}

// Subclass Bike
class Bike extends Vehicle {
    // Constructor
    public Bike(String name, String color) {
        super(name, color);
    }
    
    // Implementation of fuelType()
    @Override
    String fuelType() {
        return "Petrol";
    }
    
    // Implementation of noOfWheels()
    @Override
    int noOfWheels() {
        return 2;
    }
    
    // Method to display bike details
    public void displayBikeDetails() {
        System.out.println("\n====== BIKE DETAILS ======");
        displayVehicleInfo();
        System.out.printf("Fuel Type: %s%n", fuelType());
        System.out.printf("Number of Wheels: %d%n", noOfWheels());
        System.out.println("=========================");
    }
}

class Q18 {
    public static void main(String[] args) {
        System.out.println("===== Abstract Class Vehicle Program =====\n");
        
        // Create Car objects
        Car car1 = new Car("Honda Accord", "Silver", "Petrol");
        Car car2 = new Car("Toyota Fortuner", "Black", "Diesel");
        
        // Create Bike objects
        Bike bike1 = new Bike("Hero MotoCorp", "Red");
        Bike bike2 = new Bike("Bajaj Pulsar", "Blue");
        
        // Display car details
        System.out.println("--- Car 1 ---");
        car1.displayCarDetails();
        
        System.out.println("\n--- Car 2 ---");
        car2.displayCarDetails();
        
        // Display bike details
        System.out.println("\n--- Bike 1 ---");
        bike1.displayBikeDetails();
        
        System.out.println("\n--- Bike 2 ---");
        bike2.displayBikeDetails();
        
        // Polymorphism demonstration using abstract class reference
        System.out.println("\n===== Polymorphism Demonstration =====\n");
        Vehicle[] vehicles = new Vehicle[4];
        vehicles[0] = car1;
        vehicles[1] = car2;
        vehicles[2] = bike1;
        vehicles[3] = bike2;
        
        System.out.println("Displaying all vehicles using abstract class reference:\n");
        for (int i = 0; i < vehicles.length; i++) {
            System.out.printf("Vehicle %d: %s%n", (i + 1), vehicles[i].vehicleName);
            System.out.printf("Fuel Type: %s%n", vehicles[i].fuelType());
            System.out.printf("Wheels: %d%n", vehicles[i].noOfWheels());
            System.out.println("---");
        }
    }
}

/*
 * Output:
 * 
 * ===== Abstract Class Vehicle Program =====
 * 
 * --- Car 1 ---
 * 
 * ====== CAR DETAILS ======
 * Vehicle Name: Honda Accord
 * Color: Silver
 * Fuel Type: Petrol
 * Number of Wheels: 4
 * ========================
 * 
 * --- Car 2 ---
 * 
 * ====== CAR DETAILS ======
 * Vehicle Name: Toyota Fortuner
 * Color: Black
 * Fuel Type: Diesel
 * Number of Wheels: 4
 * ========================
 * 
 * --- Bike 1 ---
 * 
 * ====== BIKE DETAILS ======
 * Vehicle Name: Hero MotoCorp
 * Color: Red
 * Fuel Type: Petrol
 * Number of Wheels: 2
 * =========================
 * 
 * --- Bike 2 ---
 * 
 * ====== BIKE DETAILS ======
 * Vehicle Name: Bajaj Pulsar
 * Color: Blue
 * Fuel Type: Petrol
 * Number of Wheels: 2
 * =========================
 * 
 * ===== Polymorphism Demonstration =====
 * 
 * Displaying all vehicles using abstract class reference:
 * 
 * Vehicle 1: Honda Accord
 * Fuel Type: Petrol
 * Wheels: 4
 * ---
 * Vehicle 2: Toyota Fortuner
 * Fuel Type: Diesel
 * Wheels: 4
 * ---
 * Vehicle 3: Hero MotoCorp
 * Fuel Type: Petrol
 * Wheels: 2
 * ---
 * Vehicle 4: Bajaj Pulsar
 * Fuel Type: Petrol
 * Wheels: 2
 * ---
 */
