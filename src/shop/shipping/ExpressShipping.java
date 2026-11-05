package shop.shipping;

public class ExpressShipping extends ShippingService{
    public ExpressShipping(){
        super("Ekpress");
    }

    @Override 
    protected long ratePerKg(){
        return 18_000;
    }

}
