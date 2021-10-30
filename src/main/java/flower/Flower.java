package flower;

import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

/**
 * Represent a flower
 */
@Getter
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
        updateDescription();
    }

    public void setPrice(double price) {
        assert (price >= 0);
        this.price = price;
    }

    @Override
    public double price() {
        return price;
    }

    @Override
    public String toString() {
        String description = color + " " + type;
        return description.charAt(0) + description.toLowerCase(Locale.ROOT).substring(1);
    }
}
