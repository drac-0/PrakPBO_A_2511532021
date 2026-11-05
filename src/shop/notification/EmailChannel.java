package shop.notification;

public class EmailChannel extends AbstractChannel {
    @Override
    protected String resolveRecipient(CustomerContact contact) {
        String email = contact.getEmail();
        if (email == null || email.isBlank() || !email.contains("@")) {
            return null;
        }
        return email;
    }

    @Override
    protected boolean deliver(String recipient, String message) {
        // Simulate email delivery
        System.out.println("[EMAIL to " + recipient + "] " + message);
        return true;
    }
}