public class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage(String message, User recipient) {
        System.out.println(username + " sends message: " + message + " to " + recipient.getUsername());
        recipient.receiveMessage(message, this);
    }

    public void receiveMessage(String message, User sender) {
        System.out.println(username + " receives message: " + message + " from " + sender.getUsername());
    }
}
