package apack;
import bpack.B;
import cpack.C;
import dpack.D;

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
        C.testAccessFromDifferentPackage();
        
        // Test D from different package
        System.out.println("\n4. TEST CLASS D (different package - dpack):");
        D.testAccessFromUnrelatedClass();
    }
}
