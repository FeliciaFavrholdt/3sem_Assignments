package ThreadsExercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*
Exercise Description:
   Write a program where the main thread creates a number of tasks for an ExecutorService.
   The first task should print AAA, the next BBB,CCC etc. up to ZZZ (there are 25 characters in total).
   There should be 4 worker threads in the executor service.
*/

public class Ex_1 {

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
}