import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class FlowerBucketTest {
    FlowerBucket bucket;
    FlowerPack rose_pack, tulip_pack, chamomile_pack;

    @BeforeEach
    void setUp() {
        bucket = new FlowerBucket();
        Flower rose = new Flower(2.5, FlowerColor.RED, 10.0, FlowerType.ROSE);
        rose_pack = new FlowerPack(rose, 9);
        bucket.addFlowerPack(rose_pack);

        Flower tulip = new Flower(8.0, FlowerColor.PINK, 15.0, FlowerType.TULIP);
        tulip_pack = new FlowerPack(tulip, 6);
        bucket.addFlowerPack(tulip_pack);

        Flower chamomile = new Flower(7.0, FlowerColor.WHITE, 5.0, FlowerType.CHAMOMILE);
        chamomile_pack = new FlowerPack(chamomile, 20);
    }

    @Test
    void addFlowerPack() {
        HashSet<FlowerPack> packs = bucket.getFlowerPacks();
        assert (!packs.isEmpty());
        assert (packs.contains(rose_pack));
        assert (packs.contains(tulip_pack));
        assert (!packs.contains(chamomile_pack));

        bucket.addFlowerPack(chamomile_pack);
        assert (packs.contains(chamomile_pack));
    }

    @Test
    void getPrice() {
        assertEquals(180, bucket.price());
        bucket.addFlowerPack(chamomile_pack);
        assertEquals(280, bucket.price());
    }

    @Test
    void getColors() {
        HashSet<FlowerColor> colors = bucket.getColors();
        assert (colors.contains(FlowerColor.RED));
        assert (colors.contains(FlowerColor.PINK));
        assert (!colors.contains(FlowerColor.WHITE));

        bucket.addFlowerPack(chamomile_pack);
        colors = bucket.getColors();
        assert (colors.contains(FlowerColor.WHITE));
    }

    @Test
    void getTypes() {
        HashSet<FlowerType> colors = bucket.getTypes();
        assert (colors.contains(FlowerType.ROSE));
        assert (colors.contains(FlowerType.TULIP));
        assert (!colors.contains(FlowerType.CHAMOMILE));

        bucket.addFlowerPack(chamomile_pack);
        colors = bucket.getTypes();
        assert (colors.contains(FlowerType.CHAMOMILE));
    }
}