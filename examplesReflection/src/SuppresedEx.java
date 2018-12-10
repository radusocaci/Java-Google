import java.io.IOException;

public class SuppresedEx {
    public static void naughtyFunction() throws IOException {

    }

    public static void main(String[] args){
        try {
            naughtyFunction();
        } catch (IOException ex) {
            System.err.println("Exception encountered: " + ex.toString());

            final Throwable[] suppresedExceptions = ex.getSuppressed();
            if(suppresedExceptions.length > 0) {
                System.err.println("Fount" + suppresedExceptions.length + " suppresed exceptions");
                for(final Throwable t : suppresedExceptions) {
                    System.err.println("Suppresed" + t.toString());
                }
            }
        }
    }
}
