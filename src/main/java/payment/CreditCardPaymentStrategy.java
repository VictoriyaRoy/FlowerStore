package payment;

public class CreditCardPaymentStrategy implements Payment{
    @Override
    public boolean pay(double price) {
        System.out.println("Pay " + price + " by credit card");
        return true;
    }
}
