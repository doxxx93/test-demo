package testdemo;

public class PasswordMeter {

    private static final int LENGTH_CONDITION = 8;

    public PasswordStrength meter(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException();
        }
        int meets = calculateMeets(password);
        if (meets == 1 || meets == 0) {
            return PasswordStrength.WEAK;
        }
        if (meets == 2) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }

    private static int calculateMeets(String password) {
        int meets = 0;
        if (isLongEnough(password)) {
            meets++;
        }
        if (hasUpperCase(password)) {
            meets++;
        }
        if (hasDigit(password)) {
            meets++;
        }
        return meets;
    }

    private static boolean isLongEnough(String password) {
        return password.length() >= LENGTH_CONDITION;
    }

    private static boolean hasDigit(String password) {
        return password.chars().anyMatch(Character::isDigit);
    }

    private static boolean hasUpperCase(String password) {
        return password.chars().anyMatch(Character::isUpperCase);
    }
}

