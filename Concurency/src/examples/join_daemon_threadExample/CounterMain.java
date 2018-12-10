package examples.join_daemon_threadExample;

public class CounterMain {

    public static void main(String args[]) throws InterruptedException {
        Counter c1 = new Counter(2);
        Counter c2 = new Counter(3);
        Counter c3 = new Counter(3);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);
        t1.start();

        t1.join();
        t2.start();
        t2.join();

        //CHECK WITH OR WITHOUT DAEMON THREAD:
        //definition: A daemon thread is a thread that does not prevent the JVM from exiting when the program finishes but the thread is still running. An example for a daemon thread is the garbage collection.
        //If terminating the JVM process while some thread still is running could have bad consequences, then that thread should not be a daemon.
        // You mentioned the garbage collector. The garbage collector can be a daemon, because it has no side effect outside of the process.
        // (I.e., it doesn't touch any files on disk, it doesn't talk to any network services, etc.)
        //   t3.setDaemon(true);
        t3.start();

        System.out.println("End of main");

        //In the above example we can see clearly second thread t2 starts after first thread t1 is died and t3 will start its execution after second thread t2 is died.
    }
}
