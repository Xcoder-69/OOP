public class Q23 {

    public static void main(String[] args) {
        // First Thread: prints numbers from 1 to 10 at the interval of 1 second.
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Thread 1: " + i);
                try {
                    Thread.sleep(1000); // 1 second interval
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Second Thread: prints numbers from 11 to 20 at the interval of 500 ms.
        Thread thread2 = new Thread(() -> {
            for (int i = 11; i <= 20; i++) {
                System.out.println("Thread 2: " + i);
                try {
                    Thread.sleep(500); // 500 ms interval
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Run both threads and display the output.
        thread1.start();
        thread2.start();
    }
}