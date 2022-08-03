package testdemo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordMeterTest {

    @DisplayName("null 입력이면 Exception 발생")
    @Test
    void nullInput() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> new PasswordMeter().meter(null));
    }

    @DisplayName("빈 값  입력이면 Exception 발생")
    @Test
    void emptyInput() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> new PasswordMeter().meter(""));
    }
}
