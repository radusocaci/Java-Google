import java.lang.invoke.MutableCallSite;
import java.util.ArrayList;
import java.util.List;

public class MyThreadMain {
    static volatile int v = 0;
    private static Object lock = new Object();

    public static void main(String args[]) throws InterruptedException {
        List<MyThread> list = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            list.add(new MyThread(lock));
        }

        for (MyThread thread : list) {
            thread.start();
        }

       // Thread.sleep(100);
        System.out.println(v);
    }

    static class MyThread extends Thread {
        private Object lock;

        public MyThread(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            increase();
        }

        private  void increase() {
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    v++;
                }
            }
        }
    }
}
