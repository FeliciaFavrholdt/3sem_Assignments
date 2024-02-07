package ThreadsExercise.MondayTuesday;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.CopyOnWriteArrayList;

//Exercise Description:
// Look at the code in this class: https://github.com/HartmannDemoCode/ThreadsDemo/blob/main/src/main/java/dk/cphbusiness/exercises/AddingNumbers.java.
// It inserts a number into an ArrayList and prints out the size of the list.
// The list does not always contain a thousand numbers. Why is that?
// Fix the code so that the list always contains a thousand numbers.

//Code from the link:
    /*
        public class AddingNumbers {

            public static void main(String[] args) {
                ExecutorService workingJack = Executors.newFixedThreadPool(17);
                System.out.println("Main starts");
                IntegerList integerList = new IntegerList();
                for (int count = 0; count < 1000; count++) {
                    workingJack.submit(new TaskToAddCount(integerList, count));
                }
                System.out.println("Main is done");
                workingJack.shutdown();

            }

            private static class IntegerList {
                private static List<Integer> list = new ArrayList<>();
                public void addCount(int count) {
                    list.add(count);
                    System.out.println("Task: " + count + ": List size = " + list.size());
                }
            }
            private static class TaskToAddCount implements Runnable {
                // Gets a reference to the shared list and the count to add
                private IntegerList integerList;
                private int count;

                TaskToAddCount(IntegerList integerList, int count) {
                    this.integerList = integerList;
                    this.count = count;
                }

                @Override
                public void run() {
                    try {
                        Thread.sleep((int) Math.random()*800+200);
                        integerList.addCount(count);
                    } catch (InterruptedException ex) {
                        System.out.println("Thread was interrupted");
                    }
                }
            }
        }
    */

//Solution: answers to the questions:
/* The list does not always contain a thousand numbers because the list is not thread safe
     - so concurrent modifications can lead to data inconsistencies.
     The list is shared among the threads and the addCount method is not synchronized.
     This means that the threads can interfere with each other and the list can end up with less than a thousand numbers.
     The issue arises due to the concurrent modification of the shared list object within the IntegerList class,
     which leads to unpredictable behavior including data corruption and missing elements.*/


public class Ex_3 {

    public static void main(String[] args) {
        ExecutorService workingJack = Executors.newFixedThreadPool(17);
        System.out.println("Main starts");
        IntegerList integerList = new IntegerList();
        for (int count = 0; count < 1000; count++) {
            workingJack.submit(new IntegerList.TaskToAddCount(integerList, count));
        }
        System.out.println("Main is done");
        workingJack.shutdown();

    }

    private static class IntegerList {
        //Solution 3: Use a thread-safe data structure like CopyOnWriteArrayList to hold the integers.
        /*In this modified code, the CopyOnWriteArrayList ensures that the list can be safely modified by
        multiple threads without causing data corruption or inconsistency. Therefore, the list will
        always contain a thousand numbers without synchronization issues.*/

        //private static final List<Integer> list = new CopyOnWriteArrayList<>();

        //Solution 1: Make the method synchronized to ensure thread safety
        /*public synchronized void addCount(int count) {
            list.add(count);
            System.out.println("Task: " + count + ": List size = " + list.size());
        }*/

        //Solution 2: Use a synchronized block to ensure thread safety
        /*public void addCount(int count) {
            synchronized (list) {
                list.add(count);
                System.out.println("Task: " + count + ": List size = " + list.size());
            }
        }*/

        private static List<Integer> list = new ArrayList<>();

        public void addCount(int count) {
            list.add(count);
            System.out.println("Task: " + count + ": List size = " + list.size());
        }

        private static class TaskToAddCount implements Runnable {
            // Gets a reference to the shared list and the count to add
            private final IntegerList integerList;
            private final int count;

            TaskToAddCount(IntegerList integerList, int count) {
                this.integerList = integerList;
                this.count = count;
            }

            @Override
            public void run() {
                try {
                    Thread.sleep((int) (Math.random() * 800) + 200);
                    integerList.addCount(count);
                } catch (InterruptedException ex) {
                    System.out.println("Thread was interrupted");
                }
            }
        }
    }
}