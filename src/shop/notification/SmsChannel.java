package shop.notification;

public class SmsChannel extends AbstractChannel {
    private final int maxLength;

    public SmsChannel(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    protected String resolveRecipient(CustomerContact contact) {
        String phone = contact.getPhone();
        if (phone == null || phone.isBlank() || !phone.startsWith("08")) {
            return null;
        }
        return phone;
    }

    @Override
    protected boolean deliver(String recipient, String message) {
        // Truncate message to maxLength and add "..." if needed
        String truncatedMessage = message;
        if (message.length() > maxLength) {
            truncatedMessage = message.substring(0, maxLength - 3) + "...";
        }
        System.out.println("[SMS to " + recipient + "] " + truncatedMessage);
        return true;
    }
}