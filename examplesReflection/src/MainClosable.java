public class MainClosable {
    public static void main(String[] args) {
        try (
                MyClosableResource resource = new MyClosableResource();
        ) {
            throw new Exeption02("Error when doing work");
        } catch (Exception ex) {
            System.err.println("Exception encountered: " + ex.toString());
            final Throwable[] suppressedExceptions = ex.getSuppressed();
            final int numSuppressed = suppressedExceptions.length;
            if (numSuppressed > 0) {
                System.err.println("found " + numSuppressed + " suppressed ex:");
                for (final Throwable exception : suppressedExceptions) {
                    System.err.println("suppressed" + exception.toString());
                }
            }
        }
    }
}
