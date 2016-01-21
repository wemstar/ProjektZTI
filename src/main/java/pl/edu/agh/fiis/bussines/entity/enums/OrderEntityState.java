package pl.edu.agh.fiis.bussines.entity.enums;

/**
 * Created by wemstar on 2016-01-07.
 * Enum reprezentujący stany zlecenia
 */
public enum OrderEntityState {
    NEW("NEW"),
    CONFIRMED("CONFIRMED"),
    REDY("REDY"),
    CLOSED("CLOSED");

    private final String name;

    OrderEntityState(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
