import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainProducerConsumer {

    public static void main (String args[]) {
        LinkedList<String> list = new LinkedList<>();
        Producer producer = new Producer(list);
        Consumer consumer = new Consumer(list);

        producer.produce();
        consumer.consume();

    }
}
