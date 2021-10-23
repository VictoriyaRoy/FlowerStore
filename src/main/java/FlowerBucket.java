import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Represent a bucket of flowers
 */
@Getter
public class FlowerBucket {
    private HashSet<FlowerPack> flowerPacks;

    /**
     * Create new empty bucket
     */
    public FlowerBucket() {
        this.flowerPacks = new HashSet<>();
    }

    /**
     * Add new flower pack to bucket
     * @param pack - new flower pack
     */
    public void addFlowerPack(FlowerPack pack){
        flowerPacks.add(pack);
    }

    public double getPrice(){
        double price = 0.0;
        for (FlowerPack pack : flowerPacks) {
            price += pack.getPrice();
        }
        return price;
    }

    public HashSet<FlowerColor> getColors(){
        HashSet<FlowerColor> colors = new HashSet<>();
        for (FlowerPack pack : flowerPacks) {
            colors.add(pack.getColor());
        }
        return colors;
    }

    public HashSet<FlowerType> getTypes() {
        HashSet<FlowerType> types = new HashSet<>();
        for (FlowerPack pack : flowerPacks) {
            types.add(pack.getType());
        }
        return types;
    }

    /**
     * Check if price of bucket in specified range
     * @param minPrice - minimal price of bucket
     * @param maxPrice - maximum price of bucket
     * @return true is satisfies criteria, false otherwise
     */
    public boolean checkPrice(double minPrice, double maxPrice) {
        double price = getPrice();
        return minPrice <= price && price <= maxPrice;
    }

    /**
     * Check if bucket has flowers of all needed colors
     * @param wantedColors - list of wanted colors
     * @return true is satisfies criteria, false otherwise
     */
    public boolean checkColors(FlowerColor[] wantedColors) {
        HashSet<FlowerColor> bucketColors = getColors();
        if (wantedColors == null) {
            return true;
        }
        for (FlowerColor color : wantedColors) {
            if (!bucketColors.contains(color)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if bucket has flowers of all needed types
     * @param wantedTypes - list of wanted types
     * @return true is satisfies criteria, false otherwise
     */
    public boolean checkFlowers(FlowerType[] wantedTypes) {
        HashSet<FlowerType> bucketTypes = getTypes();
        if (wantedTypes == null) {
            return true;
        }
        for (FlowerType type : wantedTypes) {
            if (!bucketTypes.contains(type)){
                return false;
            }
        }
        return true;
    }

}
