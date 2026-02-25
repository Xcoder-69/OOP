/*
 * Question 10: Demonstrate inheritance with Vehicle -> Car -> ElectricCar classes.
 * Show constructor chaining, method overriding, super keyword, instanceof operator,
 * upcasting, and downcasting.
 */

class Vehicle {
    protected String vehicleNumber;
    protected String brand;
    protected String fuelType;
    
    public Vehicle(String number, String brand, String fuel) {
        this.vehicleNumber = number;
        this.brand = brand;
        this.fuelType = fuel;
        System.out.println("Vehicle constructor called");
    }
    
    public void displayDetails() {
        System.out.printf("Vehicle Number: %s%n", vehicleNumber);
        System.out.printf("Brand: %s%n", brand);
        System.out.printf("Fuel Type: %s%n", fuelType);
    }
}

class Car extends Vehicle {
    protected int numberOfSeats;
    protected boolean ACAvailable;
    
    public Car(String number, String brand, String fuel, int seats, boolean ac) {
        super(number, brand, fuel);
        this.numberOfSeats = seats;
        this.ACAvailable = ac;
        System.out.println("Car constructor called");
    }
    
    @Override
    public void displayDetails() {
        System.out.println("\n===== CAR DETAILS =====");
        super.displayDetails();
        System.out.printf("Number of Seats: %d%n", numberOfSeats);
        System.out.printf("AC Available: %s%n", ACAvailable ? "Yes" : "No");
    }
}

class ElectricCar extends Car {
    private double batteryCapacity;
    private int chargingTime;
    
    public ElectricCar(String number, String brand, String fuel, int seats, boolean ac, 
                       double battery, int charging) {
        super(number, brand, fuel, seats, ac);
        this.batteryCapacity = battery;
        this.chargingTime = charging;
        System.out.println("ElectricCar constructor called");
    }
    
    @Override
    public void displayDetails() {
        System.out.println("\n===== ELECTRIC CAR DETAILS =====");
        super.displayDetails();
        System.out.printf("Battery Capacity: %.2f kWh%n", batteryCapacity);
        System.out.printf("Charging Time: %d minutes%n", chargingTime);
    }
    
    public double getBatteryCapacity() {
        return batteryCapacity;
    }
}

class Q10 {
    public static void main(String[] args) {
        System.out.println("===== CONSTRUCTOR CHAINING =====");
        ElectricCar ec1 = new ElectricCar("TN-01-AB-1234", "Tesla", "Electric", 5, true, 100.0, 45);
        
        System.out.println("\n===== POLYMORPHISM AND METHOD OVERRIDING =====");
        ec1.displayDetails();
        
        System.out.println("\n===== UPCASTING (ElectricCar to Car) =====");
        Car car1 = ec1;  // Upcasting
        System.out.println("After upcasting ElectricCar to Car:");
        car1.displayDetails();
        
        System.out.println("\n===== UPCASTING (Car to Vehicle) =====");
        Vehicle v1 = new Car("KA-02-CD-5678", "Hyundai", "Petrol", 5, true);
        System.out.println("After upcasting Car to Vehicle:");
        v1.displayDetails();
        
        System.out.println("\n===== instanceof OPERATOR =====");
        Vehicle v2 = new ElectricCar("DL-03-EF-9999", "BMW", "Electric", 4, true, 80.5, 50);
        
        System.out.println("\nChecking types:");
        System.out.printf("v2 instanceof ElectricCar: %b%n", v2 instanceof ElectricCar);
        System.out.printf("v2 instanceof Car: %b%n", v2 instanceof Car);
        System.out.printf("v2 instanceof Vehicle: %b%n", v2 instanceof Vehicle);
        
        System.out.println("\n===== DOWNCASTING WITH instanceof CHECK =====");
        if (v2 instanceof ElectricCar) {
            ElectricCar ec2 = (ElectricCar) v2;  // Downcasting
            System.out.println("Successfully downcast to ElectricCar");
            ec2.displayDetails();
            System.out.printf("Battery Capacity: %.2f kWh%n", ec2.getBatteryCapacity());
        }
        
        System.out.println("\n===== ARRAY OF VEHICLES WITH POLYMORPHISM =====");
        Vehicle[] vehicles = {
            new Vehicle("UP-04-GH-2000", "Maruti", "Diesel"),
            new Car("MH-05-IJ-3000", "Honda", "Petrol", 5, true),
            new ElectricCar("KA-06-KL-4000", "MG", "Electric", 5, true, 60.0, 30)
        };
        
        for (int i = 0; i < vehicles.length; i++) {
            System.out.printf("\nVehicle %d:", i + 1);
            System.out.printf("Type: %s%n", 
                vehicles[i] instanceof ElectricCar ? "ElectricCar" : 
                vehicles[i] instanceof Car ? "Car" : "Vehicle");
            vehicles[i].displayDetails();
        }
    }
}

