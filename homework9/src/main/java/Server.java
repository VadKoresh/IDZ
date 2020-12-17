import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static int PORT_SERVER = 8080;
    private static String directory = "C:\\Личная папка";

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(PORT_SERVER);
        System.out.println("Сервер запущен....");
        while (true){
            Socket socket = serverSocket.accept();
            Handler handler = new Handler(socket, directory);
            Thread thread = new Thread(handler);
            thread.start();
        }
    }
}
