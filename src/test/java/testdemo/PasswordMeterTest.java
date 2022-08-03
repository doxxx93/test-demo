package testdemo;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordMeterTest {

    private final PasswordMeter passwordMeter = new PasswordMeter();

    @DisplayName("null 입력이면 Exception 발생")
    @Test
    void nullInput() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> passwordMeter.meter(null));
    }

    @DisplayName("빈 값  입력이면 Exception 발생")
    @Test
    void emptyInput() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> passwordMeter.meter(""));
    }

    private void assertPasswordStrength(String password, PasswordStrength expected) {
        PasswordStrength result = passwordMeter.meter(password);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("모든 조건을 충족하면 강함")
    @Test
    void meetAllConditions() { // 리턴 타입이 있어야 함을 인지함.
        assertPasswordStrength("abcABC123", PasswordStrength.STRONG);
        assertPasswordStrength("123abcABC", PasswordStrength.STRONG);
    }

    @DisplayName("길이가 8미만, 다른 조건은 충족")
    @Test
    void meetDigitAndUppercaseConditionButTooShort() {
        assertPasswordStrength("abcC123", PasswordStrength.NORMAL);
        assertPasswordStrength("123abcC", PasswordStrength.NORMAL);
        assertPasswordStrength("Cabc123", PasswordStrength.NORMAL);
    }

    @DisplayName("대문자 없음, 다른 조건 충족")
    @Test
    void meetDigitAndLengthConditionButNoUppercase() {
        assertPasswordStrength("abcd1234", PasswordStrength.NORMAL);
        assertPasswordStrength("1234abcddwqd", PasswordStrength.NORMAL);
    }

    @DisplayName("숫자 없음, 다른 조건 충족")
    @Test
    void meetUppercaseAndLengthConditionButNoDigit() {
        assertPasswordStrength("abcdABCD", PasswordStrength.NORMAL);
        assertPasswordStrength("ABCDabcd", PasswordStrength.NORMAL);
    }

    @DisplayName("길이만 충족")
    @Test
    void meetLengthConditionOnly() {
        assertPasswordStrength("asdbdsafsd", PasswordStrength.WEAK);
    }

    @DisplayName("대문자만 충족")
    @Test
    void meetUppercaseConditionOnly() {
        assertPasswordStrength("abcABC", PasswordStrength.WEAK);
    }
}
