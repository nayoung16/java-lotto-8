package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.validate.InputPriceValidator;
import lotto.validate.LottoNumValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    private static final String PRICE_MSG = "개를 구매했습니다.";
    private static final String INPUT_NUM = "당첨번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUM = "보너스 번호를 입력해 주세요.";

    public static int inputPriceAndCount() {
        while (true) {
            try {
                System.out.println(INPUT_PRICE);
                int cost = parseIntOrThrow(Console.readLine());
                InputPriceValidator.validatePrice(cost);
                System.out.println();
                int lottoCount = cost / 1000;
                System.out.println(lottoCount + PRICE_MSG);
                return lottoCount;
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Lotto inputWinningNum() {
        while (true) {
            try {
                System.out.println(INPUT_NUM);
                String winningNum = Console.readLine();
                LottoNumValidator.isValidString(winningNum);
                List<Integer> parsedNumList = parseList(winningNum);
                System.out.println();
                return new Lotto(parsedNumList);
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputBonusNum() {
        while (true) {
            try {
                System.out.println(INPUT_BONUS_NUM);
                String bonusNum = Console.readLine();
                int parsedNum = parseIntOrThrow(bonusNum);
                LottoNumValidator.isValidNumber(parsedNum);
                System.out.println();
                return parsedNum;
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int parseIntOrThrow(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    private static List<Integer> parseList(String s) {
        return Arrays.stream(s.split(","))
                .map(String::trim)
                .map(InputView::parseIntOrThrow)
                .collect(Collectors.toList());
    }
}
