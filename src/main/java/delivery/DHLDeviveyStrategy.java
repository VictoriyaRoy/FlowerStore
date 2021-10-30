package delivery;

import flower.Item;

import java.util.LinkedList;

public class DHLDeviveyStrategy implements Delivery{
    @Override
    public boolean deliver(LinkedList<Item> items) {
        System.out.println("Deliver by DHL:");
        for (Item deliver_item : items) {
            System.out.println("- " + deliver_item);
        }
        return true;
    }
}
