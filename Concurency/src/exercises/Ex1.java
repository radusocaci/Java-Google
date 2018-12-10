package exercises;

import java.util.ArrayList;
import java.util.List;

public class Ex1 {

    public static void main(String[] args) throws InterruptedException {
        long threadsNr = 5_000;
        List<MyThread> list = new ArrayList<>();
        for(int i=0;i<threadsNr;i++) {
            list.add(new MyThread());
        }

        //start all
        for (MyThread thread : list) {
            thread.start();
        }

        //wait for all
        for(MyThread thread: list) {
            thread.join();
        }

        System.out.println(v);
        System.out.println(1_000_000L * threadsNr);
    }

    static long v = 0;
    static class MyThread extends Thread {
        @Override
        public void run() {
            for(int i=1;i<=1_000_000;i++) {
                v++;
            }
        }
    }

}
