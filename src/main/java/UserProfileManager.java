import java.util.HashMap;
import java.util.Map;

public class UserProfileManager {
    private Map<User, UserProfile> userProfileMap;

    public UserProfileManager() {
        this.userProfileMap = new HashMap<>();
    }

    public void setUserProfile(User user, UserProfile profile) {
        userProfileMap.put(user, profile);
    }

    public UserProfile getUserProfile(User user) {
        return userProfileMap.getOrDefault(user, new UserProfile("Default", "", ""));
    }
}

class UserProfile {
    private String displayName;
    private String bio;
    private String profilePicture;

    public UserProfile(String displayName, String bio, String profilePicture) {
        this.displayName = displayName;
        this.bio = bio;
        this.profilePicture = profilePicture;
    }

    // Getter and setter methods for displayName, bio, and profilePicture
}
