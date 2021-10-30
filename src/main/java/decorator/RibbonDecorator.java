package decorator;

import flower.Item;

public class RibbonDecorator extends ItemDecorator{
    public RibbonDecorator(Item item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with ribbon";
    }

    @Override
    public double price() {
        return super.price() + 40;
    }
}
