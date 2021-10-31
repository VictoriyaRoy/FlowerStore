package payment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @Test
    void pay() {
        Payment creditCard = new CreditCardPaymentStrategy();
        assert creditCard.pay(25);
        Payment payPal = new PayPalPaymentStrategy();
        assert payPal.pay(25);
    }
}