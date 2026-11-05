package shop.payment;

public class BankTransferPayment implements PaymentMethod{
    String bankName;
    public BankTransferPayment(String bankName) {
        if (bankName.isBlank()){
            throw new IllegalArgumentException("Empty Bank Name");
        }
        this.bankName = bankName;
    }

    @Override 
    public String getName(){
        return "Transfer " + bankName;
    }

    @Override 
    public boolean pay(long amount){
    }
    

}
