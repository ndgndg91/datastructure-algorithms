package datastructure.algorithms.self.bitmask;

import java.util.List;

public class PermissionManager {

    private int permissions;

    public PermissionManager(List<Permission> permissions) {
        this.permissions = permissions.stream()
                .mapToInt(p -> p.value)
                .sum();
    }

    public boolean hasPermission(Permission permission) {
        return (permissions & permission.value) == permission.value;
    }

    public void grantPermission(Permission permission) {
        permissions += permission.value;
    }

    public void revokePermission(Permission permission) {
        permissions -= permission.value;
    }

    @Override
    public String toString() {
        return Integer.toBinaryString(permissions);
    }
}
