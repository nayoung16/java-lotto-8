package lotto.validate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumValidatorTest {

    @Test
    void 숫자_검증_정상값_예외없음() {
        assertDoesNotThrow(() -> LottoNumValidator.isValidNumber(1));
        assertDoesNotThrow(() -> LottoNumValidator.isValidNumber(45));
        assertDoesNotThrow(() -> LottoNumValidator.isValidNumber(7));
    }

    @Test
    void 숫자_검증_예외_null_및_범위() {
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> LottoNumValidator.isValidNumber(null));
        assertTrue(exception1.getMessage().startsWith("[ERROR]"));

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> LottoNumValidator.isValidNumber(0));
        assertTrue(exception2.getMessage().startsWith("[ERROR]"));

        Exception exception3 = assertThrows(IllegalArgumentException.class, () -> LottoNumValidator.isValidNumber(46));
        assertTrue(exception3.getMessage().startsWith("[ERROR]"));
    }

    @Test
    void 문자열_검증_정상() {
        assertDoesNotThrow(() -> LottoNumValidator.isValidString("1,2,3,4,5,6"));
    }

    @Test
    void 문자열_검증_개수오류() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> LottoNumValidator.isValidString("1,2,3,4,5"));
        assertTrue(exception.getMessage().startsWith("[ERROR]"));
    }

    @Test
    void 문자열_검증_숫자아님() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> LottoNumValidator.isValidString("1,2,a,4,5,6"));
        assertTrue(exception.getMessage().startsWith("[ERROR]"));
    }

    @Test
    void 문자열_검증_중복존재() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> LottoNumValidator.isValidString("1,2,2,4,5,6"));
        assertTrue(exception.getMessage().startsWith("[ERROR]"));
    }

    @Test
    void 문자열_검증_공백허용() {
        assertDoesNotThrow(() -> LottoNumValidator.isValidString(" 1, 2 ,3,4 , 5,6 "));
    }
}