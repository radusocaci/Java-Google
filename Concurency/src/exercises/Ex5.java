package exercises;

public class Ex5 {
    public static void main(String[] args) throws Exception {
        final BankAccount momAccount = new BankAccount("mom", 100_000);
        final BankAccount myAccount = new BankAccount("me", 100);

        Transaction t1 = new Transaction("T1", momAccount, myAccount, 10);
        Transaction t2 = new Transaction("T2", momAccount, myAccount, 100);

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
            BankAccount.transfer(from, to, amount);
        }
    }

    static class BankAccount {
        private String name;
        private int debit;
        public BankAccount(String name, int debit) {
            this.name = name;
            this.debit = debit;
        }

        static void transfer(BankAccount from, BankAccount to, int amount) {
            from.withdraw(amount);
            to.deposit(amount);
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
