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

    public boolean isProfileComplete(User user) {
        UserProfile profile = userProfileMap.get(user);
        if (profile != null) {
            return !profile.getDisplayName().isEmpty() && !profile.getBio().isEmpty() && !profile.getProfilePicture().isEmpty();
        }
        return false;
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
