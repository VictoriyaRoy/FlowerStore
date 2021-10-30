package delivery;

import flower.Item;

import java.util.LinkedList;

public class PostDeliveryStrategy implements Delivery{
    @Override
    public boolean deliver(LinkedList<Item> items) {
        System.out.println("Deliver by post:");
        for (Item deliver_item : items) {
            System.out.println("- " + deliver_item);
        }
        return true;
    }
}
