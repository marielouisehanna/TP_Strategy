import java.io.*;
import java.net.*;

public class SingleThreadedWordCountServer {

    public static void main(String[] args) {
        final int PORT = 12345;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Single-threaded Word Count Server started on port " + PORT);

            while (true) {
                System.out.println("Waiting for a client...");
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("Client connected from: " + clientSocket.getInetAddress());

                    int wordCount = 0;
                    String line;
                    while ((line = in.readLine()) != null) {
                        if (line.equalsIgnoreCase("xxxx")) {
                            break;
                        }
                        wordCount += countWords(line);
                    }

                    System.out.println("Total words received: " + wordCount);
                    out.println("Total words counted: " + wordCount);
                } catch (IOException e) {
                    System.err.println("Error with client connection: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    private static int countWords(String line) {
        if (line == null || line.trim().isEmpty()) {
            return 0;
        }
        return line.trim().split("\\s+").length;
    }
}
