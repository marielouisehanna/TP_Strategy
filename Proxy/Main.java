// Service Interface (Subject)
interface Service {
    /**
     * Offers a bouquet of flowers.
     * @param b the bouquet
     * @return success or failure of the operation
     */
    public boolean offrir(Bouquet b);
}

// Implementation of the Service (Real Subject)
 class ServiceImpl implements Service {
    @Override
    public boolean offrir(Bouquet b) {
        System.out.println("Recevez ce bouquet : " + b);
        return true;
    }
}

// Proxy Class (Proxy)
class ServiceProxy implements Service {
    private Service service;

    public ServiceProxy() {
        // Initialize the real service that this proxy represents
        this.service = new ServiceImpl();
    }

    @Override
    public boolean offrir(Bouquet bouquet) {
        System.out.print("Par procuration : ");
        // Delegates the offer operation to the real service
        return service.offrir(bouquet);
    }
}

// Bouquet Class (used in Service methods)
class Bouquet {
    private String flowers;

    public Bouquet(String flowers) {
        this.flowers = flowers;
    }

    @Override
    public String toString() {
        return flowers;
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        // Creating a bouquet instance
        Bouquet unBouquet = new Bouquet("Roses");

        // Directly offering the bouquet (without proxy)
        Service directService = new ServiceImpl();
        boolean directResult = directService.offrir(unBouquet);
        System.out.println("Résultat direct : " + directResult);

        // Offering the bouquet through a proxy
        Service proxyService = new ServiceProxy();
        boolean proxyResult = proxyService.offrir(unBouquet);
        System.out.println("Résultat via proxy : " + proxyResult);
    }
}
