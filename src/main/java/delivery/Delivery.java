package delivery;

import flower.Item;

import java.util.LinkedList;

public interface Delivery {
    boolean deliver(LinkedList<Item> items);
}
