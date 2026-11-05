package shop.payment;

/** Contract for every payment method. */
public interface PaymentMethod {
    String getName();
    
    /** @return true if the payment succeeds */
    boolean pay(long amount);
    
    /** Default admin fee: 0 for all payment methods */
    default long adminFee(long amount) { 
        return 0; 
    }
}