import java.io.IOException;
import java.sql.SQLException;

public class Exec2 {
    public static void main(String[] args) {
        try {
            if (1==1) throw new IOException("");
            if (1==2) throw new SQLException("");
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
