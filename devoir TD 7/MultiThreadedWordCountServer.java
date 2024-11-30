import java.io.*;
import java.net.*;

public class MultiThreadedWordCountServer {

    public static void main(String[] args) {
        final int PORT = 12345;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Multi-threaded Word Count Server started on port " + PORT);

            while (true) {
                System.out.println("Waiting for a client...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from: " + clientSocket.getInetAddress());

                // Pass the client socket to a new thread
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    // Helper class to handle clients in a separate thread
    static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                int wordCount = 0;
                String line;
                while ((line = in.readLine()) != null) {
                    if (line.equalsIgnoreCase("xxxx")) {
                        break;
                    }
                    wordCount += countWords(line);
                }

                System.out.println("Total words received for this client: " + wordCount);
                out.println("Total words counted: " + wordCount);
            } catch (IOException e) {
                System.err.println("Error with client connection: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Error closing client socket: " + e.getMessage());
                }
            }
        }

        private int countWords(String line) {
            if (line == null || line.trim().isEmpty()) {
                return 0;
            }
            return line.trim().split("\\s+").length;
        }
    }
}
