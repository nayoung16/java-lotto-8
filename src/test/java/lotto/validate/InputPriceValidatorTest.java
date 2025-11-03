package lotto.validate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputPriceValidatorTest {

    @Test
    void validatePrice_예외발생하지않음() {
        assertDoesNotThrow(() -> InputPriceValidator.validatePrice(1000));
        assertDoesNotThrow(() -> InputPriceValidator.validatePrice(5000));
        assertDoesNotThrow(() -> InputPriceValidator.validatePrice(20000));
    }

    @Test
    void validatePrice_예외발생() {
        assertThatThrownBy(() -> InputPriceValidator.validatePrice(1500))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputPriceValidator.validatePrice(250))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputPriceValidator.validatePrice(999))
                .isInstanceOf(IllegalArgumentException.class);
    }
}