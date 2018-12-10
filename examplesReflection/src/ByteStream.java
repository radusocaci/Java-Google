import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ByteStream {
    public static void main(String[] args) throws IOException {
        try {
            FileInputStream in = new FileInputStream("in.txt");
            FileOutputStream out = new FileOutputStream("out.txt");

            int c;

            while((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException ex) {
            Logger logger = Logger.getLogger(ByteStream.class.getName());
            logger.setLevel(Level.WARNING);
            logger.addHandler(new FileHandler("Log.txt"));

            logger.warning(ex.toString());
        }
    }
}
