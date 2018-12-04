public class CounterTestDrive {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Counter(2));
        //Thread t2 = new Thread(new Counter(3));

        t1.start();
        //t1.join();
       // t2.start();
    }
}
