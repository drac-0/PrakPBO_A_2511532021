package shop.app;

import java.util.List;
import shop.model.DigitalProduct;
import shop.model.PhysicalProduct;
import shop.model.Product;
import shop.service.CheckoutService;
import shop.shipping.ExpressShipping;
import shop.shipping.RegularShipping;
import shop.shipping.ShippingService;
import shop.payment.CreditCardPayment;
import shop.payment.EWalletPayment;
import shop.payment.BankTransferPayment;
import shop.payment.PaymentMethod;
import shop.notification.CustomerContact;
import shop.notification.EmailChannel;
import shop.notification.NotificationService;
import shop.notification.SmsChannel;
import shop.notification.WhatsAppChannel;

public class TugasApp {
    public static void main(String[] args) {
        // L1: abstract class and abstract method
        Product coffee = new PhysicalProduct("KOPI-001", "Kopi Arabika Gayo 250g", 85_000, 300);
        Product rendang = new PhysicalProduct("RDG-002", "Rendang Kemasan 250g", 120_000, 400);
        Product ebook = new DigitalProduct("EBK-003", "E-book Resep Kue Nusantara", 50_000, "https://toko-umkm.example/unduh/ebk-003");

        List<Product> cart = List.of(coffee, rendang, ebook);

        CheckoutService checkout = new CheckoutService();
        ShippingService regular = new RegularShipping();
        ShippingService express = new ExpressShipping();

        // T1: Total with admin fee (Express)
        System.out.println("== T1: Total with biaya admin (Ekspres) ==");
        
        EWalletPayment wallet = new EWalletPayment("DompetKu", 300_000);
        PaymentMethod transfer = new BankTransferPayment("Bank Nagari");
        CreditCardPayment card = new CreditCardPayment("Siti Rahma", 1_000_000);
        
        long totalExpress = checkout.total(cart, express);
        System.out.println("E-Wallet DompetKu : Rp" + checkout.grandTotal(cart, express, wallet) + 
                          " (admin Rp" + wallet.adminFee(totalExpress) + ")");
        System.out.println("Transfer Bank Nagari : Rp" + checkout.grandTotal(cart, express, transfer) + 
                          " (admin Rp" + transfer.adminFee(totalExpress) + ")");
        System.out.println("Kartu Kredit (Siti Rahma) : Rp" + checkout.grandTotal(cart, express, card) + 
                          " (admin Rp" + card.adminFee(totalExpress) + ")");

        // Policy display
        System.out.println("\nKebijakan kartu kredit : " + card.policy());
        System.out.println("Kebijakan e-wallet : " + wallet.policy());

        // T2: Notification system
        System.out.println("\n== T2: Notifikasi status pesanan ==");
        
        // Create notification service and channels
        NotificationService notificationService = new NotificationService();
        notificationService.register(new EmailChannel());
        notificationService.register(new SmsChannel(shop.StudentInfo.SMS_MAX_LENGTH));
        notificationService.register(new WhatsAppChannel());
        
        // Anonymous class for console logging
        notificationService.register(new shop.notification.NotificationChannel() {
            @Override
            public String channelName() {
                return "LOG";
            }

            @Override
            public boolean send(shop.notification.CustomerContact contact, String message) {
                System.out.println("[LOG] " + contact.getName() + ": " + message);
                return true;
            }
        });

        // Create customer contacts
        CustomerContact siti = new CustomerContact("Siti Rahma", "siti@example.com", "081234567890");
        CustomerContact budi = new CustomerContact("Budi", "", "+628****5432");

        // Long message (>200 characters)
        String longMessage = "Pesanan ORD-0001 sudah dikirim dengan kurir Ekspres. Nomor resi akan muncul di aplikasi dalam 1x24 jam. Terima kasih telah berbelanja produk UMKM Sumatera Barat di toko kami!";

        // Send notifications
        System.out.println("Terkirim ke Siti lewat " + notificationService.broadcast(siti, longMessage) + " kanal");
        System.out.println("Terkirim ke Budi lewat " + notificationService.broadcast(budi, longMessage) + " kanal");
    }
}