package delivery;

import flower.Flower;
import flower.FlowerColor;
import flower.FlowerType;
import flower.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryTest {
    LinkedList<Item> items;

    @BeforeEach
    void setUp() {
        items = new LinkedList<>();
        Item flower = new Flower(2.5, FlowerColor.RED, 15, FlowerType.ROSE);
        items.add(flower);
    }

    @Test
    void deliverByPost() {
        Delivery post = new PostDeliveryStrategy();
        assert post.deliver(items);
    }

    @Test
    void deliverByDHL() {
        Delivery dhl = new DHLDeviveyStrategy();
        assert dhl.deliver(items);
    }
}