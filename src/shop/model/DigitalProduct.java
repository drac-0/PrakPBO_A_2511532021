package shop.model;

public class DigitalProduct extends Product implements shop.discount.Discountable {
    private String downloadUrl;
    
    private static final int DIGITAL_DISCOUNT_PERCENT = 10;

    public DigitalProduct(String sku, String name, long price, String downloadUrl) {
        super(sku, name, price);
        if (downloadUrl == null || downloadUrl.isBlank()) {
            throw new IllegalArgumentException("Download url must not be blank");
        }
        this.downloadUrl = downloadUrl;
    }

    @Override
    public String category() {
        return "Digital";
    }

    @Override
    public int discountPercent() {
        return DIGITAL_DISCOUNT_PERCENT;
    }

    @Override
    public long getFinalPrice() {
        return applyDiscount(getPrice());
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }
}