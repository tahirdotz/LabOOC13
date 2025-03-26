public class FlightNumber {
    private final String value;

    public FlightNumber(String value) {
        if (value == null || value.length() < 3) {
            throw new IllegalArgumentException("Invalid flight number");
        }
        this.value = value.toUpperCase();
    }

    public String getValue() {
        return value;
    }

 
}