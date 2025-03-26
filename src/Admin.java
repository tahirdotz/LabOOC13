public class Admin {
    private final String username;
    private final String encryptedPassword;

    public Admin(String username, String encryptedPassword) {
        this.username = username;
        this.encryptedPassword = encryptedPassword;
    }

    public boolean validatePassword(String inputPassword) {
        return PasswordUtil.verify(inputPassword, encryptedPassword);
    }


    public String getUsername() {
        return username;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }
}