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
        if (meets == 1) {
            return PasswordStrength.WEAK;
        }
        if (!lengthCondition) {
            return PasswordStrength.NORMAL;
        }
        if (!hasUppercase) {
            return PasswordStrength.NORMAL;
        }
        if (!hasDigit) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }
}
