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
}
