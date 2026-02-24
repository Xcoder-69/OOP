/*
 * Practical Set-5: Q13
 * Write a Java program using four different packages to demonstrate the use of access specifiers.
 * Package apack: class A with variables x (public), y (protected), z (private).
 * Package bpack: class B extends A and uses the inherited variables.
 * Package cpack: class C that creates an object of class A.
 * Package dpack: class D that tries to access the variables of class A.
 * Show which variables can be accessed from different packages and why.
 */

/*
 * For proper compilation, create the following directory structure:
 * 
 * Q13_AccessSpecifiers/
 *   ├── apack/
 *   │   └── A.java
 *   ├── bpack/
 *   │   └── B.java
 *   ├── cpack/
 *   │   └── C.java
 *   └── dpack/
 *       └── D.java
 * 
 * To compile and run:
 * 1. Navigate to Q13_AccessSpecifiers directory
 * 2. javac apack/*.java bpack/*.java cpack/*.java dpack/*.java
 * 3. java apack.Main (or create Main class in apack package)
 */

// ========== PACKAGE: apack ==========
// File: apack/A.java

package apack;

public class A {
    public int x;           // Public - accessible from anywhere
    protected int y;        // Protected - accessible from same package and subclasses
    private int z;          // Private - accessible only within the class
    
    public A() {
        this.x = 10;
        this.y = 20;
        this.z = 30;
    }
    
    public void displayPrivate() {
        System.out.printf("Private variable z = %d%n", z);
    }
    
    public void displayAll() {
        System.out.println("\n===== Class A Details =====");
        System.out.printf("Public x = %d%n", x);
        System.out.printf("Protected y = %d%n", y);
        System.out.printf("Private z = %d%n", z);
        System.out.println("===========================");
    }
}


// ========== PACKAGE: apack ==========
// File: apack/Demo.java

package apack;

public class Demo {
    public static void main(String[] args) {
        System.out.println("========== Java Access Specifiers Demonstration ==========\n");
        
        // Test from same package
        System.out.println("1. TEST FROM SAME PACKAGE (apack):");
        A objA = new A();
        System.out.printf("   Public x: %d ✓%n", objA.x);
        System.out.printf("   Protected y: %d ✓%n", objA.y);
        System.out.print("   Private z: ");
        objA.displayPrivate();
        System.out.println("   ✓ (via method)");
        
        // Test B from same package
        System.out.println("\n2. TEST CLASS B (extends A, same package):");
        B objB = new B();
        objB.displayInheritedVariables();
        
        // Test C from different package
        System.out.println("\n3. TEST CLASS C (different package - cpack):");
        cpack.C.testAccessFromDifferentPackage();
        
        // Test D from different package
        System.out.println("\n4. TEST CLASS D (different package - dpack):");
        dpack.D.testAccessFromUnrelatedClass();
    }
}


// ========== PACKAGE: bpack ==========
// File: bpack/B.java

package bpack;
import apack.A;

public class B extends A {
    public B() {
        super(); // Calls parent constructor
    }
    
    public void displayInheritedVariables() {
        System.out.println("   Class B (extends A):");
        System.out.printf("   - Public x: %d ✓ (from superclass)%n", x);
        System.out.printf("   - Protected y: %d ✓ (from superclass)%n", y);
        System.out.println("   - Private z: NOT ACCESSIBLE (private in parent)");
        System.out.println("     Must use parent's method instead");
        displayPrivate();
    }
}


// ========== PACKAGE: cpack ==========
// File: cpack/C.java

package cpack;
import apack.A;

public class C {
    public static void testAccessFromDifferentPackage() {
        A objA = new A();
        
        System.out.println("   Class C (different package):");
        System.out.printf("   - Public x: %d ✓ (accessible)%n", objA.x);
        System.out.println("   - Protected y: NOT ACCESSIBLE (different package, not subclass)");
        System.out.println("   - Private z: NOT ACCESSIBLE (private in class A)");
        
        System.out.println("\n   Access Summary for Package cpack:");
        System.out.println("   ✓ Can access: public members");
        System.out.println("   ✗ Cannot access: protected, private members");
    }
}


// ========== PACKAGE: dpack ==========
// File: dpack/D.java

package dpack;
import apack.A;

public class D {
    public static void testAccessFromUnrelatedClass() {
        A objA = new A();
        
        System.out.println("   Class D (unrelated class, different package):");
        System.out.printf("   - Public x: %d ✓ (accessible)%n", objA.x);
        System.out.println("   - Protected y: NOT ACCESSIBLE (not subclass of A)");
        System.out.println("   - Private z: NOT ACCESSIBLE (private in class A)");
        
        System.out.println("\n   Access Summary for Package dpack:");
        System.out.println("   ✓ Can access: public members only");
        System.out.println("   ✗ Cannot access: protected, private members");
    }
}


// ========== COMPREHENSIVE ACCESS TABLE ==========
/*
 * 
 * ============ ACCESS SPECIFIERS REFERENCE TABLE ============
 * 
 * Specifier      | Same Class | Same Package | Subclass | Other
 * ===============|============|==============|==========|========
 * public         |     ✓      |      ✓       |    ✓     |   ✓
 * protected      |     ✓      |      ✓       |    ✓     |   ✗
 * default        |     ✓      |      ✓       |    ✗     |   ✗
 * private        |     ✓      |      ✗       |    ✗     |   ✗
 * 
 * ============================================================
 * 
 * EXPLANATION:
 * 
 * 1. PUBLIC (x = 10):
 *    - Accessible from: Same class, same package, subclass, other packages
 *    - Example: A.x, B.x, C.x, D.x all can access
 * 
 * 2. PROTECTED (y = 20):
 *    - Accessible from: Same class, same package, subclass in different package
 *    - NOT accessible from: Unrelated classes in different packages
 *    - Example: A.y ✓, B.y ✓, C.y ✗, D.y ✗
 * 
 * 3. PRIVATE (z = 30):
 *    - Accessible from: Same class only
 *    - NOT accessible from: Same package, subclass, other packages
 *    - Example: Only within class A, must use method displayPrivate()
 * 
 * 4. DEFAULT (no modifier):
 *    - Accessible from: Same class and same package only
 *    - NOT accessible from: Subclass in different package, other packages
 */
