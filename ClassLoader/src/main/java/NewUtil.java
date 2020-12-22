import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NewUtil {
    static String fromConsole() {
        StringBuilder str = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String console = br.readLine();
            while (!console.isEmpty()) {
                str.append(console);
                console = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    static String readFromClass() {
        StringBuilder str = new StringBuilder();
        Path path = Paths.get("src").resolve("main").resolve("java").resolve("SomeClass.java");
        try (BufferedReader br = new BufferedReader(new FileReader(String.valueOf(path)))) {
            String readLine = br.readLine();
            while (br.ready()) {
                str.append(readLine);
                readLine = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    static String getNewCode() {
        String toSomeClassCode = readFromClass();
        String someCode = fromConsole();
        return toSomeClassCode.substring(0, (toSomeClassCode.indexOf("doWork()") + 10)) + "\n" +
                someCode + "\n" + "}\n}\n";
    }

    static void createAndCompile(File file, String code) throws IOException {
        file.createNewFile();
        Files.write(file.toPath(), code.getBytes(StandardCharsets.UTF_8));
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        javaCompiler.run(null, null, null, file.getPath());
    }

    static Worker loadClass(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader newClassLoader = new NewClassloader();
        Class<?> loadClass = newClassLoader.loadClass(name);
        return (Worker) loadClass.newInstance();
    }
}