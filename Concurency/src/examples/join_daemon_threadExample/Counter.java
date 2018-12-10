package examples.join_daemon_threadExample;

public class Counter implements Runnable{
    private int step;

    public Counter(int step) {
        this.step = step;

    }

    @Override
    public void run() {
        long id = Thread.currentThread().getId();

        for (int i = 0; i < 10; i += step) {

            System.out.println("##### thread id : ##### " + id);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (i%2 == 0) {
                System.out.println(i);
            }
            /*System.out.println("Thread "
                    + Thread.currentThread().getId()
                    + " number :" +  i);*/
        }
    }
}
