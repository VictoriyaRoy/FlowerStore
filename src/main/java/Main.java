import delivery.PostDeliveryStrategy;
import flower.*;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        FlowerBucket bucket = new FlowerBucket();
//        System.out.println(bucket.getDescription());

        Flower rose = new Flower(2.5, FlowerColor.RED, 10.0, FlowerType.ROSE);
        FlowerPack rose_pack = new FlowerPack(rose, 9);
        bucket.addFlowerPack(rose_pack);
//        System.out.println(bucket.getDescription());

        Flower tulip = new Flower(2.5, FlowerColor.PINK, 12.0, FlowerType.TULIP);
        FlowerPack tulip_pack = new FlowerPack(tulip, 7);
        bucket.addFlowerPack(tulip_pack);

        LinkedList<Item> items = new LinkedList<>();
        items.add(tulip);
        items.add(bucket);
        items.add(rose);

        PostDeliveryStrategy deliver = new PostDeliveryStrategy();
        deliver.deliver(items);
    }
}
