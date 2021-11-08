import delivery.PostDeliveryStrategy;
import org.junit.jupiter.api.Test;
import payment.PayPalPaymentStrategy;

import static org.junit.jupiter.api.Assertions.*;

class QuickOrderTest {

    @Test
    void createOrder() {
        Order order = QuickOrder.ROSE_BUCKET.createOrder(5, new PayPalPaymentStrategy(), new PostDeliveryStrategy());
        assertEquals(5*15, order.calculateTotalPrice());
        assertEquals(1, order.getItems().size());
        assertInstanceOf(PayPalPaymentStrategy.class, order.getPayment());
        assertInstanceOf(PostDeliveryStrategy.class, order.getDelivery());
        assert order.processOrder();
    }
}