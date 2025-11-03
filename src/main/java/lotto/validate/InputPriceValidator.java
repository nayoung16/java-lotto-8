package lotto.validate;

public class InputPriceValidator {
    private static final String PRICE_ERROR = "[ERROR] 구매 금액은 1,000원 단위로 입력해야 합니다.";
    public static void validatePrice(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(PRICE_ERROR);
        }
    }
}
