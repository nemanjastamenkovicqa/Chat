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

    public List<String> getMessagesContainingKeyword(String keyword) {
        List<String> keywordMessages = new ArrayList<>();
        for (String message : messageHistory) {
            if (message.contains(keyword)) {
                keywordMessages.add(message);
            }
        }
        return keywordMessages;
    }

    public int countKeywordOccurrences(String keyword) {
        int count = 0;
        for (String message : messageHistory) {
            if (message.contains(keyword)) {
                count++;
            }
        }
        return count;
    }

    public int getMessagesSentByUser(String username) {
        int count = 0;
        for (String message : messageHistory) {
            if (message.startsWith(username)) {
                count++;
            }
        }
        return count;
    }

    public int getMessagesReceivedByUser(String username) {
        int count = 0;
        for (String message : messageHistory) {
            if (message.contains(username) && !message.startsWith(username)) {
                count++;
            }
        }
        return count;
    }

    public List<String> getMessagesSentToUser(String username) {
        List<String> sentToUserMessages = new ArrayList<>();
        for (String message : messageHistory) {
            if (message.contains(username) && !message.startsWith(username)) {
                sentToUserMessages.add(message);
            }
        }
        return sentToUserMessages;
    }

    public boolean hasUserInteractedWith(String username) {
        for (String message : messageHistory) {
            if (message.contains(username)) {
                return true;
            }
        }
        return false;
    }
}
