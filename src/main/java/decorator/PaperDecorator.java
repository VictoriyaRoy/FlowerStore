package decorator;

import flower.Item;

public class PaperDecorator extends ItemDecorator{
    public PaperDecorator(Item item) {
        super(item);
    }

    @Override
    public double price() {
        return super.price() + 13;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " in paper package";
    }
}
