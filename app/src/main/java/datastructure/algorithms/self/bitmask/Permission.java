package datastructure.algorithms.self.bitmask;

public enum Permission {
    NONE(0),
    READ_USER(1),
    WRITE_USER(2),
    READ_ASSET(4),
    WRITE_ASSET(8)
    ;

    final int value;

    Permission(int value) {
        this.value = value;
    }
}
