import java.util.Optional;

public interface AdminRepository {
    Optional<Admin> findByUsername(String username);
    void addAdmin(Admin admin);
}