import java.util.LinkedList;
import java.util.List;

public class Producer {
    private LinkedList<String> list;

    public Producer(LinkedList<String> list) {
        this.list = list;
    }

    public void produce() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String payload = "Payload" + i;
                list.push(payload);

                System.out.println("produced " + payload);
                System.out.println(list);
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
