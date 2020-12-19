
import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Scanner;

public class Handler extends Thread {

    private Socket socket;
    private String directory;

    public Handler(Socket socket, String directory) {
        this.socket = socket;
        this.directory = directory;
    }

    @Override
    public void run() {
        try {
            PrintWriter output = new PrintWriter(this.socket.getOutputStream());
            String url = getReguestURL(this.socket.getInputStream());
            Path filePath = Paths.get(directory + url);
            if (Files.exists(filePath)) {
                output.println("HTTP/1.1 200 OK");
                output.println("Content-Type:text/html; charset=UTF-8");
                output.println();
                File file = new File(String.valueOf(filePath));
                File[] files = file.listFiles();
                for (File value : files) {
                    output.println(value.getName() + "<br>");
                }
                output.flush();
            } else {
                // раз и в том и в другом случае возвращаете такой код и Content-type, то вынесите за пределы if
                output.println("HTTP/1.1 200 OK");
                output.println("Content-Type:text/html; charset=UTF-8");
                output.println();
                output.println("<p>404 NOT FOUND</p>");
                output.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String getReguestURL(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream).useDelimiter("\r\n");
        String url = scanner.next();
        // добавьте ещё проверку на то, что запрос выглядит как
        // GET <урл> HTTP/1.1
        return url.split(" ")[1];
    }
}
