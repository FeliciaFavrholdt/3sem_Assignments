package ThreadsExercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex_2 {

    //Exercise Description
    // Fix the below code so that the Counter class´s increment method is thread safe:

    /*
        private static class Counter {
            private int count = 0;

            // Method to increment the count, synchronized to ensure thread safety
            public synchronized void increment() {
                count++;
            }

            // Method to retrieve the current count value
            public int getCount() {
                return count;
            }
        }
    */

    private static class Counter {

        private int count = 0;

        // Method to increment the count, synchronized to ensure thread safety
        public synchronized void increment() {
            count++;
        }

        // Method to retrieve the current count value
        public synchronized int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        // Create a fixed thread pool with 4 worker threads
        ExecutorService executor =  Executors.newFixedThreadPool(4);

        // Create a counter object
        Counter counter = new Counter();

        // Submit tasks to the executor
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> counter.increment());
            System.out.println("Task " + i + " submitted");
        }

        // Shutdown the executor
        executor.shutdown();
        System.out.println("Executor shutdown");

        // Wait until all tasks are finished
        while (!executor.isTerminated()) {
        }

        // Print the final count value
        System.out.println("Final count: " + counter.getCount());
    }

}