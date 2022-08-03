package testdemo;

public class PasswordMeter {

    public PasswordStrength meter(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException();
        }
        boolean lengthCondition = password.length() >= 8;
        boolean hasUppercase = password.chars().anyMatch(Character::isUpperCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        if (lengthCondition && !hasUppercase && !hasDigit) {
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
