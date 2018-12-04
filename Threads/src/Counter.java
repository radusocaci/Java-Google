public class Counter extends Thread{
    private int step;

    public Counter(int step) {
        this.step = step;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i += step) {
            System.out.println("Thread " + Thread.currentThread().getId() + " number " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
