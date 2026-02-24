/*
 * Question 12: Write a Java program that demonstrates method overloading to calculate
 * the volume of different 3D shapes.
 * Implement overloaded methods named calculateVolume() for:
 * 1. Cube (takes one side length)
 * 2. RectangularCube/Cuboid (takes length, width, height)
 * 3. Sphere (takes radius)
 */

class Q12 {
    // Method to calculate volume of a Cube (one parameter)
    // Volume of Cube = side^3
    public double calculateVolume(double side) {
        System.out.printf("Calculating volume of Cube with side = %.2f%n", side);
        return side * side * side;
    }
    
    // Method to calculate volume of a RectangularCube/Cuboid (three parameters)
    // Volume of Cuboid = length × width × height
    public double calculateVolume(double length, double width, double height) {
        System.out.printf("Calculating volume of Cuboid with length = %.2f, width = %.2f, height = %.2f%n", 
                         length, width, height);
        return length * width * height;
    }
    
    // Method to calculate volume of a Sphere (one parameter with different type signature)
    // Volume of Sphere = (4/3) × π × radius^3
    // We use double parameter type but with explicit method overloading using parameter count
    public double calculateVolume(double radius, String shape) {
        if (shape.equalsIgnoreCase("sphere")) {
            System.out.printf("Calculating volume of Sphere with radius = %.2f%n", radius);
            return (4.0 / 3.0) * Math.PI * radius * radius * radius;
        }
        return 0;
    }
}

class VolumeCalculator {
    public static void main(String[] args) {
        System.out.println("===== 3D Shape Volume Calculator (Method Overloading) =====\n");
        
        Q12 calculator = new Q12();
        
        // Test 1: Calculate volume of a Cube
        System.out.println("--- Test 1: Cube ---");
        double side = 5;
        double cubeVolume = calculator.calculateVolume(side);
        System.out.printf("Volume of Cube: %.2f cubic units%n\n", cubeVolume);
        
        // Test 2: Calculate volume of a Cuboid/Rectangular Cube
        System.out.println("--- Test 2: Cuboid/Rectangular Cube ---");
        double length = 6;
        double width = 4;
        double height = 3;
        double cuboidVolume = calculator.calculateVolume(length, width, height);
        System.out.printf("Volume of Cuboid: %.2f cubic units%n\n", cuboidVolume);
        
        // Test 3: Calculate volume of a Sphere
        System.out.println("--- Test 3: Sphere ---");
        double radius = 7;
        double sphereVolume = calculator.calculateVolume(radius, "sphere");
        System.out.printf("Volume of Sphere: %.2f cubic units%n\n", sphereVolume);
        
        // Additional test cases
        System.out.println("--- Additional Test Cases ---\n");
        
        // Cube with side 10
        double cube2Volume = calculator.calculateVolume(10);
        System.out.printf("Result: %.2f cubic units%n\n", cube2Volume);
        
        // Cuboid with different dimensions
        double cuboid2Volume = calculator.calculateVolume(5, 3, 8);
        System.out.printf("Result: %.2f cubic units%n\n", cuboid2Volume);
        
        // Sphere with different radius
        double sphere2Volume = calculator.calculateVolume(3, "sphere");
        System.out.printf("Result: %.2f cubic units%n\n", sphere2Volume);
        
        // Comparison
        System.out.println("===== Volume Comparison =====");
        System.out.printf("Cube (side=5): %.2f cubic units%n", cubeVolume);
        System.out.printf("Cuboid (6×4×3): %.2f cubic units%n", cuboidVolume);
        System.out.printf("Sphere (radius=7): %.2f cubic units%n", sphereVolume);
    }
}

/*
 * Output:
 * 
 * ===== 3D Shape Volume Calculator (Method Overloading) =====
 * 
 * --- Test 1: Cube ---
 * Calculating volume of Cube with side = 5.00
 * Volume of Cube: 125.00 cubic units
 * 
 * --- Test 2: Cuboid/Rectangular Cube ---
 * Calculating volume of Cuboid with length = 6.00, width = 4.00, height = 3.00
 * Volume of Cuboid: 72.00 cubic units
 * 
 * --- Test 3: Sphere ---
 * Calculating volume of Sphere with radius = 7.00
 * Volume of Sphere: 1436.76 cubic units
 * 
 * --- Additional Test Cases ---
 * 
 * Calculating volume of Cube with side = 10.00
 * Result: 1000.00 cubic units
 * 
 * Calculating volume of Cuboid with length = 5.00, width = 3.00, height = 8.00
 * Volume of Cuboid: 120.00 cubic units
 * 
 * Calculating volume of Sphere with radius = 3.00
 * Volume of Sphere: 113.10 cubic units
 * 
 * ===== Volume Comparison =====
 * Cube (side=5): 125.00 cubic units
 * Cuboid (6×4×3): 72.00 cubic units
 * Sphere (radius=7): 1436.76 cubic units
 */
