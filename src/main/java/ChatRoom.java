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

}
