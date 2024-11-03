// Target Interface
interface Shape {
    void draw();
}

// Adaptee Class: Legacy Rectangle with a different interface
class Rectangle {
    private int width, height;

    // Legacy method for drawing a rectangle
    public void drawLegacy() {
        System.out.println("Drawing Rectangle using legacy method");
    }
}

// Adaptee Class: Legacy Circle with a different interface
class Circle {
    private int radius;

    // Legacy method for drawing a circle
    public void drawLegacy() {
        System.out.println("Drawing Circle using legacy method");
    }
}

// Adapter Class for Rectangle to adapt it to the Shape interface
class RectangleAdapter implements Shape {
    private Rectangle rectangle;

    public RectangleAdapter(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public void draw() {
        rectangle.drawLegacy(); // Calls the legacy method
    }
}

// Adapter Class for Circle to adapt it to the Shape interface
class CircleAdapter implements Shape {
    private Circle circle;

    public CircleAdapter(Circle circle) {
        this.circle = circle;
    }

    @Override
    public void draw() {
        circle.drawLegacy(); // Calls the legacy method
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        // Create instances of legacy classes
        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle();

        // Create adapter instances to adapt legacy classes to the Shape interface
        Shape rectangleShape = new RectangleAdapter(rectangle);
        Shape circleShape = new CircleAdapter(circle);

        // Use the Shape interface to draw both rectangles and circles
        rectangleShape.draw(); // Calls Rectangle's drawLegacy through the adapter
        circleShape.draw();    // Calls Circle's drawLegacy through the adapter
    }
}
