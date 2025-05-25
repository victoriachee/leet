package _Other.Multithreading;

/**
 * Java program demonstrating multithreading with two threads printing odd and even numbers.
 */
public class OddEvenPrinter {

    /**
     * Prints odd numbers.
     */
    static class OddThread extends Thread {

        public void run() {
            for (int i = 1; i <= 10; i += 2) {
                System.out.println("Odd Thread: " + i);
            }
        }
    }

    /**
     * Prints even numbers.
     */
    static class EvenThread extends Thread {

        public void run() {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("Even Thread: " + i);
            }
        }
    }

    public static void main(String[] args) {
        // Creating instances of the threads
        Thread oddThread = new OddThread();
        Thread evenThread = new EvenThread();

        // Starting the threads
        oddThread.start();
        evenThread.start();
    }
}
