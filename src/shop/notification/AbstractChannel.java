package shop.notification;

public abstract class AbstractChannel implements NotificationChannel {
    private int sentCount = 0;
    private String lastDelivered = "";

    @Override
    public final boolean send(CustomerContact contact, String message) {
        if (message == null || message.isBlank()) {
            return false;
        }
        
        String preparedMessage = prepare(message);
        String recipient = resolveRecipient(contact);
        
        if (recipient == null || recipient.isBlank()) {
            return false;
        }
        
        boolean success = deliver(recipient, preparedMessage);
        
        if (success) {
            sentCount++;
            lastDelivered = preparedMessage;
        }
        
        return success;
    }

    protected String prepare(String message) {
        return message;
    }

    protected abstract String resolveRecipient(CustomerContact contact);

    protected abstract boolean deliver(String recipient, String message);

    public int getSentCount() {
        return sentCount;
    }

    public String getLastDelivered() {
        return lastDelivered;
    }
}