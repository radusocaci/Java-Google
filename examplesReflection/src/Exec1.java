import static java.lang.System.*;

public class Exec1 {
    public static void main(String[] args) {
        int returnValue = test();
        out.println(returnValue + "");
    }

    public static int test() { //what will this method return ?
        try {
            throw new RuntimeException("something bad happened");
            //return 0;
        } catch(Exception e) {
            StackTraceElement elements[] = e.getStackTrace();
            for(StackTraceElement element : elements) {
                err.println(element.getFileName() + ": " + element.getLineNumber() + " >> " + element.getMethodName() + "()");
            }
            return 1;
        } finally {
            return 2;
        }
    }

}
