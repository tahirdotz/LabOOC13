public class FlightBooking {
    private final Flight flight;
    private int ticketCount;

    public FlightBooking(Flight flight, int ticketCount) {
        this.flight = flight;
        this.ticketCount = ticketCount;
    }

    public void addTickets(int additionalTickets) {
        ticketCount += additionalTickets;
    }

    public void removeTickets(int ticketsToRemove) {
        if (ticketsToRemove > ticketCount) {
            throw new IllegalArgumentException("Cannot remove more tickets than booked");
        }
        ticketCount -= ticketsToRemove;
    }
    
    public Flight getFlight() { return flight; }
    public int getTicketCount() { return ticketCount; }
}