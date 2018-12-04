import java.util.LinkedList;

public class ProducerConsumerMain {
    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<>();
        Producer producer = new Producer(list);
        Consumer consumer = new Consumer(list);

        producer.produce();
        consumer.consume();
    }
}
