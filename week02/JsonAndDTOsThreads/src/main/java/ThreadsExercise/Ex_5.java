package ThreadsExercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex_5 {

    // This class demonstrates how to use wait and notify methods to synchronize threads

    //create an object for synchronization
    private static final Object lock = new Object();
    private static boolean condition = false;

    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Task to wait
        Runnable taskOne = () -> {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting");
                    while (!condition) {
                        lock.wait(); // Wait until condition changes
                    }
                    System.out.println(Thread.currentThread().getName() + " is notified");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Task to notify
        Runnable taskTwo = () -> {
            synchronized (lock) {
                try {
                    Thread.sleep(2000); // Simulate some task
                    condition = true; // Change the condition
                    System.out.println(Thread.currentThread().getName() + " notifies waiting thread");
                    lock.notify(); // Notify waiting thread
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Submit tasks to ExecutorService
        executor.submit(taskOne);
        executor.submit(taskTwo);

        // Shutdown the executor
        executor.shutdown();
    }
}