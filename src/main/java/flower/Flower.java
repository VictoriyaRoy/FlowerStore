package flower;

import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

/**
 * Represent a flower
 */
@Getter @Setter
public class Flower extends Item{
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

    @Override
    public double price() {
        return price;
    }

    public void setSepalLength(double sepalLength) {
        assert (sepalLength > 0);
        this.sepalLength = sepalLength;
    }

    @Override
    public String toString() {
        String description = color + " " + type + " with sepal length " + sepalLength;
        return "Flower(" + description.toLowerCase(Locale.ROOT) + ")";
    }
}
