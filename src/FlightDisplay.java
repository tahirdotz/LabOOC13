public final class FlightDisplay {
    private FlightDisplay() {} 

    public static void displayCustomerFlights(Customer customer) {
        System.out.println("\nFlight bookings for customer: " + customer.getName());
        System.out.println("+----------------------+----------------+----------------+");
        System.out.println("| Flight Number        | Departure      | Tickets        |");
        System.out.println("+----------------------+----------------+----------------+");

        for (FlightBooking booking : customer.getBookings()) {
            Flight flight = booking.getFlight();
            System.out.printf("| %-20s | %-14s | %-14d |\n",
                    flight.getFlightNumber().getValue(),
                    flight.getDepartureCity().getName(),
                    booking.getTicketCount());
        }
        System.out.println("+----------------------+----------------+----------------+");
    }

    public static void displayFlightPassengers(Flight flight) {
        System.out.println("\nPassengers for flight: " + flight.getFlightNumber().getValue());
        System.out.println("+----------------------+----------------+----------------+");
        System.out.println("| Passenger Name       | User ID        | Tickets        |");
        System.out.println("+----------------------+----------------+----------------+");

        for (Customer customer : flight.getRegisteredCustomers()) {
            int tickets = customer.getBookings().stream()
                    .filter(b -> b.getFlight().equals(flight))
                    .mapToInt(FlightBooking::getTicketCount)
                    .sum();

            System.out.printf("| %-20s | %-14s | %-14d |\n",
                    customer.getName(),
                    customer.getUserId().getDisplayValue(),
                    tickets);
        }
        System.out.println("+----------------------+----------------+----------------+");
    }
}