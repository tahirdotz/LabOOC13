public interface DisplayService {
    void displayFlightsForUser(UserId userId);
    void displayPassengersForFlight(FlightNumber flightNumber);
    void displayAllFlights();
}