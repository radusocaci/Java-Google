import java.io.IOException;
import java.sql.SQLException;

public class Exec1 {
    public static void main(String[] args) {
        try {
            if (1 == 1) throw new IOException("");
            if (1 == 2) throw new SQLException("");
        } catch (IOException | SQLException ex) {
            System.out.println(ex);
        }

        System.out.println(test());
    }

    public static int test() { //what will this method return ?
        try {
            throw new RuntimeException("something bad happened");
            //return 0;
        } catch(Exception e) {
            return 1;
        } finally {
            return 2;
        }
    }

}
