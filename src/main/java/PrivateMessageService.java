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
}
