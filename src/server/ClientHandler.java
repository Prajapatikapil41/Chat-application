package server;

import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String clientName;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public String getClientName() {
        return clientName;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("Enter your name:");
            clientName = in.readLine();

            if (clientName == null || clientName.trim().isEmpty()) {
                System.out.println("No name entered. Disconnecting client.");
                return;
            }

            System.out.println(clientName + " joined the chat.");
            ChatServer.broadcast(clientName + " joined the chat.", this);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println(clientName + ": " + message);
                ChatServer.broadcast(clientName + ": " + message, this);
            }

        } catch (IOException e) {
            System.out.println("Error with client " + clientName);
            System.err.println("Error closing socket: " + e.getMessage());
        } finally {
            ChatServer.removeClient(this);
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Error closing socket: " + e.getMessage());
            }
            ChatServer.broadcast(clientName + " left the chat.", this);
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}
