import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WordCountClient {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java WordCountClient <file_name> <server_address>");
            return;
        }

        String fileName = args[0];
        String serverAddress = args[1];
        final int PORT = 12345;

        try (Socket socket = new Socket(serverAddress, PORT);
             BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connected to server " + serverAddress + " on port " + PORT);

            String line;
            while ((line = fileReader.readLine()) != null) {
                out.println(line);
            }

            // Send end-of-transmission signal
            out.println("xxxx");

            // Receive response from server
            String serverResponse = in.readLine();
            System.out.println("Server response: " + serverResponse);

        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
