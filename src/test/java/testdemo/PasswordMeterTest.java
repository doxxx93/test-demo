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

    @DisplayName("모든 조건을 충족하면 강함")
    @Test
    void meetAllConditions() { // 리턴 타입이 있어야 함을 인지함.
        PasswordStrength result = passwordMeter.meter("abcABC123");
        assertThat(result).isEqualTo(PasswordStrength.STRONG);
        PasswordStrength result2 = passwordMeter.meter("123abcABC");
        assertThat(result2).isEqualTo(PasswordStrength.STRONG);
    }

    @DisplayName("길이가 8미만, 다른 조건은 충")
    @Test
    void meetDigitAndUppercaseConditionButTooShort() {
        PasswordStrength result = passwordMeter.meter("abcC123");
        assertThat(result).isEqualTo(PasswordStrength.NORMAL);
    }
}
