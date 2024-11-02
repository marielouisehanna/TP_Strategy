// Adapter-Object Pattern

// Adaptee class - defines an existing interface that needs adapting
class DataAdaptee {
    // Specific request method in Adaptee - this is the method that the adapter will use
    public void printAdaptee() {
        System.out.println("Je suis de la classe DataAdaptee");
    }
}

// Target interface - defines the domain-specific interface that the Client uses
abstract class DataAdapterAbstract {
    // Abstract method to be implemented by the Adapter class
    public abstract void print();
}

// Adapter class - adapts the Adaptee to the Target interface
class DataAdapterConcrete extends DataAdapterAbstract {
    // Reference to an instance of the Adaptee
    private DataAdaptee dataAdaptee;

    // Constructor initializes the Adaptee instance
    public DataAdapterConcrete() {
        dataAdaptee = new DataAdaptee();
    }

    // Implementation of the Target method, which internally uses the Adaptee's method
    public void print() {
        dataAdaptee.printAdaptee(); // Delegates the request to the Adaptee
    }
}

// Client class - uses the Target interface and is not aware of the Adaptee
public class AdapterDemo {
    // Reference to the Target interface
    private DataAdapterAbstract dataTarget;

    // Client constructor initializes the Adapter to interact with the Adaptee
    public AdapterDemo() {
        dataTarget = new DataAdapterConcrete(); // Adapter wraps the Adaptee
        dataTarget.print(); // Client calls the Adapter's method, which adapts to the Adaptee
    }

    // Main method - entry point for the program
    public static void main(String[] args) {
        new AdapterDemo(); // Runs the Client
    }
}
