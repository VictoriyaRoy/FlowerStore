import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerPackTest {
    FlowerPack pack;
    Flower rose;

    @BeforeEach
    void setUp() {
        rose = new Flower(2.5, FlowerColor.RED, 10.0, FlowerType.ROSE);
        pack = new FlowerPack(rose, 9);
    }

    @Test
    void getPrice() {
        assertEquals(90, pack.getPrice());
        rose.setPrice(7.0);
        assertEquals(63, pack.getPrice());
    }

    @Test
    void getColor() {
        assertEquals(FlowerColor.RED, pack.getColor());
        rose.setColor(FlowerColor.PINK);
        assertEquals(FlowerColor.PINK, pack.getColor());
    }

    @Test
    void getFlower() {
        assertEquals(rose, pack.getFlower());
        rose.setPrice(7.0);
        assertEquals(rose, pack.getFlower());
    }
}