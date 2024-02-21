import java.util.HashMap;
import java.util.Map;

public class PrivateMessageService {
    private Map<User, User> privateMessageMap;

    public PrivateMessageService() {
        this.privateMessageMap = new HashMap<>();
    }

    public void sendPrivateMessage(User sender, User recipient, String message) {
        privateMessageMap.put(recipient, sender);
        recipient.receivePrivateMessage(message, sender);
    }

    public User getSender(User recipient) {
        return privateMessageMap.get(recipient);
    }

    public String getPrivateMessage(User sender, User recipient) {
        if (privateMessageMap.containsKey(recipient) && privateMessageMap.get(recipient).equals(sender)) {
            return "You have a private message from " + sender.getUsername();
        }
        return "No private message from " + sender.getUsername();
    }
}
