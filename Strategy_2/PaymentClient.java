// Step 1: Define the Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Step 2: Concrete Strategy Classes for Each Payment Method
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card ending in " + cardNumber.substring(cardNumber.length() - 4));
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal account " + email);
    }
}

class CryptoPayment implements PaymentStrategy {
    private String walletAddress;

    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Cryptocurrency wallet " + walletAddress);
    }
}

// Step 3: Context Class that uses a Payment Strategy
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment method not set");
        }
        paymentStrategy.pay(amount);
    }
}

// Client Code
public class PaymentClient {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Using Credit Card Payment
        cart.setPaymentStrategy(new CreditCardPayment("1234567890123456"));
        cart.checkout(100.0);

        // Switching to PayPal Payment
        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(150.0);

        // Switching to Cryptocurrency Payment
        cart.setPaymentStrategy(new CryptoPayment("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa"));
        cart.checkout(200.0);
    }
}
