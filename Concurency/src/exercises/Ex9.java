package exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ex9 {

    public static void main(String[] args) {
        int oddNumber = 5;
        List<Chopstick> chopsticks = new ArrayList<>();
        List<Philosopher> philosophers = new ArrayList<>();
        for(int i=0;i<oddNumber;i++) {
            chopsticks.add(new Chopstick());
        }
        for(int i=0;i<oddNumber;i++) {
            philosophers.add(new Philosopher(String.valueOf(i+1), chopsticks.get(i), chopsticks.get((i+1)%oddNumber)));
        }

        for(Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }

    static class Philosopher extends Thread {
        private String name;
        private Chopstick left, right;

        public Philosopher(String name, Chopstick left, Chopstick right) {
            super(name);
            this.name = name;
            this.left = left;
            this.right = right;
        }

        @Override
        public void run() {
            while (true) {
                if(left.lock()) {
                    if(right.lock()) {
                        eat();
                        sleep();
                        right.unlock();
                    }
                    left.unlock();
                }
            }
        }

        private void sleep() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void eat() {
            System.out.println(name + " is eating");
        }
    }

    static class Chopstick {
        private Lock lock = new ReentrantLock(true);
        public boolean lock() {
            lock.lock();
            return true;
        }
        public void unlock() {
            lock.unlock();
        }
    }
}
