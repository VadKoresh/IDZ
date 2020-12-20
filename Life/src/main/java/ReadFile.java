import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public static Character[][] readFile(String name) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(name)));
        String[] buffer = bufferedReader.readLine().trim().split(" ");

        Character[][] matrix = new Character[buffer.length][buffer.length];
        for (int i = 0; i < matrix.length; i++) {
            String[] els = bufferedReader.readLine().trim().split(" ");
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = els[j].charAt(0);
            }
        }
        bufferedReader.close();
        return matrix;
    }

}
