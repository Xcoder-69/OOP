class Counter {
    private int currentNumber = 1;
    private final int maxNumber;

    public Counter(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public synchronized void printNumber(int threadId, int start, int end) {
        while (currentNumber <= maxNumber) {
            if (currentNumber >= start && currentNumber <= end) {
                System.out.println("Thread " + threadId + ": " + currentNumber);
                currentNumber++;
                notifyAll(); // Notify other threads that the number has been printed
            } else {
                try {
                    wait(); // Wait for other threads to print their numbers
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        // After all numbers are printed, notify all waiting threads to terminate
        notifyAll();
    }
}

public class Q24 {
    public static void main(String[] args) {
        Counter counter = new Counter(300);

        Thread t1 = new Thread(() -> {
            counter.printNumber(1, 1, 100);
        });

        Thread t2 = new Thread(() -> {
            counter.printNumber(2, 101, 200);
        });

        Thread t3 = new Thread(() -> {
            counter.printNumber(3, 201, 300);
        });

        t1.start();
        t2.start();
        t3.start();
    }
}