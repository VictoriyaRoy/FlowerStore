package decorator;

import flower.Item;

public abstract class ItemDecorator extends Item {
    private Item item;

    public ItemDecorator(Item item) {
        this.item = item;
    }

    @Override
    public String getDescription() {
        return item.getDescription();
    }

    @Override
    public double price() {
        return item.price();
    }
}
