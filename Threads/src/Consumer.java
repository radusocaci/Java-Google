import java.util.LinkedList;

public class Consumer {

    private LinkedList<String> list;

    public Consumer(LinkedList<String> list) {
        this.list = list;
    }

    public void consume() {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        synchronized (list) {
                            /*while (list.isEmpty()) {
                                list.wait();
                            }*/
                            System.out.println("consumed " + list.poll());
                            System.out.println("list content " + list);
                        }
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        // TODO: 17/07/2018 handle error
                    }
                }
            }

        };
        t.setDaemon(true);
        t.start();
    }
}
