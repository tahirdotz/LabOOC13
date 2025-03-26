import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private final List<Customer> customers;

    public CustomerRepository() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        if (emailExists(customer.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        customers.add(customer);
    }

    public Optional<Customer> findById(UserId userId) {
        return customers.stream()
                .filter(c -> c.getUserId().equals(userId))
                .findFirst();
    }

    public Optional<Customer> findByEmail(String email) {
        return customers.stream()
                .filter(c -> c.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public void removeCustomer(UserId userId) {
        customers.removeIf(c -> c.getUserId().equals(userId));
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers);
    }

    private boolean emailExists(String email) {
        return customers.stream().anyMatch(c -> c.getEmail().equalsIgnoreCase(email));
    }
}