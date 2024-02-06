package ThreadsExercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {

    public static void main(String[] args) {
        // Create a fixed thread pool with 4 worker threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Submit tasks to the executor
        for (char c = 'A'; c <= 'Z'; c++) {
            // Convert char to string
            String taskName = String.valueOf(c).repeat(3); // repeat char 3 times for AAA, BBB, ...

            // Submit a task to print the character
            executor.submit(new PrintTask(taskName));
        }

        // Shutdown the executor
        executor.shutdown();
    }

    // Task class to print the given string
    static class PrintTask implements Runnable {
        private String taskName;

        public PrintTask(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            System.out.println(taskName);
        }
    }

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


}