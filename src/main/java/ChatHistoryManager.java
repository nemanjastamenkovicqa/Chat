import java.util.ArrayList;
import java.util.List;

public class ChatHistoryManager {
    private List<String> messageHistory;

    public ChatHistoryManager() {
        this.messageHistory = new ArrayList<>();
    }

    public void addMessageToHistory(String message) {
        messageHistory.add(message);
    }

    public List<String> getMessageHistory() {
        return messageHistory;
    }

    public int getTotalMessages() {
        return messageHistory.size();
    }

    public void clearMessageHistory() {
        messageHistory.clear();
    }

    public List<String> getLastMessages(int n) {
        int startIndex = Math.max(0, messageHistory.size() - n);
        return messageHistory.subList(startIndex, messageHistory.size());
    }

    public List<String> getMessagesByUser(String username) {
        List<String> userMessages = new ArrayList<>();
        for (String message : messageHistory) {
            if (message.contains(username)) {
                userMessages.add(message);
            }
        }
        return userMessages;
    }
}
