
import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Scanner;

public class Handler extends Thread {

    private Socket socket;
    private String directory;
    private final String NOT_FOUND
            = "C:/Users/Valiev/Desktop/innopolis/homework/homework18/src/main/resources/not_found.txt";

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
            output.println("HTTP/1.1 200 OK");
            output.println("Content-Type:text/html; charset=UTF-8");
            if (Files.exists(filePath)) {
                output.println();
                File file = new File(String.valueOf(filePath));
                File[] files = file.listFiles();
                for (File value : files) {
                    output.println(value.getName() + "<br>");
                }
                output.flush();
            } else {
                output.println();
                output.println(Read.readFile(NOT_FOUND));
                output.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String getReguestURL(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream).useDelimiter("\r\n");
        String url = scanner.next();
        if (url.equals("GET " + url.split(" ")[1] + " HTTP/1.1")){
            return url.split(" ")[1];
        }
        return "";
    }
}
