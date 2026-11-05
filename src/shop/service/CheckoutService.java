package shop.service;
import java.util.List;
import shop.model.Product;
import shop.payment.PaymentMethod;
import shop.shipping.Shippable;
import shop.shipping.ShippingService;

public class CheckoutService {
    public long subtotal(List<Product> items) {
        long total = 0;
        for (Product product : items) {
            total += product.getFinalPrice();
        }
        return total;
    }
    public int totalWeight(List<Product> items) {
        int grams = 0;
        for (Product product : items) {
            if (product instanceof Shippable shippable) { // a capability, not a class
                grams += shippable.getWeightGrams();
            }
        }
        return grams;
    }
        // TODO total(List<Product> items, ShippingService shipping)
        // TODO checkout(List<Product> items, ShippingService shipping, PaymentMethod payment)

}
