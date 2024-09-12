package util;

public class SenhaValidadorUtil {

    private static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[\\W_])[A-Za-z\\d\\W_]{8,}$";

    public static boolean isValidPassword(String password) {
        return password != null && password.matches(PASSWORD_REGEX);
    }
}
