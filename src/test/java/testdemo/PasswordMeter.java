package testdemo;

public class PasswordMeter {

    public PasswordStrength meter(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException();
        }
        boolean lengthCondition = password.length() >= 8;
        if (!lengthCondition) {
            return PasswordStrength.NORMAL;
        }
        boolean hasUppercase = password.chars().anyMatch(Character::isUpperCase);
        if (!hasUppercase) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }
}
