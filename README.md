
# 🛠️ TP Design Patterns Lab

This project showcases multiple design patterns in Java, with implementations for the Strategy, Bridge, Decorator, and Adaptor patterns. Each pattern has its own example demonstrating unique design principles. 

# 🛠️ TP Design Patterns Lab

This project showcases multiple design patterns in Java, with implementations for Strategy, Bridge, Decorator, Adapter, Facade, Proxy, Chain of Responsibility, Mediator, and State patterns. Each pattern includes an example demonstrating key design principles.

## 📖 Project Overview

### Patterns Implemented
1. **🎲 Strategy Pattern**: Demonstrates sorting algorithms (e.g., Bubble Sort, Quick Sort, Merge Sort) with two variations in data handling between the context and strategy.
2. **🌉 Bridge Pattern**: Separates abstraction from implementation, allowing both to vary independently.
3. **🎨 Decorator Pattern**: Dynamically adds behavior to objects by wrapping them in decorator classes.
4. **🔌 Adapter Pattern**: Allows incompatible interfaces to work together by creating an adapter.
5. **🗂️ Facade Pattern**: Provides a simplified interface to complex subsystems.
6. **👤 Proxy Pattern**: Controls access to an object, allowing for additional features like lazy loading and access control.
7. **🔗 Chain of Responsibility Pattern**: Passes requests along a chain of handlers, with each handler deciding whether to process the request.
8. **💬 Mediator Pattern**: Enables communication between objects without them knowing each other’s details, reducing dependencies.
9. **📈 State Pattern**: Allows an object to change its behavior when its internal state changes.

## 🌟 Features
- **Design Patterns**: Clear examples of Strategy, Bridge, Decorator, Adapter, Facade, Proxy, Chain of Responsibility, Mediator, and State patterns.
- **Flexible Implementations**: Demonstrates different approaches within each pattern.

## 🚀 Getting Started

### ✅ Prerequisites
Ensure Java is installed:
```bash
java -version
```

### 🏃 Compilation and Execution

1. Navigate to the specific pattern's folder (e.g., `Decorator`, `Adapter`, `Bridge`, etc.).
2. Compile Java files:
   ```bash
   javac *.java
   ```
3. Run the example:
   ```bash
   java MainClassName  # Replace "MainClassName" with the actual main class name for each pattern
   ```

## 📂 Project Structure
- `src/Strategy`: Sorting algorithms using the Strategy Pattern.
  - `Approach1`: Context passes data to the strategy.
  - `Approach2`: Strategy accesses data from context.
- `src/Bridge`: Demonstrates abstraction separated from implementation.
- `src/Decorator`: Adds dynamic behavior to objects.
- `src/Adapter`: Connects incompatible interfaces.
- `src/Facade`: Provides a simplified interface for complex subsystems.
- `src/Proxy`: Manages access to another object.
- `src/ChainOfResponsibility`: Passes requests down a chain of handlers.
- `src/Mediator`: Facilitates communication between objects with reduced coupling.
- `src/State`: Alters object behavior based on internal state.

## 📜 License

