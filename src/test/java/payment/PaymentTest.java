package payment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @Test
    void payByCard() {
        Payment creditCard = new CreditCardPaymentStrategy();
        assert creditCard.pay(25);
    }

    @Test
    void payByPayPal() {
        Payment payPal = new PayPalPaymentStrategy();
        assert payPal.pay(25);
    }
}