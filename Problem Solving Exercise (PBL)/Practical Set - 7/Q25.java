class MultiplicationTable {
    public synchronized void printTable(int number) {
        System.out.println("Multiplication Table for " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
            try {
                Thread.sleep(100); // Small delay to show concurrency (or lack thereof with synchronized)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("---------------------------------");
    }
}

public class Q25 {
    public static void main(String[] args) {
        MultiplicationTable table = new MultiplicationTable();

        Thread thread1 = new Thread(() -> {
            table.printTable(5);
        });

        Thread thread2 = new Thread(() -> {
            table.printTable(7);
        });

        thread1.start();
        thread2.start();
    }
}