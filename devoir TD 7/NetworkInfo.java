import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkInfo {

    public static void main(String[] args) {
        try {
            // Partie 1 : Afficher l'adresse IP et le hostname de la machine locale
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Adresse IP de la machine locale : " + localHost.getHostAddress());
            System.out.println("Nom d'hôte de la machine locale : " + localHost.getHostName());

            // Vérifier si des arguments sont fournis pour getByName et getAllByName
            if (args.length == 0) {
                System.out.println("\nVeuillez fournir des arguments pour getByName et getAllByName (ex: titan, jupiter, cnn.com).");
                return;
            }

            // Partie 2 : Utilisation de getByName
            for (String host : args) {
                try {
                    InetAddress address = InetAddress.getByName(host);
                    System.out.println("\nRésultat de getByName pour \"" + host + "\":");
                    System.out.println("Adresse IP : " + address.getHostAddress());
                    System.out.println("Nom d'hôte : " + address.getHostName());
                } catch (UnknownHostException e) {
                    System.out.println("\nErreur avec getByName pour \"" + host + "\": " + e.getMessage());
                }
            }

            // Partie 3 : Utilisation de getAllByName
            for (String host : args) {
                try {
                    InetAddress[] addresses = InetAddress.getAllByName(host);
                    System.out.println("\nRésultats de getAllByName pour \"" + host + "\":");
                    for (InetAddress addr : addresses) {
                        System.out.println("Adresse IP : " + addr.getHostAddress());
                    }
                } catch (UnknownHostException e) {
                    System.out.println("\nErreur avec getAllByName pour \"" + host + "\": " + e.getMessage());
                }
            }
        } catch (UnknownHostException e) {
            System.out.println("Erreur : Impossible d'obtenir les informations locales : " + e.getMessage());
        }
    }
}
