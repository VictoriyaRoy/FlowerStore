import flower.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    Store store;
    FlowerBucket pink_bucket, expensive_bucket, cheap_bucket, tulip_bucket;

    @BeforeEach
    void setUp() {
        store = new Store();

        pink_bucket = new FlowerBucket(); //price: 132, pink tulip, pink rose
        expensive_bucket = new FlowerBucket(); //price: 450, red rose, pink rose
        cheap_bucket = new FlowerBucket(); //price:57, white chamomile
        tulip_bucket = new FlowerBucket(); //price:108, pink tulip

        Flower pink_rose = new Flower(3, FlowerColor.PINK, 10.0, FlowerType.ROSE);
        Flower red_rose = new Flower(2.5, FlowerColor.RED, 15.0, FlowerType.ROSE);
        Flower chamomile = new Flower(10, FlowerColor.WHITE, 3, FlowerType.CHAMOMILE);
        Flower tulip = new Flower(7, FlowerColor.PINK, 12.0, FlowerType.TULIP);

        pink_bucket.addFlowerPack(new FlowerPack(pink_rose, 6));
        pink_bucket.addFlowerPack(new FlowerPack(tulip, 9));
        expensive_bucket.addFlowerPack(new FlowerPack(red_rose, 20));
        expensive_bucket.addFlowerPack(new FlowerPack(pink_rose, 15));
        cheap_bucket.addFlowerPack(new FlowerPack(chamomile, 19));
        tulip_bucket.addFlowerPack(new FlowerPack(tulip, 9));

        store.addBucket(pink_bucket);
        store.addBucket(expensive_bucket);
        store.addBucket(cheap_bucket);
        store.addBucket(tulip_bucket);
    }

    @Test
    void addBucket() {
        FlowerBucket new_bucket = new FlowerBucket();

        HashSet<FlowerBucket> buckets = store.getFlowerBuckets();
        assertEquals (4, buckets.size());
        assert (!buckets.contains(new_bucket));

        store.addBucket(new_bucket);
        buckets = store.getFlowerBuckets();
        assertEquals (5, buckets.size());
        assert (buckets.contains(new_bucket));

        store.addBucket(new_bucket);
        buckets = store.getFlowerBuckets();
        assertEquals (5, buckets.size());
    }

    @Test
    void searchByPrice() {
        HashSet<FlowerBucket> buckets = store.search(50, 110); //price is in [50, 110]
        assertEquals(2, buckets.size());
        assert (buckets.contains(cheap_bucket));
        assert (buckets.contains(tulip_bucket));
    }

    @Test
    void searchByColor() {
        FlowerColor[] colors = {FlowerColor.PINK, FlowerColor.RED};
        HashSet<FlowerBucket> buckets = store.search(colors); //color: pink, red
        assertEquals(1, buckets.size());
        assert (buckets.contains(expensive_bucket));
    }

    @Test
    void searchByType() {
        FlowerType[] types = {FlowerType.ROSE, FlowerType.TULIP};
        HashSet<FlowerBucket> buckets = store.search(types); //types: rose, tulip
        assertEquals(1, buckets.size());
        assert (buckets.contains(pink_bucket));
    }

    @Test
    void searchByPriceColor() {
        FlowerColor[] colors = {FlowerColor.PINK};
        HashSet<FlowerBucket> buckets = store.search(100, 300, colors); //price is in [100, 300], color: pink
        assertEquals(2, buckets.size());
        assert (buckets.contains(pink_bucket));
        assert (buckets.contains(tulip_bucket));
    }

    @Test
    void searchByPriceType() {
        FlowerType[] types = {FlowerType.CHAMOMILE};
        HashSet<FlowerBucket> buckets = store.search(60, 300, types); //price is in [60, 300], type: chamomile
        assert (buckets.isEmpty());
    }

    @Test
    void searchByColorType() {
        FlowerColor[] colors = {FlowerColor.PINK};
        FlowerType[] types = {FlowerType.ROSE};
        HashSet<FlowerBucket> buckets = store.search(colors, types); //color: pink, type: rose;
        assertEquals(2, buckets.size());
        assert (buckets.contains(pink_bucket));
        assert (buckets.contains(expensive_bucket));
    }

    @Test
    void searchByPriceColorType() {
        FlowerColor[] colors = {FlowerColor.PINK};
        FlowerType[] types = {FlowerType.ROSE};
        HashSet<FlowerBucket> buckets = store.search(0, 200, colors, types); //price in [0,200], color: pink, type: rose;
        assertEquals(1, buckets.size());
        assert (buckets.contains(pink_bucket));
    }
}