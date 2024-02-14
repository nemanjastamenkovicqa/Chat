import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private List<User> participants;

    public ChatRoom() {
        this.participants = new ArrayList<>();
    }

    public void addParticipant(User user) {
        participants.add(user);
    }

    public void removeParticipant(User user) {
        participants.remove(user);
    }

    public void broadcastMessage(String message) {
        for (User participant : participants) {
            participant.receiveMessage(message, null);
        }
    }
}
