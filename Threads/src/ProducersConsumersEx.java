import java.util.LinkedList;

public class ProducersConsumersEx {

    public static void main(String[] args) {
        LinkedList<String> sharedList = new LinkedList<>();
        Producer p = new Producer(sharedList);
        Consumer c = new Consumer(sharedList);
        c.consume();
        p.produce();
    }
}
