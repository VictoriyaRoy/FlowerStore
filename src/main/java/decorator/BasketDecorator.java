package decorator;

import flower.Item;

public class BasketDecorator extends ItemDecorator{

    public BasketDecorator(Item item) {
        super(item);
    }

    @Override
    public double price() {
        return super.price() + 4;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "in basket";
    }
}
