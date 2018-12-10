import java.util.LinkedList;
import java.util.Random;

public class Producer {

    private LinkedList<String> list;
    private Random random = new Random();

    public Producer(LinkedList<String> list) {
        this.list = list;
    }

    public void produce() {
        new Thread() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    synchronized (list){
                        String payload = "P"+i;
                        list.push(payload);
                        System.out.println("produced "+payload);
                        System.out.println("list content "+list);
                        //list.notify();
                    }
                    try {
                        Thread.sleep(500+random.nextInt(1000));
                    } catch (InterruptedException e) {
                        // TODO: 17/07/2018 handle error
                    }
                }
            }
        }.start();
    }
}
