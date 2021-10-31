package decorator;

import flower.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemDecoratorTest {
    Item flower, bucket;

    @BeforeEach
    void setUp() {
        flower = new Flower(5, FlowerColor.RED, 10, FlowerType.ROSE);
        bucket = new FlowerBucket();
        ((FlowerBucket) bucket).addFlowerPack(new FlowerPack((Flower) flower, 5));
    }

    @Test
    void getDescription() {
        assertEquals("Red rose", flower.getDescription());
        flower = new PaperDecorator(flower);
        assertEquals("Red rose in paper package", flower.getDescription());

        assertEquals("Bucket with 5 red roses", bucket.getDescription());
        bucket = new BasketDecorator(bucket);
        assertEquals("Bucket with 5 red roses in basket", bucket.getDescription());
        bucket = new RibbonDecorator(bucket);
        assertEquals("Bucket with 5 red roses in basket with ribbon", bucket.getDescription());
    }

    @Test
    void price() {
        assertEquals(10, flower.price());
        flower = new PaperDecorator(flower);
        assertEquals(23, flower.price());

        assertEquals(50, bucket.price());
        bucket = new BasketDecorator(bucket);
        assertEquals(54, bucket.price());
        bucket = new RibbonDecorator(bucket);
        assertEquals(94, bucket.price());
    }
}