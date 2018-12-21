package creational.singleton;

public class LoggerMain {

    public static void main(String args[]) {
        Logger logger1 = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;
        Logger logger3 = Logger.INSTANCE;

        logger1.logDeposit("0001", 80.5);
        logger2.logWithdraw("0002", 100);
        logger1.logTransfer("0001", "0003", 40);
        logger3.logDeposit("0004", 56.74);
        logger2.logWithdraw("0005", 30);
    }

}
