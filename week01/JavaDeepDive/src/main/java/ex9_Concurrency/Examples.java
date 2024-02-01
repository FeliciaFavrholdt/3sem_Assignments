package ex9_Concurrency;

import java.util.List;
import java.util.concurrent.*;

//9.2 Use the CompletableFuture class to execute multiple tasks concurrently and wait for their completion.
public class Examples {

    //9.1 Create a simple Task class that simulates some computation. The class should have a run() method that performs the computation for a fixed time
    private static class Task {
        void run() {
            System.out.println("task begun");
            //Simulate some computation
            try {
                Thread.sleep(1000); // Simulate 1 second of work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task ended");
        }

        void runWithException() {
            //Simulate some computation with exception
            throw new RuntimeException("Exception occurred during task execution");
        }
    }


    public static void main(String[] args) {
        //Create several CompletableFuture instances, each running a Task asynchronously using the runAsync() method.
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> new Task().run());
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> new Task().run());
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> new Task().run());
        CompletableFuture<Void> future4 = CompletableFuture.runAsync(() -> new Task().run());

        //Use the allOf() method to wait for all CompletableFuture instances to complete.
        CompletableFuture<Void> allOfFuture = CompletableFuture.allOf(future1, future2, future3, future4);

        //Print a message indicating the completion of all tasks.
        allOfFuture.thenRun(() -> System.out.println("All tasks completed using CompletableFuture"));

        //9.3 Use an ExecutorService to execute multiple tasks concurrently and wait for their completion.
        //Create an ExecutorService using Executors.newFixedThreadPool().
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(() -> new Task().run());
        executorService.submit(() -> new Task().run());
        executorService.submit(() -> new Task().run());
        executorService.submit(() -> new Task().run());

        //Shutdown the ExecutorService using the shutdown() method.
        executorService.shutdown();
    }
}