package exercises;

public class Ex3 {
    public static void main(String[] args) {
        Channel c = new Channel();
        (new Consumer(c)).start();
        (new Producer(c)).start();
    }

    static class Producer extends Thread {
        private Channel c;

        public Producer(Channel c) {
            this.c = c;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                c.put("msg_" + i);
            }

            c.put("DONE");
        }
    }

    static class Consumer extends Thread {
        private Channel c;

        public Consumer(Channel c) {
            this.c = c;
        }

        @Override
        public void run() {
            String msg = c.take();

            while (!msg.equals("DONE")) {
                System.out.println(msg);
                msg = c.take();
            }
        }
    }

    static class Channel {
        private String message;
        private boolean isChannelEmpty = true;

        public synchronized String take() {
            if (isChannelEmpty) {
                callWaitMethod();
            }
            isChannelEmpty = true;
            notifyAll();
            return message;
        }


        public synchronized void put(String message) {
            if (!isChannelEmpty) {
                callWaitMethod();
            }
            this.message = message;
            isChannelEmpty = false;
            notifyAll();
        }

        private void callWaitMethod() {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
