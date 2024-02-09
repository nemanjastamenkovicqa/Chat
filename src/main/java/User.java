public class User {
    private String username;
    private ChatRoom chatRoom;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public void sendMessage(String message, User recipient) {
        System.out.println(username + " sends message: " + message + " to " + recipient.getUsername());
        if (recipient != null) {
            recipient.receiveMessage(message, this);
        } else {
            chatRoom.broadcastMessage(message);
        }
    }

    public void receiveMessage(String message, User sender) {
        if (sender != null) {
            System.out.println(username + " receives message: " + message + " from " + sender.getUsername());
        } else {
            System.out.println(username + " receives broadcast message: " + message);
        }
    }
}
