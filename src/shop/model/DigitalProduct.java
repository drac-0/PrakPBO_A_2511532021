package shop.model;



public class DigitalProduct extends Product{
    private String downloadUrl;

    public DigitalProduct(String sku, String name, long price, String downloadUrl) {
        super(sku,name,price);
        if (downloadUrl.isEmpty()){
            throw new IllegalArgumentException("Download url can't be empty");
        }

    }
    public String category(){
        return "digital";
    }

    public String getUrl(){return downloadUrl;}


    

}
