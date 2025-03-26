public class PasswordUtil {

    public static String hash(String password) {
        return "hashed_" + password; 
    }

    public static boolean verify(String input, String hashed) {
        return hash(input).equals(hashed);
    }
}