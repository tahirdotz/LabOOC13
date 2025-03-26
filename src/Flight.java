import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Flight {
    private final String flightSchedule;
    private final FlightNumber flightNumber;
    private final City departureCity;
    private final City arrivalCity;
    private final String gate;
    private final double distanceInMiles;
    private final double distanceInKm;
    private final String flightTime;
    private int availableSeats;
    private final List<Customer> registeredCustomers;

    public Flight(String flightSchedule, FlightNumber flightNumber, int availableSeats,
                  City departureCity, City arrivalCity, double distanceInMiles,
                  double distanceInKm, String flightTime, String gate) {
        this.flightSchedule = flightSchedule;
        this.flightNumber = flightNumber;
        this.availableSeats = availableSeats;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.distanceInMiles = distanceInMiles;
        this.distanceInKm = distanceInKm;
        this.flightTime = flightTime;
        this.gate = gate;
        this.registeredCustomers = new ArrayList<>();
    }

    public boolean hasAvailableSeats(int requestedSeats) {
        return availableSeats >= requestedSeats;
    }

    public void bookSeats(int seats) {
        if (!hasAvailableSeats(seats)) {
            throw new IllegalStateException("Not enough available seats");
        }
        availableSeats -= seats;
    }

    public void cancelSeats(int seats) {
        availableSeats += seats;
    }

    public void registerCustomer(Customer customer) {
        if (!registeredCustomers.contains(customer)) {
            registeredCustomers.add(customer);
        }
    }

    public void unregisterCustomer(Customer customer) {
        registeredCustomers.remove(customer);
    }

    public String getArrivalTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy, HH:mm a ");
        LocalDateTime departureDateTime = LocalDateTime.parse(flightSchedule, formatter);

        String[] timeParts = flightTime.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);

        LocalDateTime arrivalTime = departureDateTime.plusHours(hours).plusMinutes(minutes);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("EE, dd-MM-yyyy HH:mm a");
        return arrivalTime.format(outputFormatter);
    }

    public List<Customer> getRegisteredCustomers() {
        return Collections.unmodifiableList(registeredCustomers);
    }

    public FlightNumber getFlightNumber() { return flightNumber; }
    public String getFlightSchedule() { return flightSchedule; }
    public City getDepartureCity() { return departureCity; }
    public City getArrivalCity() { return arrivalCity; }
    public String getGate() { return gate; }
    public String getFlightTime() { return flightTime; }
    public int getAvailableSeats() { return availableSeats; }
}