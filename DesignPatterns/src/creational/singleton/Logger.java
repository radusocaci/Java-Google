package creational.singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class that writes a logger class for a bank.
 * It should register all the withdraws, deposits and transfers in a single file.
 */

/** !!!Note- a creational.singleton can also be used as a gate to a db connection **/
public enum Logger {

    INSTANCE;

    private PrintWriter writer;

    Logger() {
        try {
            String logFile = "demo_log.txt";
            FileWriter fw = new FileWriter(logFile);
            writer = new PrintWriter(fw, true);
        } catch (IOException e) {
        }
    }

    public void logWithdraw(String account, double amount) {
        writer.println("WITHDRAW ("
                + account + "): |" + amount + "$");
    }

    public void logDeposit(String account, double amount) {
        writer.println("DEPOSIT ( " + account + "): " + amount + "$");
    }

    public void logTransfer(String fromAccount, String toAccount, double amount) {
        writer.println("TRANSFER ("
                + fromAccount + "->" + toAccount + "): " + amount + "$");
    }

}
