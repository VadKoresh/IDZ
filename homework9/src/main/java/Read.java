import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Read {

    public static String readFile(String name) {
        BufferedReader br;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(name));
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}