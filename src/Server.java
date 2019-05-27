import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static final int PORT = 1234;
    private ServerSocket serverSocket;
    private ArrayList<String> onlineUsers;

    public Server() throws Exception {
        serverSocket = new ServerSocket(PORT);
        onlineUsers = new ArrayList<>();
        while (true) {
            Socket client = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(client);
        }
    }

    public void addOnlineUser(String user) {
        this.onlineUsers.add(user);
    }

    public ArrayList<String> getOnlineUsers() {
        return onlineUsers;
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server();
    }
}
