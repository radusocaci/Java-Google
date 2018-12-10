public class MyThread extends Thread {

    static int v = 0;

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            v++;
        }
    }
}
