import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightRepository {
    private final List<Flight> flights;

    public FlightRepository() {
        this.flights = new ArrayList<>();
    }

    public void scheduleFlight(Flight flight) {
        flights.add(flight);
    }

    public Optional<Flight> findByNumber(FlightNumber flightNumber) {
        return flights.stream()
                .filter(f -> f.getFlightNumber().equals(flightNumber))
                .findFirst();
    }

    public List<Flight> getAllFlights() {
        return new ArrayList<>(flights);
    }

    public void deleteFlight(FlightNumber flightNumber) {
        flights.removeIf(f -> f.getFlightNumber().equals(flightNumber));
    }
}