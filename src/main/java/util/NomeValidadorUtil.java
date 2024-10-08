package util;

public class NomeValidadorUtil {

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 100;

    public static boolean validateName(String name) {
        if (name.isEmpty()) {
            return false;
        }

        String nameTrimmed = name.trim();
        if (nameTrimmed.length() < MIN_NAME_LENGTH || nameTrimmed.length() > MAX_NAME_LENGTH) {
            return false;
        }

        return nameTrimmed.matches("[a-zA-Z\\s]+");
    }
}
