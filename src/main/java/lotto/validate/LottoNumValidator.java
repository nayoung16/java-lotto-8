package lotto.validate;
import java.util.*;

public class LottoNumValidator {
    private static final String ERROR_EMPTY = "[ERROR] 로또 번호를 입력해야 합니다.";
    private static final String ERROR_COUNT = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String ERROR_NOT_NUMBER = "[ERROR] 로또 번호는 숫자여야 합니다.";
    private static final String ERROR_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_DUPLICATE = "[ERROR] 로또 번호에 중복이 있습니다.";

    public static String isValidString(String lottoNum) {
        validateNotEmpty(lottoNum);
        String[] tokens = splitAndValidateCount(lottoNum);
        validateDistinctAndParsable(tokens);
        return lottoNum;
    }

    public static void isValidNumber(Integer lottoNum) {
        if (lottoNum == null) throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        if (lottoNum < 1 || lottoNum > 45) throw new IllegalArgumentException(ERROR_RANGE);
    }

    private static void validateNotEmpty(String s) {
        if (s == null || s.trim().isEmpty()) throw new IllegalArgumentException(ERROR_EMPTY);
    }

    private static String[] splitAndValidateCount(String s) {
        String[] tokens = s.split(",");
        if (tokens.length != 6) throw new IllegalArgumentException(ERROR_COUNT);
        return tokens;
    }

    private static void validateDistinctAndParsable(String[] tokens) {
        Set<Integer> seen = new HashSet<>();
        for (String token : tokens) {
            int n = parseIntOrThrow(token.trim());
            isValidNumber(n);
            if (!seen.add(n)) throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    private static int parseIntOrThrow(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }
}
