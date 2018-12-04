import java.util.LinkedList;

public class Consumer {
    private LinkedList<String> list;

    public Consumer(LinkedList<String> list) {
        this.list = list;
    }

    public void consume() {
        Thread t = new Thread() {
            @Override
            public void start() {
                while (true) {
                    try {
                        synchronized (list) {
                            System.out.println("Consumed" + list.poll());
                            System.out.println(list);
                        }

                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };

        t.setDaemon(true);
        t.start();
    }
}
