import java.util.ArrayList;
import java.util.List;

public class NotificationManager {
    private List<Notification> notifications;

    public NotificationManager() {
        this.notifications = new ArrayList<>();
    }

    public void sendNotification(User recipient, String message) {
        Notification notification = new Notification(recipient, message);
        notifications.add(notification);
    }

    public List<Notification> getNotifications(User user) {
        List<Notification> userNotifications = new ArrayList<>();
        for (Notification notification : notifications) {
            if (notification.getRecipient().equals(user)) {
                userNotifications.add(notification);
            }
        }
        return userNotifications;
    }

    public void markAsRead(Notification notification) {
        notification.markAsRead();
    }
}

class Notification {
    private User recipient;
    private String message;
    private boolean read;

    public Notification(User recipient, String message) {
        this.recipient = recipient;
        this.message = message;
        this.read = false;
    }

    public User getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public boolean isRead() {
        return read;
    }

    public void markAsRead() {
        this.read = true;
    }
}
