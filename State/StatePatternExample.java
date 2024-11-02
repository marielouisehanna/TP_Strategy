// Define the State interface
interface TrafficLightState {
    void displayState();
}

// Implement concrete states
class RedState implements TrafficLightState {
    @Override
    public void displayState() {
        System.out.println("Traffic Light is Red");
    }
}

class GreenState implements TrafficLightState {
    @Override
    public void displayState() {
        System.out.println("Traffic Light is Green");
    }
}

class YellowState implements TrafficLightState {
    @Override
    public void displayState() {
        System.out.println("Traffic Light is Yellow");
    }
}

// Context class that maintains the current state
class TrafficLight {
    private TrafficLightState currentState;

    // Initialize with the Red state as the default
    public TrafficLight() {
        currentState = new RedState();
    }

    public void setState(TrafficLightState state) {
        currentState = state;
    }

    public void displayCurrentState() {
        currentState.displayState();
    }
}

// Main class to demonstrate the State Pattern
public class StatePatternExample {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        // Initially, the traffic light is Red
        trafficLight.displayCurrentState();

        // Change the state to Green
        trafficLight.setState(new GreenState());
        trafficLight.displayCurrentState();

        // Change the state to Yellow
        trafficLight.setState(new YellowState());
        trafficLight.displayCurrentState();
    }
}
