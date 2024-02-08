package ThreadsExercise;

//Exercise Description:
/* Most operating systems have a program that shows the performance of the system
   (windows: taskmanager, mac: activity monitor, linux: System Monitor).
   Create a variation of one of the Executor programs that puts all your cores to
   work and show us the result at the review.
 */

import java.util.concurrent.*;

public class Ex_4 {

    public static void main(String[] args) {

        // Define the number of threads to use
        int numThreads = Runtime.getRuntime().availableProcessors();

        // Create an ExecutorService with a thread pool using the available cores
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        synchronized (executor) {
            System.out.println("Number of threads: " + numThreads);
        }

        System.out.println("Creates tasks for executor");

        // Submit tasks to the executor
        for (int i = 0; i < 1_000_000; i++) {
            // Submit a task to print the character
            executor.submit(new PrintTask("Task " + i));
        }

        System.out.println("Waits for executor to finish");
        // Shutdown the executor
        executor.shutdown();
        System.out.println("All done");
    }

    static class PrintTask implements Runnable {
        private final String taskName;

        public PrintTask(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            System.out.println(taskName);
        }
    }

}