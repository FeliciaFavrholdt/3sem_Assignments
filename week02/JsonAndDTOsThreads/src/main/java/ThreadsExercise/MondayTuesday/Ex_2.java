package ThreadsExercise.MondayTuesday;

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
        public int getCount() {
            return count;
        }
    }
}