package shop.payment;

public class EWalletPayment implements PaymentMethod{
    private String provider;
    private long balance;
    public EWalletPayment(String provider, long balance) {
        if (provider.isBlank() || (balance <= 0)){
            throw new IllegalArgumentException("provider can't be empty and balance needs to be greater than 0");
        }
        this.provider = provider;
        this.balance = balance;
    }


    public String getName(){
        return "E-Wallet" + provider;
    }

    public long getBalance(){
        return balance;
    }

    @Override 
    public boolean pay(long amount){
        if (amount <= 0){
            return false;
        }

        else if(amount > balance){
            return false;
        }

        else{
            return true;
        }
    }

    

}
