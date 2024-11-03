import java.util.*;

// Target Interface
interface Image {
    void displayImage();
}

// RealImage class (on System A) - The actual image implementation
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading " + filename);
    }

    @Override
    public void displayImage() {
        System.out.println("Displaying " + filename);
    }
}

// ProxyImage class (on System B) - The proxy that controls access to RealImage
class ProxyImage implements Image {
    private String filename;
    private Image image;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void displayImage() {
        // Lazy loading: only creates the RealImage when displayImage is called
        if (image == null) {
            image = new RealImage(filename);
        }
        image.displayImage();
    }
}

// Client code
public class ProxyExample {
    public static void main(String[] args) {
        // Using the ProxyImage to access RealImage
        Image image1 = new ProxyImage("HiRes_10MB_Photo1");
        Image image2 = new ProxyImage("HiRes_10MB_Photo2");

        // Display images (loading only happens on the first display)
        image1.displayImage(); // Loads and displays HiRes_10MB_Photo1
        image2.displayImage(); // Loads and displays HiRes_10MB_Photo2
    }
}
