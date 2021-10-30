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
        flower.setSepalLength(5);
        assertEquals(5, flower.getSepalLength());
    }

    @Test
    void getColor() {
        assertEquals(FlowerColor.RED, flower.getColor());
        flower.setColor(FlowerColor.PINK);
        assertEquals(FlowerColor.PINK, flower.getColor());
    }

    @Test
    void getType() {
        assertEquals(FlowerType.ROSE, flower.getType());
        flower.setType(FlowerType.TULIP);
        assertEquals(FlowerType.TULIP, flower.getType());
    }

    @Test
    void testToString() {
        assertEquals("flower.Flower(price=10.0, sepalLength=2.5, color=RED, type=ROSE)", flower.toString());
        flower.setColor(FlowerColor.PINK);
        flower.setPrice(8.7);
        assertEquals("flower.Flower(price=8.7, sepalLength=2.5, color=PINK, type=ROSE)", flower.toString());
    }
}