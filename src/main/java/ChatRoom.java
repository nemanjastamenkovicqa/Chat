import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private List<User> participants;
    private List<String> chatHistory;

    public ChatRoom() {
        this.participants = new ArrayList<>();
        this.chatHistory = new ArrayList<>();
    }

    public void addParticipant(User user) {
        participants.add(user);
    }

    public void removeParticipant(User user) {
        participants.remove(user);
    }

    public boolean isParticipant(User user) {
        return participants.contains(user);
    }

    public void broadcastMessage(String message) {
        for (User participant : participants) {
            participant.receiveMessage(message, null);
            chatHistory.add(message);
        }
    }

    public void sendMessageToParticipant(String message, User recipient) {
        if (isParticipant(recipient)) {
            recipient.receiveMessage(message, null);
            chatHistory.add(message);
        }
    }

    public List<String> getChatHistory() {
        return chatHistory;
    }

    public void clearChatHistory() {
        chatHistory.clear();
    }

    public int getTotalMessagesSent() {
        return chatHistory.size();
    }

    public int getParticipantCount() {
        return participants.size();
    }

    public List<User> getParticipants() {
        return participants;
    }

    public boolean isChatEmpty() {
        return chatHistory.isEmpty();
    }
    public int getUnreadMessageCount(User user) {
        int unreadCount = 0;
        for (String message : chatHistory) {
            if (message.startsWith(user.getUsername()) && !message.contains(user.getUsername())) {
                unreadCount++;
            }
        }
        return unreadCount;
    }
    public int getTotalParticipants() {
        return participants.size();
    }
    public int getUnreadMessageCountByParticipant(User user) {
        int unreadCount = 0;
        for (String message : chatHistory) {
            if (message.startsWith(user.getUsername()) && !message.contains(user.getUsername())) {
                unreadCount++;
            }
        }
        return unreadCount;
    }



}
