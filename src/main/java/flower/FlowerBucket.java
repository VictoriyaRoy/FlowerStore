package flower;

import lombok.Getter;

import java.util.HashSet;

/**
 * Represent a bucket of flowers
 */
@Getter
public class FlowerBucket extends Item{
    private HashSet<FlowerPack> flowerPacks;

    /**
     * Create new empty bucket
     */
    public FlowerBucket() {
        super();
        this.flowerPacks = new HashSet<>();
    }

    /**
     * Add new flower pack to bucket
     * @param pack - new flower pack
     */
    public void addFlowerPack(FlowerPack pack){
        flowerPacks.add(pack);
        updateDescription();
    }

    @Override
    public double price(){
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
        double price = price();
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


    @Override
    public String toString() {
        String description = "Bucket(";
        if (flowerPacks == null || flowerPacks.isEmpty()){
            description += "no flowers";
        } else{
            String packs = getFlowerPacks().toString();
            packs = packs.substring(1, packs.length()-1);
            description += packs;
        }
        return description + ")";
    }
}
