package coordination_problems;

import java.util.Random;

/**
 *
 Deadlock: Deadlock is a situation when two threads are waiting for each other and the waiting is never ends. Here both threads cant completes their tasks.
 */
class Deadlock extends Thread {
    static Thread mainThread;
    public void run()
    {
        System.out.println("Child Thread waiting for" +
                " main thread completion");
        try {

            // Child thread waiting for completion
            // of main thread
            mainThread.join();
        }
        catch (InterruptedException e) {
            System.out.println("Child thread execution" +
                    " completes");
        }
    }
    public static void main(String[] args)
            throws InterruptedException
    {
        Deadlock.mainThread = Thread.currentThread();
        Deadlock thread = new Deadlock();

        thread.start();
        System.out.println("Main thread waiting for " +
                "Child thread completion");

        // main thread is waiting for the completion
        // of Child thread
        thread.join();

        System.out.println("Main thread execution" +
                " completes");
    }
}