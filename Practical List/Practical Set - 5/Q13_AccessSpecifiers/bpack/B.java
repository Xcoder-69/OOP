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
