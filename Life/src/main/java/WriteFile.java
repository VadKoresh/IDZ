import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void writeFile(String name, Character[][] matrix) throws IOException {
        FileWriter fileWriter = new FileWriter(new File(name));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                fileWriter.write(matrix[i][j] + " ");
            }
            fileWriter.write("\n");
        }
        fileWriter.close();
    }
}