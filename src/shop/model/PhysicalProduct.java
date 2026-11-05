package shop.model;

public class PhysicalProduct extends Product implements shop.shipping.Shippable {
    private final int weightGrams;

    public PhysicalProduct(String sku, String name, long price, int weightGrams) {
        super(sku, name, price);
        if (weightGrams <= 0) {
            throw new IllegalArgumentException("Weight Grams must be greater than 0");
        }
        this.weightGrams = weightGrams;
    }

    @Override
    public String category() {
        return "Fisik";
    }

    @Override
    public int getWeightGrams() {
        return weightGrams;
    }
}