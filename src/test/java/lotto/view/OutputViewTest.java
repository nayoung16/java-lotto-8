package lotto.view;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @Test
    void 로또_번호_문자열_변환_정상동작() {
        Lotto lotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        String result = OutputView.lottoToString(lotto);
        assertEquals("[1, 3, 5, 7, 9, 11]", result);
        System.out.println(result);
    }

    @Test
    void 로또_번호_정렬된_출력형식_확인() {
        Lotto lotto = new Lotto(List.of(45, 1, 33, 10, 5, 22));
        String result = OutputView.lottoToString(lotto);
        assertEquals("[1, 5, 10, 22, 33, 45]", result);
    }

    @Test
    void 수익률_계산() {
        int count = 8;
        long totalPrize = 5000;
        assertEquals(62.5, OutputView.printYieldResult(count, totalPrize));
    }
}