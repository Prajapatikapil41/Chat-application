package client;

import java.io.*;
import java.net.*;

public class ChatClient {

    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 1234;

        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected to chat server");

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            // First, get name from console and send it
            System.out.print(serverReader.readLine() + " ");  // "Enter your name:"
            String name = consoleReader.readLine();
            writer.println(name);

            // Thread for reading messages from server
            new Thread(() -> {
                String serverMessage;
                try {
                    while ((serverMessage = serverReader.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            }).start();

            // Main thread to send messages
            String userInput;
            while ((userInput = consoleReader.readLine()) != null) {
                writer.println(userInput);
                if (userInput.equalsIgnoreCase("exit")) {
                    socket.close();
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Error connecting to server: " + e.getMessage());
        }
    }
}
