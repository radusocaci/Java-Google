import java.util.ArrayList;
import java.util.List;

//slide 25 solved

public class MyThreadMain {
    static int v = 0;

    public static void main(String[] args) throws InterruptedException {
        List<MyThread> list = new ArrayList<>();

        for(int i=0 ; i<=10 ; i++) {
            list.add(new MyThread());
        }

        for(MyThread th : list) {
            th.start();
        }

        System.out.println(v);
        Thread.sleep(100);
    }

    public static class MyThread extends Thread {
        private Object lock = new Object();

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    v++;
                }
            }
        }
    }
}
