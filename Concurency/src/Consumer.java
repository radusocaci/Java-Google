import java.util.LinkedList;
import java.util.List;

public class Consumer {
    private final LinkedList list;

    public Consumer(LinkedList<String> list) {
        this.list = list;
    }

    public void consume() {
        Thread t = new Thread() {
            @Override
            public void start() {
                //while (true) {
                    try {
                        synchronized (list) {
                            System.out.println("Consuned " + list.poll());
                            System.out.println(list);
                        }

                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
               // }
            }
        };

        t.setDaemon(true);
        t.start();
    }
}
