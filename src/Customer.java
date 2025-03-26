import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.random.RandomGenerator;

public class Customer {
    private final UserId userId;
    private String name;
    private String email;
    private String phone;
    private final String password;
    private String address;
    private int age;
    private final List<FlightBooking> bookings;
    RandomGenerator random;

    public Customer(String name, String email, String password, String phone, String address, int age) {
        this.userId = new UserId(UUID.randomUUID().toString().substring(0, 8));
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.age = age;
        this.bookings = new ArrayList<>();
    }

    public void bookFlight(Flight flight, int numTickets) {
        if (numTickets <= 0) {
            throw new IllegalArgumentException("Number of tickets must be positive");
        }

        flight.bookSeats(numTickets);
        flight.registerCustomer(this);

        boolean existingBooking = false;
        for (FlightBooking booking : bookings) {
            if (booking.getFlight().equals(flight)) {
                booking.addTickets(numTickets);
                existingBooking = true;
                break;
            }
        }

        if (!existingBooking) {
            bookings.add(new FlightBooking(flight, numTickets));
        }
    }

    public void cancelFlight(Flight flight, int numTickets) {
        for (FlightBooking booking : bookings) {
            if (booking.getFlight().equals(flight)) {
                if (booking.getTicketCount() < numTickets) {
                    throw new IllegalArgumentException("Cannot cancel more tickets than booked");
                }

                flight.cancelSeats(numTickets);

                if (booking.getTicketCount() == numTickets) {
                    bookings.remove(booking);
                    flight.unregisterCustomer(this);
                } else {
                    booking.removeTickets(numTickets);
                }
                return;
            }
        }
        throw new IllegalArgumentException("No booking found for this flight");
    }

    public List<FlightBooking> getBookings() {
        return Collections.unmodifiableList(bookings);
    }

    public UserId getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
