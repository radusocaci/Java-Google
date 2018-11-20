import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class InputLargeFIle {
    public static void main(String[] args) {
        Path filePath = Paths.get("file.txt");
        try {
            FileChannel fc = FileChannel.open(filePath, StandardOpenOption.READ);
            ByteBuffer buf = ByteBuffer.allocate(1024);
            int readBytes = fc.read(buf);

            while(readBytes != -1) {
                System.out.println("bytes read: " + readBytes);

                byte[] dst = new byte[readBytes];
                System.out.println("buffer: " + new String(dst, "UTF-8"));

                buf.get(dst);
                buf.clear(); // make buffer ready for writing
                readBytes = fc.read(buf);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
