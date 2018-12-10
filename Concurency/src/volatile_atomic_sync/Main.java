package volatile_atomic_sync;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    /**
     * 1) No synchronization - unsafe implementation (This may produce the following result depending upon computer's speed and thread interleaving.)
     * It basically reads value from memory, increments it and puts back to memory.
     * This works in single thread but nowadays, in the era of multi-core, multi-CPU, multi-level caches it won't work correctly.
     * First of all it introduces race condition (several threads can read the value at the same time), but also visibility problems.
     * The value might only be stored in "local" CPU memory (some cache) and not be visible for other CPUs/cores (and thus - threads).
     * <p>
     * <p>
     * 2)AtomicInteger - safe implementation of counter
     * Declaring an atomic variable guarantees that operations made on the variable occur in an atomic fashion, i.e.,
     * that all of the substeps of the operation are completed within the thread they are executed and are not interrupted by other threads.
     * For example, an increment-and-test operation requires the variable to be incremented and then compared to another value; an atomic operation guarantees
     * \that both of these steps will be completed as if they were a single indivisible/uninterruptible operation.
     * When to use: Multiple threads can read and modify data.
     * <p>
     *
     * 3) volatile without synchronization - still not correct
     * It fixes the visibility issue (volatile makes sure other threads can see change made to counter) but still has a race condition.
     *
     * When to use: One thread modifies the data and other threads have to read latest value of data. Other threads will take some action but they won't update data.
     * <p>
     *
     * 4) syncronized
     *synchronized is keyword used to guard a method or code block. By making method as synchronized has two effects:
     *
     * First, it is not possible for two invocations of synchronized methods on the same object to interleave.
     * When one thread is executing a synchronized method for an object, all other threads that invoke synchronized methods for the same object block
     * (suspend execution) until the first thread is done with the object.
     * Second, when a synchronized method exits, it automatically establishes a happens-before relationship with any subsequent invocation of a synchronized method for the same object.
     * This guarantees that changes to the state of the object are visible to all threads.
     *
     * When to use: Multiple threads can read and modify data. Your business logic not only update the data but also executes atomic operations
     *
     * AtomicXXX is equivalent of volatile + synchronized even though the implementation is different.
     * AmtomicXXX extends volatile variables + compareAndSet methods but does not use synchronization.
     *
     * SYNCRONIZED - Disadvantages:
     * it doesn't allow concurrent read, which can potentially limit scalability
     * it can only be used to control access of shared object within the same JVM. If you have more than one JVM and need to synchronized access to a shared file system or database, the Java synchronized keyword is not at all sufficient
     * performance cost
     * deadlock or starvation
     *
     */

    public static void main(final String[] arguments) throws InterruptedException {
        final Counter counter = new Counter();

        //1000 threads
        for (int i = 0; i < 1000; i++) {

            new Thread(new Runnable() {

                public void run() {
                    counter.increment();
                }
            }).start();
        }

        Thread.sleep(6000);
        System.out.println("Final number (should be 1000): " + counter.value());
    }


    static class Counter {
        //  private int c = 0;
        // private AtomicInteger c = new AtomicInteger(0);
        private int c = 0;

     /*  public synchronized void increment() {
            c++;
        }

        /**other correct forms:
         * void synchronized incIBy5() {
         *   c += 1
         * }
         *
         * void incIBy5() {
         *   synchronized(this) {
         *     c += 1
         *   }
         * }
         *
         * void incIBy5() {
         *   synchronized(this) {
         *     int temp = i;
         *     i = temp + 1;
         *   }
         * }
         */

        public void increment() {
            c++;
        }

        public int value() {
            return c;
        }

    /*  public void increment() {
          c.getAndIncrement();
      }

        public int value() {
            return c.get();
        }*/
    }

    /** WHY NOT CORRECT??
     * Multiple independent synchronized
     * void increment() {
     *   int temp;
     *   synchronized(i) { temp = i }
     *   synchronized(i) { i = temp + 1 }
     * }
     * Surprise, this code is incorrect as well. In fact, it is completely wrong. First of all you are synchronizing on i,
     * which is about to be changed (moreover, i is a primitive, so I guess you are synchronizing on a temporary Integer created via autoboxing...) Completely flawed.
     *
     * You could also write:
     *
     * synchronized(new Object()) {
     *   //thread-safe, SRSLy?
     * }
     * No two threads can enter the same synchronized block with the same lock.
     * \In this case (and similarly in your code) the lock object changes upon every execution, so synchronized effectively has no effect.
     *
     * Even if you have used a final variable (or this) for synchronization, the code is still incorrect.
     * Two threads can first read i to temp synchronously (having the same value locally in temp),
     * then the first assigns a new value to i (say, from 1 to 6) and the other one does the same thing (from 1 to 6).
     */
}
