import delivery.DHLDeviveyStrategy;
import delivery.PostDeliveryStrategy;
import flower.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.CreditCardPaymentStrategy;
import payment.PayPalPaymentStrategy;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    Order order;
    Item rose, bucket;

    @BeforeEach
    void setUp() {
        rose = new Flower(5, FlowerColor.RED, 15, FlowerType.ROSE);
        FlowerPack rose_pack = new FlowerPack((Flower) rose, 10);
        bucket = new FlowerBucket();
        ((FlowerBucket) bucket).addFlowerPack(rose_pack);

        order = new Order();
        order.addItem(bucket);
    }

    @Test
    void calculateTotalPrice() {
        assertEquals(150, order.calculateTotalPrice());
        order.addItem(rose);
        assertEquals(165, order.calculateTotalPrice());
    }

    @Test
    void processOrder() {
        assert !order.processOrder(); //not set payment and delivery
        order.setPayment(new CreditCardPaymentStrategy());
        order.setDelivery(new PostDeliveryStrategy());
        assert order.processOrder();
    }

    @Test
    void addItem() {
        assertEquals(1, order.getItems().size());
        order.addItem(rose);
        assertEquals(2, order.getItems().size());
        order.addItem(rose);
        assertEquals(3, order.getItems().size());
    }

    @Test
    void removeItem() {
        assertEquals(1, order.getItems().size());
        order.removeItem(rose); //item isn't in order
        assertEquals(1, order.getItems().size());
        order.removeItem(bucket);
        assert order.getItems().isEmpty();
    }

    @Test
    void setPayment() {
        assertNull(order.getPayment());
        order.setPayment(new CreditCardPaymentStrategy());
        assertInstanceOf(CreditCardPaymentStrategy.class, order.getPayment());
        order.setPayment(new PayPalPaymentStrategy());
        assertInstanceOf(PayPalPaymentStrategy.class, order.getPayment());
    }

    @Test
    void setDelivery() {
        assertNull(order.getDelivery());
        order.setDelivery(new PostDeliveryStrategy());
        assertInstanceOf(PostDeliveryStrategy.class, order.getDelivery());
        order.setDelivery(new DHLDeviveyStrategy());
        assertInstanceOf(DHLDeviveyStrategy.class, order.getDelivery());
    }
}