/*
 * Output:
 * ===== CONSTRUCTOR CHAINING =====
 * Vehicle constructor called
 * Car constructor called
 * ElectricCar constructor called
 * 
 * ===== POLYMORPHISM AND METHOD OVERRIDING =====
 * 
 * ===== ELECTRIC CAR DETAILS =====
 * Vehicle Number: TN-01-AB-1234
 * Brand: Tesla
 * Fuel Type: Electric
 * Number of Seats: 5
 * AC Available: Yes
 * Battery Capacity: 100.00 kWh
 * Charging Time: 45 minutes
 * 
 * ===== UPCASTING (ElectricCar to Car) =====
 * After upcasting ElectricCar to Car:
 * 
 * ===== CAR DETAILS =====
 * Vehicle Number: TN-01-AB-1234
 * Brand: Tesla
 * Fuel Type: Electric
 * Number of Seats: 5
 * AC Available: Yes
 * 
 * ===== UPCASTING (Car to Vehicle) =====
 * Vehicle constructor called
 * Car constructor called
 * After upcasting Car to Vehicle:
 * 
 * ===== CAR DETAILS =====
 * Vehicle Number: KA-02-CD-5678
 * Brand: Hyundai
 * Fuel Type: Petrol
 * Number of Seats: 5
 * AC Available: Yes
 * 
 * ===== instanceof OPERATOR =====
 * Vehicle constructor called
 * Car constructor called
 * ElectricCar constructor called
 * 
 * Checking types:
 * v2 instanceof ElectricCar: true
 * v2 instanceof Car: true
 * v2 instanceof Vehicle: true
 * 
 * ===== DOWNCASTING WITH instanceof CHECK =====
 * Successfully downcast to ElectricCar
 * 
 * ===== ELECTRIC CAR DETAILS =====
 * Vehicle Number: DL-03-EF-9999
 * Brand: BMW
 * Fuel Type: Electric
 * Number of Seats: 4
 * AC Available: Yes
 * Battery Capacity: 80.50 kWh
 * Charging Time: 50 minutes
 * Battery Capacity: 80.50 kWh
 * 
 * ===== ARRAY OF VEHICLES WITH POLYMORPHISM =====
 * 
 * Vehicle 1:Type: Vehicle
 * Vehicle Number: UP-04-GH-2000
 * Brand: Maruti
 * Fuel Type: Diesel
 * 
 * Vehicle 2:Type: Car
 * Vehicle constructor called
 * Car constructor called
 * 
 * ===== CAR DETAILS =====
 * Vehicle Number: MH-05-IJ-3000
 * Brand: Honda
 * Fuel Type: Petrol
 * Number of Seats: 5
 * AC Available: Yes
 * 
 * Vehicle 3:Type: ElectricCar
 * Vehicle constructor called
 * Car constructor called
 * ElectricCar constructor called
 * 
 * ===== ELECTRIC CAR DETAILS =====
 * Vehicle Number: KA-06-KL-4000
 * Brand: MG
 * Fuel Type: Electric
 * Number of Seats: 5
 * AC Available: Yes
 * Battery Capacity: 60.00 kWh
 * Charging Time: 30 minutes
 */
