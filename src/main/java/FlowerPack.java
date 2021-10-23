import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represent a pack of some similar flowers
 */
@Getter @Setter @ToString
public class FlowerPack {
    private Flower flower;
    private int amount;

    public FlowerPack(Flower flower, int amount) {
        this.flower = flower;
        assert (amount > 0);
        this.amount = amount;
    }

    public double getPrice(){
        return flower.getPrice() * amount;
    }

    public FlowerColor getColor() {
        return flower.getColor();
    }

    public FlowerType getType() {
        return flower.getType();
    }

    public void setAmount(int amount) {
        assert (amount > 0);
        this.amount = amount;
    }
}
