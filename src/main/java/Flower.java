import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represent a flower
 */
@Getter @Setter @ToString
public class Flower {
    private double price, sepalLength;
    private FlowerColor color;
    private FlowerType type;

    public Flower(double sepalLength, FlowerColor color, double price, FlowerType type) {
        assert (sepalLength > 0 & price >= 0);
        this.sepalLength = sepalLength;
        this.price = price;
        this.color = color;
        this.type = type;
    }

    public void setPrice(double price) {
        assert (price >= 0);
        this.price = price;
    }

    public void setSepalLength(double sepalLength) {
        assert (sepalLength > 0);
        this.sepalLength = sepalLength;
    }

}
