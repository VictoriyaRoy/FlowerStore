package delivery;

import flower.Item;

import java.util.LinkedList;

public class DHLDeviveyStrategy implements Delivery{
    @Override
    public boolean deliver(LinkedList<Item> items) {
        String stringItems = items.toString();
        System.out.println("Deliver by DHL: " + stringItems.substring(1, stringItems.length()-1));
        return true;
    }
}
