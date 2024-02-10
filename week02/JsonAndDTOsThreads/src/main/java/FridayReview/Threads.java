package FridayReview;

public class Threads {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            ThreadExample thread = new ThreadExample();
            thread.start();

            // Interrupt the thread
            thread.interrupt();

            // Join the thread
            thread.join();

            // Sleep for 3 seconds
            long start = System.currentTimeMillis();
            Thread.sleep(3000);
            System.out.println(" - How long did I sleep? \n - " + ((System.currentTimeMillis() - start)) / 1000 + " seconds");

            //

        }
    }

    private static class ThreadExample extends Thread {

        @Override
        public void run() {
            Thread current = Thread.currentThread();

            while (!current.isInterrupted()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("The thread was interrupted");
                    break;
                }
                System.out.println("Tick");
            }
        }
    }
}