package shop.notification;

public class WhatsAppChannel extends AbstractChannel {
    @Override
    protected String resolveRecipient(CustomerContact contact) {
        String phone = contact.getPhone();
        if (phone == null || phone.isBlank()) {
            return null;
        }
        // Accept phone numbers starting with 08 or +62 and minimum length 10
        if ((phone.startsWith("08") || phone.startsWith("+62")) && phone.length() >= 10) {
            return phone;
        }
        return null;
    }

    @Override
    protected boolean deliver(String recipient, String message) {
        // Add prefix "[Toko UMKM] " to WhatsApp messages
        String prefixedMessage = "[Toko UMKM] " + message;
        System.out.println("[WA to " + recipient + "] " + prefixedMessage);
        return true;
    }
}