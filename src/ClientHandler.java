import java.io.*;
import java.net.Socket;

public class ClientHandler {
    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public ClientHandler(Socket client) throws Exception {
        if (client == null)
            throw new Exception("client can't be null");
        this.socket = client;
        dataOutputStream = new DataOutputStream(client.getOutputStream());
        dataInputStream = new DataInputStream(client.getInputStream());
        run();
    }

    public void run() {
        try {
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = br.readLine();
            handleIncomingMessages(str);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleIncomingMessages(String message) {
        System.out.println("Message recieved:" + message);
    }
}
