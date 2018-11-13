public class MyClosableResource implements AutoCloseable {
    @Override
    public void close() throws Exception01 {
        throw new Exception01("close exception occured!");
    }
}
