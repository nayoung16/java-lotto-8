package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.InputPriceValidator;
import lotto.validate.LottoNumValidator;

public class InputView {
    private static final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    private static final String PRICE_MSG = "개를 구매했습니다.";
    private static final String INPUT_NUM = "당첨번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUM = "보너스 번호를 입력해 주세요.";

    public static void inputPriceAndCount() {
        while (true) {
            try {
                System.out.println(INPUT_PRICE);
                int cost = parseIntOrThrow(Console.readLine());
                InputPriceValidator.validatePrice(cost);
                int lottoCount = cost / 1000;
                System.out.println(lottoCount + PRICE_MSG);
                break;
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void inputWinningNum() {
        while (true) {
            try {
                System.out.println(INPUT_NUM);
                String winningNum = Console.readLine();
                LottoNumValidator.isValidString(winningNum);
                break;
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void inputBonusNum() {
        while (true) {
            try {
                System.out.println(INPUT_BONUS_NUM);
                String bonusNum = Console.readLine();
                LottoNumValidator.isValidNumber(parseIntOrThrow(bonusNum));
                break;
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
}
