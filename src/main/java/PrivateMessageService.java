import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public void clearPrivateMessages() {
        privateMessageMap.clear();
    }

    public boolean hasUnreadMessages(User user) {
        return privateMessageMap.containsKey(user);
    }

    public void deletePrivateMessage(User sender, User recipient) {
        privateMessageMap.remove(recipient, sender);
    }

    public List<String> getPrivateMessages(User user) {
        List<String> userMessages = new ArrayList<>();
        for (Map.Entry<User, User> entry : privateMessageMap.entrySet()) {
            if (entry.getKey().equals(user)) {
                userMessages.add("You have a private message from " + entry.getValue().getUsername());
            }
        }
        return userMessages;
    }

    public List<String> getSentMessages(User user) {
        List<String> sentMessages = new ArrayList<>();
        for (Map.Entry<User, User> entry : privateMessageMap.entrySet()) {
            if (entry.getValue().equals(user)) {
                sentMessages.add("You sent a private message to " + entry.getKey().getUsername());
            }
        }
        return sentMessages;
    }
}
