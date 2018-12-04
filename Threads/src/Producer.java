import java.util.LinkedList;

public class Producer {
    private LinkedList<String> list;

    public Producer(LinkedList<String> list) {
        this.list = list;
    }

    public void produce() {
        new Thread() {
            @Override
            public void run() {
                for(int i=0 ; i<10 ; i++) {
                    String payload = "Payload" + i;
                    list.push(payload);

                    System.out.println("produced" + payload);
                    System.out.println(list);
                }
            }
        }.start();
    }
}
