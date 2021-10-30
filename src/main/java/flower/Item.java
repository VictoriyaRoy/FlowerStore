package flower;

public abstract class Item {
    String description;

    public Item() {
    }

    public String getDescription() {
        return description;
    }

    public void updateDescription() {
        this.description = toString();
    }

    public abstract double price();
}
