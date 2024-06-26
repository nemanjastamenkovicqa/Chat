public class User {
    private String username;
    private PrivateMessageService privateMessageService;
    private ChatRoom chatRoom;
    private PermissionManager permissionManager;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public void setPrivateMessageService(PrivateMessageService privateMessageService) {
        this.privateMessageService = privateMessageService;
    }

    public void setPermissionManager(PermissionManager permissionManager) {
        this.permissionManager = permissionManager;
    }

    public void sendPrivateMessage(User recipient, String message) {
        if (privateMessageService != null) {
            privateMessageService.sendPrivateMessage(this, recipient, message);
        }
    }

    public void receivePrivateMessage(String message, User sender) {
        System.out.println(username + " receives private message: " + message + " from " + sender.getUsername());
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

    public String getPermission() {
        if (permissionManager != null) {
            return permissionManager.getUserPermission(this);
        }
        return "DEFAULT";
    }

    public boolean hasUnreadMessages() {
        if (privateMessageService != null) {
            return privateMessageService.hasUnreadMessages(this);
        }
        return false;
    }

    public int getReceivedMessagesCount() {
        if (privateMessageService != null) {
            // Implement logic to count received messages
            // For now, return a placeholder value
            return 0;
        }
        return 0;
    }
    public int getUnreadMessagesCount() {
        if (privateMessageService != null) {
            return privateMessageService.getUnreadMessagesCount(this);
        }
        return 0;
    }
    public boolean hasSentMessages() {
        return privateMessageService != null && privateMessageService.getTotalSentMessages(this) > 0;
    }
    public int getTotalSentMessages() {
        if (privateMessageService != null) {
            return privateMessageService.getTotalSentMessages(this);
        }
        return 0;
    }
public void joinChatRoom(ChatRoom room) {
    if (chatRoom != null) {
        chatRoom.removeUser(this);
    }
    chatRoom = room;
    if (chatRoom != null) {
        chatRoom.addUser(this);
    }
}

}
