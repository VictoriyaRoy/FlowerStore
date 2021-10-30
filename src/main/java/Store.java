import flower.FlowerBucket;
import flower.FlowerColor;
import flower.FlowerType;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;

/**
 * Represents a Flower store
 */
@Getter @Setter
public class Store {
    HashSet<FlowerBucket> flowerBuckets;

    /**
     * Create new empty flower store
     */
    public Store(){
        flowerBuckets = new HashSet<>();
    }

    /**
     * Add new bucket to store
     * @param bucket - new bucket
     */
    public void addBucket(FlowerBucket bucket){
        flowerBuckets.add(bucket);
    }

    /**
     * Search buckets by specified criteria
     * @param minPrice - minimal price of bucket
     * @param maxPrice - maximum price of bucket
     * @param colors - colors which must be in bucket
     * @param flowers - types of flower which must be in bucket
     * @return HashSet of buckets that meet the criteria
     */
    public HashSet<FlowerBucket> search(double minPrice, double maxPrice, FlowerColor[] colors, FlowerType[] flowers){
        HashSet<FlowerBucket> filterBuckets = new HashSet<>();
        for (FlowerBucket bucket : flowerBuckets) {
            if (bucket.checkPrice( minPrice, maxPrice) && bucket.checkColors(colors)
                    && bucket.checkFlowers(flowers)){
                filterBuckets.add(bucket);
            }
        }
        return filterBuckets;
    }

    public HashSet<FlowerBucket> search(double minPrice, double maxPrice, FlowerColor[] colors){
        return search(minPrice, maxPrice, colors, null);
    }

    public HashSet<FlowerBucket> search(double minPrice, double maxPrice, FlowerType[] types){
        return search(minPrice, maxPrice, null, types);
    }

    public HashSet<FlowerBucket> search(FlowerColor[] colors, FlowerType[] types){
        return search(0, Double.MAX_VALUE, colors, types);
    }

    public HashSet<FlowerBucket> search(double minPrice, double maxPrice){
        return search(minPrice, maxPrice, null, null);
    }

    public HashSet<FlowerBucket> search(FlowerColor[] colors){
        return search(0, Double.MAX_VALUE, colors, null);
    }

    public HashSet<FlowerBucket> search(FlowerType[] types){
        return search(0, Double.MAX_VALUE, null, types);
    }

}
