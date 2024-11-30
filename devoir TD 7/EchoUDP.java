import java.net.*;
import java.util.Scanner;

public class EchoUDP {

    public static void main(String[] args) {
        Thread serverThread = new Thread(() -> runServer());
        Thread clientThread = new Thread(() -> runClient());

        serverThread.start();
        clientThread.start();
    }

    // Method to run the server
    public static void runServer() {
        final int PORT = 9876;

        try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {
            System.out.println("Serveur UDP 'Echo' démarré sur le port " + PORT);

            byte[] receiveBuffer = new byte[1024];
            byte[] sendBuffer;

            while (true) {
                // Receive message from client
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket);
                String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());

                System.out.println("Serveur - Message reçu : " + clientMessage);

                // Check if the client wants to quit
                if (clientMessage.equalsIgnoreCase("quit")) {
                    System.out.println("Le client a demandé la déconnexion. Arrêt du serveur.");
                    break;
                }

                // Prepare the echo response
                sendBuffer = clientMessage.getBytes();

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
                System.out.println("Serveur - Message envoyé au client : " + clientMessage);
            }
        } catch (Exception e) {
            System.err.println("Erreur serveur : " + e.getMessage());
        }
    }

    // Method to run the client
    public static void runClient() {
        final int PORT = 9876;
        final String SERVER_ADDRESS = "localhost";

        try (DatagramSocket clientSocket = new DatagramSocket();
             Scanner scanner = new Scanner(System.in)) {

            InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS);

            System.out.println("Client UDP connecté au serveur " + SERVER_ADDRESS + " sur le port " + PORT);
            System.out.println("Tapez vos messages (écrivez 'quit' pour arrêter) :");

            byte[] sendBuffer;
            byte[] receiveBuffer = new byte[1024];

            while (true) {
                // Read user input
                System.out.print("Client - Vous : ");
                String userMessage = scanner.nextLine();

                // Send message to server
                sendBuffer = userMessage.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, PORT);
                clientSocket.send(sendPacket);

                if (userMessage.equalsIgnoreCase("quit")) {
                    System.out.println("Client - Déconnexion.");
                    break;
                }

                // Receive response from server
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                clientSocket.receive(receivePacket);
                String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Client - Serveur : " + serverResponse);
            }
        } catch (Exception e) {
            System.err.println("Erreur client : " + e.getMessage());
        }
    }
}
