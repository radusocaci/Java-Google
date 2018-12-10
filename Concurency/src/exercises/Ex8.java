package exercises;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ex8 {
    public static void main(String[] args) throws Exception {
        final BankAccount momAccount = new BankAccount("mom", 100_000);
        final BankAccount myAccount = new BankAccount("me", 100);

        Transaction t1 = new Transaction("T1", momAccount, myAccount, 100);
        Transaction t2 = new Transaction("T2", myAccount, momAccount, 100);

        t1.start();
        t2.start();

        //wait for transfers to be completed
        t1.join();
        t2.join();

        System.out.println(momAccount);
        System.out.println(myAccount);
    }

    static class Transaction extends Thread {
        private BankAccount from;
        private BankAccount to;
        private int amount;

        public Transaction(String name, BankAccount from, BankAccount to, int amount) {
            super(name);
            this.from = from;
            this.to = to;
            this.amount = amount;
        }

        @Override
        public void run() {
            while (!BankAccount.transfer(from, to, amount)) {
                //wait for successful transfer
            }
            System.out.println("transfer " + from.name + " to " + to.name + " wih amount " + amount + " completed successfully");
            //System.out.println("transfer " + from.name + " to " + to.name + " wih amount " + amount + " not completed");
        }
    }

    static class BankAccount {
        private String name;
        private int debit;
        private Lock lock = new ReentrantLock(true);

        public BankAccount(String name, int debit) {
            this.name = name;
            this.debit = debit;
        }

        static boolean transfer(BankAccount from, BankAccount to, int amount) {
            boolean success = false;
            if (from.lock()) {
                from.withdraw(amount); //because we pause work here, the other thread will get lock on the other obj
                if (to.lock()) {
                    to.deposit(amount); //because we pause work here, the other thread will get lock on the other obj
                    to.unlock();
                    success = true;
                }

                if(!success) {
                    from.deposit(amount);
                }
                from.unlock();
            }
            return success;
        }

        public boolean lock() {
            //lock.lock(); return true; //deadlock
            return lock.tryLock(); //livelock
        }

        public void unlock() {
            lock.unlock();
        }

        void withdraw(double amount) {
            longDatabaseCall();
            this.debit -= amount;
        }

        void deposit(double amount) {
            longDatabaseCall();
            this.debit += amount;
        }

        void longDatabaseCall() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "BankAccount{" +
                    "name='" + name + '\'' +
                    ", debit=" + debit +
                    '}';
        }
    }
}
