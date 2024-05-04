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

    public int getTotalPrivateMessages() {
        return privateMessageMap.size();
    }

    public int getUnreadMessageCount(User user) {
        int count = 0;
        for (Map.Entry<User, User> entry : privateMessageMap.entrySet()) {
            if (entry.getKey().equals(user)) {
                count++;
            }
        }
        return count;
    }

    public int getUnreadMessagesCount(User user) {
        return getUnreadMessageCount(user);
    }

    public int getTotalSentMessages(User user) {
        int count = 0;
        for (Map.Entry<User, User> entry : privateMessageMap.entrySet()) {
            if (entry.getValue().equals(user)) {
                count++;
            }
        }
        return count;
    }
    public int countMessagesWithEmojis() {
        int count = 0;
        for (User message : privateMessageMap.keySet()) {
            if (containsEmoji(String.valueOf(message))) {
                count++;
            }
        }
        return count;
    }

    private boolean containsEmoji(String message) {
        int count = 0;
        for (int i = 0; i < message.length(); i++) {
            int type = Character.getType(message.charAt(i));
            if (type == Character.SURROGATE || type == Character.OTHER_SYMBOL) {
                count++;
            }
        }
        return count > 0;
    }

    public List<String> getPrivateMessagesWithEmojis(User user) {
    List<String> messagesWithEmojis = new ArrayList<>();
    for (Map.Entry<User, User> entry : privateMessageMap.entrySet()) {
        User recipient = entry.getKey();
        User sender = entry.getValue();
        if (recipient.equals(user) || sender.equals(user)) {
            String message = recipient.equals(user) ? "You have a private message from " + sender.getUsername() : "You sent a private message to " + recipient.getUsername();
            if (containsEmoji(message)) {
                messagesWithEmojis.add(message);
            }
        }
    }
    return messagesWithEmojis;
}

}
