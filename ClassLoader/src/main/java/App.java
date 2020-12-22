import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException,
            ClassNotFoundException {
        Worker worker = new SomeClass();
        System.out.println("Исходный файл:");
        worker.doWork();
        Path path = Paths.get("src").resolve("main").resolve("java").resolve("SomeClass.java");
        String newCode = NewUtil.getNewCode();
        File newFile = new File(String.valueOf(path));
        NewUtil.createAndCompile(newFile, newCode);
        worker = NewUtil.loadClass("SomeClass");
        System.out.println("Файл после изменения.");
        worker.doWork();
    }
}