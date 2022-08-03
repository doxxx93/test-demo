package testdemo;

public class PasswordMeter {

    public PasswordStrength meter(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException();
        }
        boolean lengthCondition = password.length() >= 8;
        boolean hasUppercase = password.chars().anyMatch(Character::isUpperCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        int meets = 0;
        if (lengthCondition) {
            meets++;
        }
        if (hasUppercase) {
            meets++;
        }
        if (hasDigit) {
            meets++;
        }
        if (meets == 1 || meets == 0) {
            return PasswordStrength.WEAK;
        }
        if (meets == 2) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }
}

