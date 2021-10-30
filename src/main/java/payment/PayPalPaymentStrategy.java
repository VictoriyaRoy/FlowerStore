package payment;

public class PayPalPaymentStrategy implements Payment{
    @Override
    public boolean pay(double price) {
        System.out.println("Pay " + price + " by PayPal");
        return true;
    }
}
