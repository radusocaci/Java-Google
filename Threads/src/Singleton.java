public class Singleton {
    private static Singleton instance;

    private Singleton() {
        super();
    }

    // make it synchronized to ensure multiple threads get the same object
    // once a thread enters the method, others are locked
    public synchronized static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}
