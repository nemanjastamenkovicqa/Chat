import java.util.HashMap;
import java.util.Map;

public class PermissionManager {
    private Map<User, String> userPermissions;

    public PermissionManager() {
        this.userPermissions = new HashMap<>();
    }

    public void setUserPermission(User user, String permission) {
        userPermissions.put(user, permission);
    }

    public String getUserPermission(User user) {
        return userPermissions.getOrDefault(user, "DEFAULT");
    }

    public boolean hasPermission(User user, String permission) {
        String userPermission = getUserPermission(user);
        return userPermission.equals(permission);
    }
}
