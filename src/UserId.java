
public class UserId {
    private final String value;

    public UserId(String value) {
        if (value == null || value.length() < 5) {
            throw new IllegalArgumentException("Invalid user ID");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getDisplayValue() {
        return value.substring(0, 3) + " " + value.substring(3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserId userId = (UserId) o;
        return value.equals(userId.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}