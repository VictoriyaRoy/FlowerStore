package flower;

import flower.Flower;
import flower.FlowerColor;
import flower.FlowerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerTest {
    Flower flower;

    @BeforeEach
    void setUp() {
        flower = new Flower(2.5, FlowerColor.RED, 10.0, FlowerType.ROSE);
    }

    @Test
    void getPrice() {
        assertEquals(10, flower.getPrice());
        flower.setPrice(8.7);
        assertEquals(8.7, flower.getPrice());
    }

    @Test
    void getSepalLength() {
        assertEquals(2.5, flower.getSepalLength());
    }

    @Test
    void getColor() {
        assertEquals(FlowerColor.RED, flower.getColor());
    }

    @Test
    void getType() {
        assertEquals(FlowerType.ROSE, flower.getType());
    }
}